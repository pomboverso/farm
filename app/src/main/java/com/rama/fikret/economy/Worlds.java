package com.rama.fikret.economy;

import com.rama.fikret.game.Maps;

public final class Worlds {
    private Worlds() {
    }

    public static final int GARDENS_PER_WORLD = 10;

    public static final int ANGEL_WORLD = 0;
    public static final double ANGEL_DIVISOR = 4e11 / 9;
    public static final double ANGEL_BONUS = 0.02;

    public static final String CURRENCY_LAKE = "DOP";
    public static final String CURRENCY_FOREST = "BRL";
    public static final String CURRENCY_CAVE = "VND";
    public static final String CURRENCY_VOLCANO = "IDR";
    public static final String CURRENCY_NUCLEAR = "CNY";
    public static final String CURRENCY_ARCTIC = "RUB";
    public static final String CURRENCY_BUBBLEGUM = "BSD";
    public static final String CURRENCY_SPACE = "JPY";
    public static final String CURRENCY_NIGHTMARE = "EUR";

    public static final double START_MONEY = 4;

    private static final double[] PLACEHOLDER_MANAGER_COSTS = {
            1e3, 1.5e4, 1e5, 5e5, 1.2e6, 1e7, 1.11e8, 5.55e8, 1e10, 1e11
    };

    private static final double GUIDE_BIRD_COST = 1e33;

    public static final double ACCOUNTANT_COST_FACTOR = 0.9;
    private static final double[] LAKE_ACCOUNTANT_COSTS = {
            10, 100, 1e3, 9999, 1e5, 1e7, 1e8, 1e9, 1e10, 1e11
    };

    public static final double DISCOUNT_COST_DIVISOR = 100000;
    private static final double[] LAKE_DISCOUNT_COSTS = {
            10e102, 75e105, 250e108, 100e111, 50e114, 3e117, 750e117, 3e120, 33e123, 9e126
    };

    public static final double UPGRADE_VALUE_FACTOR = 100;
    public static final double UPGRADE_SPEED_FACTOR = 250;
    public static final double UPGRADE_GROWTH = 10;
    public static final int UPGRADE_MAX_LEVEL = 10;
    public static final double UPGRADE_MIN_STEP = 1.05;

    public static final class GardenDef {
        public final String name;
        public final double baseCost;
        public final double coefficient;
        public final double cycleSeconds;
        public final double baseRevenue;

        GardenDef(String name, double baseCost, double coefficient, double cycleSeconds, double baseRevenue) {
            this.name = name;
            this.baseCost = baseCost;
            this.coefficient = coefficient;
            this.cycleSeconds = cycleSeconds;
            this.baseRevenue = baseRevenue;
        }
    }

    public static final class WorldDef {
        public final int stageId;
        public final String name;
        public final GardenDef[] gardens;
        public final String currency;
        public final double[] managerCosts;
        public final double travelManagerCost;
        public final double[] accountantCosts;
        public final double[] discountCosts;
        public final boolean placeholderPrices;

        WorldDef(int stageId, String name, String currency, GardenDef[] gardens,
                 double[] managerCosts, double travelManagerCost,
                 double[] accountantCosts, double[] discountCosts, boolean placeholderPrices) {
            this.stageId = stageId;
            this.name = name;
            this.currency = currency;
            this.gardens = gardens;
            this.managerCosts = managerCosts;
            this.travelManagerCost = travelManagerCost;
            this.accountantCosts = accountantCosts;
            this.discountCosts = discountCosts;
            this.placeholderPrices = placeholderPrices;
        }
    }

    private static final double[][] LAKE_NUMBERS = {
            {3.7, 1.07, 0.6, 1},
            {60, 1.15, 3, 60},
            {720, 1.14, 6, 540},
            {8640, 1.13, 12, 4320},
            {103680, 1.12, 24, 51840},
            {1244160, 1.11, 96, 622080},
            {14929920, 1.1, 384, 7464960},
            {179159040, 1.09, 1536, 89579520},
            {2149908480d, 1.08, 6144, 1074954240d},
            {25789901760d, 1.07, 36864, 29668737024d},
    };

    private static final String[] LAKE_NAMES = {
            "Yuca", "Mango", "Cajuil", "Guayaba", "Carambola",
            "Jobo", "Papaya", "Yautía", "Mamey", "Guanabana"
    };

    // Brazil
    private static final String[] FOREST_NAMES = {
            "Abacaxi", "Maracujá", "Pitanga", "Jabuticaba", "Açaí",
            "Cupuaçu", "Guaraná", "Acerola", "Bacaba", "Tucumã"
    };

    // Vietnam
    private static final String[] CAVE_NAMES = {
            "Nhãn", "Vải", "Bưởi", "Sấu", "Trám đen",
            "Dâu da đất", "Thị", "Táo mèo", "Mắc mật", "Bứa"
    };

    // Indonesia
    private static final String[] VOLCANO_NAMES = {
            "Salak", "Durian", "Manggis", "Rambutan", "Duku",
            "Kepel", "Matoa", "Duwet", "Gandaria", "Kemang"
    };

    // China: 杨梅, 枣, 猕猴桃, 五味子, 山楂, 黄皮, 悬钩子, 野梨, 柿, 酸枣
    private static final String[] NUCLEAR_NAMES = {
            "Yángméi", "Zǎo", "Míhóutáo", "Wǔwèizǐ", "Shānzhā",
            "Huángpí", "Xuángōuzi", "Yělí", "Shì", "Suānzǎo"
    };

    // Russia: Морошка, Брусника, Черника, Голубика, Водяника, Княженика, Костяника, Жимолость, Рябина, Шиповник
    private static final String[] ARCTIC_NAMES = {
            "Moroshka", "Brusnika", "Chernika", "Golubika", "Vodyanika",
            "Knyazhenika", "Kostyanika", "Zhimolost", "Ryabina", "Shipovnik"
    };

    // Bahamas
    private static final String[] BUBBLEGUM_NAMES = {
            "Guana berry", "Governor's plum", "Darling plum", "Pigeon plum", "Coco plum",
            "Sea grape", "Saffron plum", "Andros wild guava", "Sapodilla", "Sugar apple"
    };

    // Japan: アケビ, サルナシ, ヤマブドウ, シークヮーサー, スダチ, カボス, ユズ, ヤマモモ, ムベ, ハスカップ
    private static final String[] SPACE_NAMES = {
            "Akebi", "Sarunashi", "Yamabudō", "Shīkwāsā", "Sudachi",
            "Kabosu", "Yuzu", "Yamamomo", "Mube", "Haskappu"
    };

    // Spain
    private static final String[] NIGHTMARE_NAMES = {
            "Granada", "Cereza", "Uva tinta", "Higo", "Madroño",
            "Tomate", "Pimiento choricero", "Remolacha", "Lombarda", "Frambuesa"
    };

    private static GardenDef[] build(String[] names, double[][] numbers) {
        GardenDef[] result = new GardenDef[GARDENS_PER_WORLD];
        for (int i = 0; i < GARDENS_PER_WORLD; i++) {
            result[i] = new GardenDef(names[i], numbers[i][0], numbers[i][1], numbers[i][2], numbers[i][3]);
        }
        return result;
    }

    private static GardenDef[] buildFromLake(String[] names, double timeScale, double coefficientOffset) {
        double[][] numbers = new double[GARDENS_PER_WORLD][];
        for (int i = 0; i < GARDENS_PER_WORLD; i++) {
            double[] base = LAKE_NUMBERS[i];
            numbers[i] = i == 0 ? base.clone() : new double[]{
                    base[0],
                    Math.round((base[1] + coefficientOffset) * 10000d) / 10000d,
                    base[2] * timeScale,
                    base[3]
            };
        }
        return build(names, numbers);
    }

    public static final WorldDef[] ALL = {
            new WorldDef(Maps.BEACH, "Lake", CURRENCY_LAKE,
                    build(LAKE_NAMES, LAKE_NUMBERS),
                    PLACEHOLDER_MANAGER_COSTS, GUIDE_BIRD_COST,
                    LAKE_ACCOUNTANT_COSTS, LAKE_DISCOUNT_COSTS, false),
            // Farm order below is also the save-file world index: only ever append.
            farm(Maps.FOREST, "Forest", CURRENCY_FOREST, FOREST_NAMES, 1.1, 0),
            farm(Maps.CAVE, "Cave", CURRENCY_CAVE, CAVE_NAMES, 1.2, 0),
            farm(Maps.VOLCANO, "Volcano", CURRENCY_VOLCANO, VOLCANO_NAMES, 1.3, 0.005),
            farm(Maps.NUCLEAR, "Nuclear", CURRENCY_NUCLEAR, NUCLEAR_NAMES, 1.4, 0.005),
            farm(Maps.ARCTIC, "Arctic", CURRENCY_ARCTIC, ARCTIC_NAMES, 1.5, 0.01),
            farm(Maps.BUBBLEGUM_LAND, "Bubblegum land", CURRENCY_BUBBLEGUM, BUBBLEGUM_NAMES, 1.6, 0.01),
            farm(Maps.SPACE, "Space", CURRENCY_SPACE, SPACE_NAMES, 1.7, 0.015),
            farm(Maps.NIGHTMARE, "Nightmare", CURRENCY_NIGHTMARE, NIGHTMARE_NAMES, 1.8, 0.02),
    };

    private static WorldDef farm(int stageId, String name, String currency, String[] names,
                                 double timeScale, double coefficientOffset) {
        return new WorldDef(stageId, name, currency,
                buildFromLake(names, timeScale, coefficientOffset),
                PLACEHOLDER_MANAGER_COSTS, GUIDE_BIRD_COST,
                null, null, true);
    }

    private static final double[][][][] UPGRADE_PRICES = buildUpgradePrices();

    private static double[][][][] buildUpgradePrices() {
        double[][][][] table = new double[ALL.length][UPGRADE_MAX_LEVEL][2][GARDENS_PER_WORLD];
        for (int w = 0; w < ALL.length; w++) {
            double previous = 0;
            for (int tier = 0; tier < UPGRADE_MAX_LEVEL; tier++) {
                for (int speed = 0; speed < 2; speed++) {
                    double factor = speed == 1 ? UPGRADE_SPEED_FACTOR : UPGRADE_VALUE_FACTOR;
                    for (int g = 0; g < GARDENS_PER_WORLD; g++) {
                        double natural = ALL[w].gardens[g].baseCost * factor * Math.pow(UPGRADE_GROWTH, tier);
                        double price = Math.max(natural, previous * UPGRADE_MIN_STEP);
                        table[w][tier][speed][g] = price;
                        previous = price;
                    }
                }
            }
        }
        return table;
    }

    public static double upgradePrice(int world, int tier, boolean speed, int garden) {
        return UPGRADE_PRICES[world][tier][speed ? 1 : 0][garden];
    }

    public static String currencyOf(int world) {
        return ALL[world].currency;
    }

    public static int indexOfStage(int stageId) {
        for (int i = 0; i < ALL.length; i++) {
            if (ALL[i].stageId == stageId) {
                return i;
            }
        }
        return -1;
    }

    public static String stageName(int stageId) {
        switch (stageId) {
            case Maps.BEACH:
                return "Lake";
            case Maps.FOREST:
                return "Forest";
            case Maps.CAVE:
                return "Cave";
            case Maps.VOLCANO:
                return "Volcano";
            case Maps.NUCLEAR:
                return "Nuclear";
            case Maps.ARCTIC:
                return "Arctic";
            case Maps.BUBBLEGUM_LAND:
                return "Bubblegum land";
            case Maps.SPACE:
                return "Space";
            case Maps.NIGHTMARE:
                return "Nightmare";
            case Maps.ARCTIC_NEST:
                return "Arctic secret farm";
            default:
                return "Stage " + stageId;
        }
    }

    public static final int[] ALL_STAGE_IDS = {
            Maps.BEACH, Maps.FOREST, Maps.CAVE, Maps.VOLCANO, Maps.NUCLEAR, Maps.ARCTIC,
            Maps.BUBBLEGUM_LAND, Maps.SPACE, Maps.NIGHTMARE, Maps.ARCTIC_NEST
    };
}
