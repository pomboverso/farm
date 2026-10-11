package com.rama.fikret.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Blizzard {
    private static final float SPEED_X = 200f;
    private static final float SPEED_Y = 100f;

    private static final int FLAKE_PX = 8;          // on-screen size of one flake, in device pixels
    private static final int GRID = 96;             // flakes per tile side (tile = 96 * 8 = 768 px)
    private static final int BLOCK = 6;             // the grid is split into 6x6 blocks...
    private static final float SECOND_FLAKE = 0.7f; // ...with one flake each and a 70% chance of a second

    private final Bitmap flakes;
    private final int tileSize = GRID * FLAKE_PX;
    private final Paint paint = new Paint();
    private final Rect dst = new Rect();
    private float offsetX;
    private float offsetY;

    public Blizzard() {
        int[] pixels = new int[GRID * GRID];
        Random random = new Random();
        for (int by = 0; by < GRID; by += BLOCK) {
            for (int bx = 0; bx < GRID; bx += BLOCK) {
                int count = random.nextFloat() < SECOND_FLAKE ? 2 : 1;
                for (int i = 0; i < count; i++) {
                    int x = bx + random.nextInt(BLOCK);
                    int y = by + random.nextInt(BLOCK);
                    pixels[y * GRID + x] = 0xFFFFFFFF;
                }
            }
        }
        flakes = Bitmap.createBitmap(GRID, GRID, Bitmap.Config.ARGB_8888);
        flakes.setPixels(pixels, 0, GRID, 0, 0, GRID, GRID);
        paint.setFilterBitmap(false);
    }

    public void update(long deltaMs) {
        float seconds = deltaMs / 1000f;
        offsetX = wrap(offsetX + SPEED_X * seconds);
        offsetY = wrap(offsetY + SPEED_Y * seconds);
    }

    private float wrap(float value) {
        value %= tileSize;
        return value < 0 ? value + tileSize : value;
    }

    public void draw(Canvas canvas, int width, int height) {
        int startX = (int) offsetX - tileSize;
        int startY = (int) offsetY - tileSize;
        for (int x = startX; x < width; x += tileSize) {
            for (int y = startY; y < height; y += tileSize) {
                dst.set(x, y, x + tileSize, y + tileSize);
                canvas.drawBitmap(flakes, null, dst, paint);
            }
        }
    }
}
