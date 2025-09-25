import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class TimeManager {
    private boolean isDay = true;
    private final ColorManager colorManager;
    private Random random;

    class FirColors {
        private Color treeColor;
        private Color trunkColor;

        public FirColors(Color TREE_COLOR, Color TRUNK_COLOR) {
            this.treeColor = TREE_COLOR;
            this.trunkColor = TRUNK_COLOR;
        }

        public Color getTreeColor() {
            return treeColor;
        }

        public Color getTrunkColor() {
            return trunkColor;
        }
    }

    class AppleTreeColors {
        private  Color treeColor;
        private  Color trunkColor;
        private  Color appleColor;

        public AppleTreeColors(Color TREE_COLOR, Color TRUNK_COLOR, Color appleColor) {
            this.treeColor = TREE_COLOR;
            this.trunkColor = TRUNK_COLOR;
            this.appleColor = appleColor;
        }

        public Color getTreeColor() {
            return treeColor;
        }

        public Color getTrunkColor() {
            return trunkColor;
        }

        public Color getAppleColor() {
            return appleColor;
        }
    }

    class HomeColors {
        private Color colorOfPipe;
        private Color colorOfRoof;
        private Color colorOfHome;
        private Color colorOfShutters;
        private Color colorOfWindows;
        private Color colorOfDoor;
        private Color colorOfInsideOfDoor;
        private Color colorOfDoorHandle;
        private Color colorOfWindowSill;
        private Color colorOfRungs;

        public HomeColors(Color colorOfPipe, Color colorOfRoof, Color colorOfHome, Color colorOfShutters,
                          Color colorOfWindows, Color colorOfDoor, Color colorOfInsideOfDoor,
                          Color colorOfDoorHandle, Color colorOfWindowSill, Color colorOfRungs) {
            this.colorOfPipe = colorOfPipe;
            this.colorOfRoof = colorOfRoof;
            this.colorOfHome = colorOfHome;
            this.colorOfShutters = colorOfShutters;
            this.colorOfWindows = colorOfWindows;
            this.colorOfDoor = colorOfDoor;
            this.colorOfInsideOfDoor = colorOfInsideOfDoor;
            this.colorOfDoorHandle = colorOfDoorHandle;
            this.colorOfWindowSill = colorOfWindowSill;
            this.colorOfRungs = colorOfRungs;
        }

        public Color getColorOfPipe() {
            return colorOfPipe;
        }

        public Color getColorOfRoof() {
            return colorOfRoof;
        }

        public Color getColorOfHome() {
            return colorOfHome;
        }

        public Color getColorOfShutters() {
            return colorOfShutters;
        }

        public Color getColorOfWindows() {
            return colorOfWindows;
        }

        public Color getColorOfDoor() {
            return colorOfDoor;
        }

        public Color getColorOfInsideOfDoor() {
            return colorOfInsideOfDoor;
        }

        public Color getColorOfDoorHandle() {
            return colorOfDoorHandle;
        }

        public Color getColorOfWindowSill() {
            return colorOfWindowSill;
        }

        public Color getColorOfRungs() {
            return colorOfRungs;
        }
    }

    class FlowerColors {
        private Color colorOfCenterFlower;
        private Color colorOfPetals;
        private Color colorOfStem;

        public FlowerColors(Color colorOfCenterFlower, Color colorOfPetals, Color colorOfStem) {
            this.colorOfCenterFlower = colorOfCenterFlower;
            this.colorOfPetals = colorOfPetals;
            this.colorOfStem = colorOfStem;
        }

        public Color getColorOfCenterFlower() {
            return colorOfCenterFlower;
        }

        public Color getColorOfPetals() {
            return colorOfPetals;
        }

        public Color getColorOfStem() {
            return colorOfStem;
        }
    }

    class LamppostColors {
        private Color colorPost;
        private Color colorLamp;

        public LamppostColors(Color colorPost, Color colorLamp) {
            this.colorPost = colorPost;
            this.colorLamp = colorLamp;
        }

        public Color getColorPost() {
            return colorPost;
        }

        public Color getColorLamp() {
            return colorLamp;
        }
    }

    class LakeColors {
        private Color colorOfLake, colorOfGlare, colorOfWaterLily;

        public LakeColors(Color colorOfLake, Color colorOfGlare, Color colorOfWaterLily) {
            this.colorOfLake = colorOfLake;
            this.colorOfGlare = colorOfGlare;
            this.colorOfWaterLily = colorOfWaterLily;
        }

        public Color getColorOfLake() {
            return colorOfLake;
        }

        public Color getColorOfGlare() {
            return colorOfGlare;
        }

        public Color getColorOfWaterLily() {
            return colorOfWaterLily;
        }
    }

    class DuckColors {
        private Color colorOfBeak, colorOfNeck, colorOfHead, colorOfEye, colorOfInsideOfEye, colorOfBody, colorOfWing;

        public DuckColors(Color colorOfBeak, Color colorOfNeck, Color colorOfHead, Color colorOfEye, Color colorOfInsideOfEye, Color colorOfBody, Color colorOfWing) {
            this.colorOfBeak = colorOfBeak;
            this.colorOfNeck = colorOfNeck;
            this.colorOfHead = colorOfHead;
            this.colorOfEye = colorOfEye;
            this.colorOfInsideOfEye = colorOfInsideOfEye;
            this.colorOfBody = colorOfBody;
            this.colorOfWing = colorOfWing;
        }

        public Color getColorOfBeak() {
            return colorOfBeak;
        }

        public Color getColorOfNeck() {
            return colorOfNeck;
        }

        public Color getColorOfHead() {
            return colorOfHead;
        }

        public Color getColorOfEye() {
            return colorOfEye;
        }

        public Color getColorOfInsideOfEye() {
            return colorOfInsideOfEye;
        }

        public Color getColorOfBody() {
            return colorOfBody;
        }

        public Color getColorOfWing() {
            return colorOfWing;
        }
    }


    private final ArrayList<Color> daySkyPalette = new ArrayList<>(Arrays.asList(
            new Color(135, 206, 235),
            new Color(173, 216, 230),
            new Color(190, 230, 255),
            new Color(190, 230, 255),
            new Color(190, 230, 255)
    ));
    private final ArrayList<Color> nightSkyPalette = new ArrayList<>(Arrays.asList(
            new Color(25, 25, 112),
            new Color(0, 0, 139),
            new Color(47, 79, 79),
            new Color(72, 61, 139),
            new Color(30, 30, 50)
    ));
    private final ArrayList<Color> dayGroundPalette = new ArrayList<>(Arrays.asList(
            // Травянисто-земляные оттенки
            new Color(110, 85, 45),    // Светлая земля
            new Color(95, 70, 35),     // Средняя земля
            new Color(80, 55, 25),     // Темная земля
            new Color(120, 95, 55),    // Песчаная земля
            new Color(100, 75, 40),    // Глинистая земля
            new Color(85, 60, 30)      // Сухая земля
    ));

    private final ArrayList<Color> nightGroundPalette = new ArrayList<>(Arrays.asList(
            // Ночные версии - более глубокие и холодные
            new Color(70, 55, 25),     // Темная светлая земля
            new Color(60, 45, 20),     // Темная средняя земля
            new Color(50, 35, 15),     // Темная темная земля
            new Color(75, 60, 35),     // Темная песчаная земля
            new Color(65, 50, 25),     // Темная глинистая земля
            new Color(55, 40, 20)      // Темная сухая земля
    ));

    private final ArrayList<Color> daySunPalette = new ArrayList<>(Arrays.asList(
            new Color(255, 215, 0),
            new Color(255, 255, 0)
    ));
    private final ArrayList<Color> nightSunPalette = new ArrayList<>(Arrays.asList(
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0)
    ));

    private final ArrayList<Color> dayMoonPalette = new ArrayList<>(Arrays.asList(
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0)
    ));
    private final ArrayList<Color> nightMoonPalette = new ArrayList<>(Arrays.asList(
            new Color(240, 248, 255),
            new Color(255, 255, 224),
            new Color(220, 220, 220),
            new Color(230, 230, 250),
            new Color(255, 250, 205)
    ));

    private final ArrayList<Color> dayCloudPalette = new ArrayList<>(Arrays.asList(
            new Color(240, 240, 240),
            new Color(255, 250, 250),
            new Color(220, 220, 220)
    ));
    private final ArrayList<Color> nightCloudPalette = new ArrayList<>(Arrays.asList(
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0)
    ));

    private final ArrayList<Color> dayStarPalette = new ArrayList<>(Arrays.asList(
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0)
    ));
    private final ArrayList<Color> nightStarPalette = new ArrayList<>(Arrays.asList(
            new Color(255, 255, 224),
            new Color(255, 255, 255),
            new Color(240, 248, 255),
            new Color(255, 240, 0),
            new Color(255, 200, 0)
    ));

    private final ArrayList<FirColors> dayFirPalette = new ArrayList<>(Arrays.asList(
            new FirColors(new Color(52, 130, 33), new Color(74, 77, 43)),
            new FirColors(new Color(60, 140, 40), new Color(80, 70, 50)),
            new FirColors(new Color(45, 120, 35), new Color(70, 65, 45))
    ));
    private final ArrayList<FirColors> nightFirPalette = new ArrayList<>(Arrays.asList(
            new FirColors(new Color(66, 107, 34), new Color(31, 36, 28)),
            new FirColors(new Color(50, 90, 30), new Color(25, 30, 20)),
            new FirColors(new Color(40, 80, 25), new Color(20, 25, 15))
    ));

    private final ArrayList<AppleTreeColors> dayAppleTreePalette = new ArrayList<>(Arrays.asList(
            new AppleTreeColors(new Color(34, 139, 34), new Color(102, 51, 0), new Color(255, 0, 0)),
            new AppleTreeColors(new Color(50, 205, 50), new Color(139, 69, 19), new Color(220, 20, 60)),
            new AppleTreeColors(new Color(0, 128, 0), new Color(70, 35, 0), new Color(178, 34, 34))
    ));
    private final ArrayList<AppleTreeColors> nightAppleTreePalette = new ArrayList<>(Arrays.asList(
            new AppleTreeColors(new Color(20, 90, 20), new Color(60, 30, 0), new Color(150, 0, 0)),
            new AppleTreeColors(new Color(30, 100, 60), new Color(100, 50, 25), new Color(100, 20, 20)),
            new AppleTreeColors(new Color(0, 100, 0), new Color(50, 25, 0), new Color(120, 0, 0))
    ));

    private final ArrayList<HomeColors> dayHomePalette = new ArrayList<>(Arrays.asList(
            // Вариант 1: Классический деревенский дом
            new HomeColors(
                    new Color(150, 150, 150), // Труба: серый
                    new Color(120, 80, 40),   // Крыша: коричневая
                    new Color(240, 230, 200), // Сам дом: кремовый
                    new Color(100, 70, 40),   // Ставни: темно-коричневые
                    new Color(200, 230, 255), // Окна: голубоватые
                    new Color(110, 80, 50),   // Дверь: коричневая
                    new Color(60, 40, 20),    // Внутренность двери: темно-коричневая
                    new Color(200, 150, 50),  // Дверная ручка: латунная
                    new Color(220, 210, 180), // Подоконник: бежевый
                    new Color(140, 120, 100)  // Ступеньки: серо-коричневые
            ),

            // Вариант 2: Светлый дом с зеленой крышей
            new HomeColors(
                    new Color(170, 170, 170), // Труба: светло-серый
                    new Color(80, 120, 80),   // Крыша: зеленная
                    new Color(250, 245, 230), // Сам дом: слоновая кость
                    new Color(120, 100, 80),  // Ставни: бежево-коричневые
                    new Color(180, 220, 240), // Окна: нежно-голубые
                    new Color(130, 100, 70),  // Дверь: светло-коричневая
                    new Color(70, 50, 30),    // Внутренность двери: коричневая
                    new Color(180, 160, 60),  // Дверная ручка: золотистая
                    new Color(240, 235, 220), // Подоконник: кремовый
                    new Color(160, 140, 120)  // Ступеньки: песочные
            ),

            // Вариант 3: Теплый желтоватый дом
            new HomeColors(
                    new Color(160, 160, 160), // Труба: серый
                    new Color(140, 100, 60),  // Крыша: терракотовая
                    new Color(255, 250, 220), // Сам дом: теплый белый
                    new Color(110, 90, 70),   // Ставни: шоколадные
                    new Color(210, 230, 250), // Окна: светло-голубые
                    new Color(120, 90, 60),   // Дверь: ореховая
                    new Color(50, 35, 20),    // Внутренность двери: темный орех
                    new Color(190, 170, 80),  // Дверная ручка: бронзовая
                    new Color(245, 240, 225), // Подоконник: теплый белый
                    new Color(150, 130, 110)  // Ступеньки: коричневые
            ),

            // Вариант 4: Голубой дом
            new HomeColors(
                    new Color(180, 180, 180), // Труба: светло-серый
                    new Color(100, 100, 150), // Крыша: серо-голубая
                    new Color(220, 230, 240), // Сам дом: голубовато-белый
                    new Color(90, 110, 130),  // Ставни: серо-голубые
                    new Color(190, 210, 230), // Окна: голубые
                    new Color(100, 120, 140), // Дверь: серо-голубая
                    new Color(40, 60, 80),    // Внутренность двери: темно-синяя
                    new Color(160, 180, 200), // Дверная ручка: стальная
                    new Color(230, 235, 240), // Подоконник: голубоватый
                    new Color(130, 140, 150)  // Ступеньки: серо-голубые
            )
    ));

    private final ArrayList<HomeColors> nightHomePalette = new ArrayList<>(Arrays.asList(
            // Ночные версии - приглушенные и темные
            new HomeColors(
                    new Color(100, 100, 100), // Труба: темно-серый
                    new Color(80, 55, 25),    // Крыша: темно-коричневая
                    new Color(180, 175, 160), // Сам дом: темный кремовый
                    new Color(70, 50, 25),    // Ставни: очень темно-коричневые
                    new Color(150, 180, 200), // Окна: приглушенно-голубые
                    new Color(80, 60, 35),    // Дверь: темно-коричневая
                    new Color(40, 25, 15),    // Внутренность двери: почти черная
                    new Color(150, 120, 40),  // Дверная ручка: темная латунная
                    new Color(160, 155, 140), // Подоконник: темный бежевый
                    new Color(100, 85, 70)    // Ступеньки: темные
            ),

            new HomeColors(
                    new Color(120, 120, 120), // Труба: серый
                    new Color(50, 80, 50),    // Крыша: темно-зеленая
                    new Color(200, 195, 180), // Сам дом: темная слоновая кость
                    new Color(85, 75, 55),    // Ставни: темные
                    new Color(140, 170, 190), // Окна: приглушенные
                    new Color(95, 75, 50),    // Дверь: темная
                    new Color(50, 35, 20),    // Внутренность двери: темная
                    new Color(140, 130, 50),  // Дверная ручка: темная
                    new Color(190, 185, 170), // Подоконник: темный
                    new Color(120, 105, 90)   // Ступеньки: темные
            ),

            new HomeColors(
                    new Color(110, 110, 110), // Труба: темно-серый
                    new Color(100, 75, 40),   // Крыша: темная терракотовая
                    new Color(210, 205, 175), // Сам дом: теплый темный
                    new Color(80, 65, 45),    // Ставни: темные
                    new Color(160, 180, 200), // Окна: приглушенные
                    new Color(90, 70, 40),    // Дверь: темная
                    new Color(35, 25, 15),    // Внутренность двери: очень темная
                    new Color(150, 135, 65),  // Дверная ручка: темная
                    new Color(195, 190, 180), // Подоконник: темный
                    new Color(115, 100, 85)   // Ступеньки: темные
            ),

            new HomeColors(
                    new Color(130, 130, 130), // Труба: серый
                    new Color(70, 70, 100),   // Крыша: темная серо-голубая
                    new Color(175, 185, 195), // Сам дом: темный голубоватый
                    new Color(60, 75, 90),    // Ставни: темные серо-голубые
                    new Color(140, 160, 180), // Окна: темные голубые
                    new Color(70, 85, 100),   // Дверь: темная
                    new Color(25, 40, 55),    // Внутренность двери: очень темная
                    new Color(120, 140, 160), // Дверная ручка: темная стальная
                    new Color(180, 185, 190), // Подоконник: темный
                    new Color(100, 110, 120)  // Ступеньки: темные
            )
    ));

    private final ArrayList<FlowerColors> dayFlowerPalette = new ArrayList<>(Arrays.asList(
            new FlowerColors(new Color(255, 165, 0), new Color(255, 105, 180), new Color(0, 128, 0)),
            new FlowerColors(new Color(255, 165, 0), new Color(75, 0, 130), new Color(34, 139, 34)),
            new FlowerColors(new Color(255, 165, 0), new Color(255, 0, 0), new Color(0, 100, 0)),
            new FlowerColors(new Color(255, 215, 0), new Color(255, 105, 180),  new Color(34, 139, 34)),
            new FlowerColors(new Color(255, 215, 0), new Color(75, 0, 130), new Color(0, 128, 0)),
            new FlowerColors(new Color(255, 215, 0), new Color(255, 0, 0), new Color(0, 100, 0)),
            new FlowerColors(new Color(255, 140, 0), new Color(255, 105, 180), new Color(0, 100, 0)),
            new FlowerColors(new Color(255, 140, 0), new Color(75, 0, 130),  new Color(34, 139, 34)),
            new FlowerColors(new Color(255, 140, 0), new Color(255, 0, 0), new Color(0, 128, 0))

    ));
    private final ArrayList<FlowerColors> nightFlowerPalette = new ArrayList<>(Arrays.asList(
            new FlowerColors(new Color(150, 100, 0), new Color(150, 60, 100), new Color(0, 80, 0)),
            new FlowerColors(new Color(150, 100, 0), new Color(50, 10, 80), new Color(20, 90, 20)),
            new FlowerColors(new Color(150, 100, 0), new Color(150, 0, 0), new Color(0, 50, 20)),
            new FlowerColors(new Color(120, 80, 0), new Color(150, 60, 100), new Color(20, 90, 20)),
            new FlowerColors(new Color(120, 80, 0), new Color(50, 10, 80), new Color(0, 80, 0)),
            new FlowerColors(new Color(120, 80, 0), new Color(150, 0, 0), new Color(0, 50, 20)),
            new FlowerColors(new Color(100, 60, 0), new Color(150, 60, 100), new Color(0, 50, 20)),
            new FlowerColors(new Color(100, 60, 0), new Color(50, 10, 80), new Color(20, 90, 20)),
            new FlowerColors(new Color(100, 60, 0), new Color(150, 0, 0), new Color(0, 80, 0))
    ));

    private final ArrayList<Color> dayFencePalette = new ArrayList<>(Arrays.asList(
            new Color(205, 133, 63),
            new Color(160, 82, 45),
            new Color(139, 69, 19),
            new Color(210, 105, 30),
            new Color(120, 70, 30)
    ));
    private final ArrayList<Color> nightFencePalette = new ArrayList<>(Arrays.asList(
            new Color(120, 70, 30),
            new Color(100, 50, 25),
            new Color(70, 35, 10),
            new Color(90, 40, 15),
            new Color(80, 40, 20)
    ));

    private final ArrayList<LamppostColors> dayLamppostPalette = new ArrayList<>(Arrays.asList(
            new LamppostColors(new Color(105, 105, 105), new Color(105, 105, 105)),
            new LamppostColors(new Color(128, 128, 128), new Color(128, 128, 128)),
            new LamppostColors(new Color(70, 70, 70), new Color(70, 70, 70)),
            new LamppostColors(new Color(112, 128, 144), new Color(112, 128, 144))
    ));
    private final ArrayList<LamppostColors> nightLamppostPalette = new ArrayList<>(Arrays.asList(
            new LamppostColors(new Color(100, 100, 100), new Color(255, 255, 0)),
            new LamppostColors(new Color(120, 120, 120), new Color(255, 240, 0)),
            new LamppostColors(new Color(60, 60, 60), new Color(255, 200, 0)),
            new LamppostColors(new Color(90, 100, 110), new Color(255, 255, 100))
    ));

    private final ArrayList<Color> dayBushPalette = new ArrayList<>(Arrays.asList(
            new Color(60, 179, 113),
            new Color(0, 128, 0),
            new Color(34, 139, 34)
    ));
    private final ArrayList<Color> nightBushPalette = new ArrayList<>(Arrays.asList(
            new Color(30, 100, 60),
            new Color(0, 80, 0),
            new Color(0, 50, 20),
            new Color(40, 70, 40)
    ));


    private final ArrayList<LakeColors> dayLakePalette = new ArrayList<>(Arrays.asList(
            // Вариант 1: Яркий изумрудный пруд (соответствует ночному варианту 1)
            new LakeColors(
                    new Color(60, 140, 150),    // Глубокий бирюзово-зеленый
                    new Color(210, 240, 250),   // Светлые голубоватые блики
                    new Color(70, 200, 100)     // Яркая сочная зелень
            ),
            // Вариант 2: Естественный лесной пруд (соответствует ночному варианту 2)
            new LakeColors(
                    new Color(80, 120, 110),    // Зеленовато-серый, глубокий
                    new Color(230, 245, 235),   // Мягкие зелено-белые блики
                    new Color(90, 170, 110)     // Насыщенный зеленый
            )
    ));
    private final ArrayList<LakeColors> nightLakePalette = new ArrayList<>(Arrays.asList(
            // Вариант 1: Ночная версия изумрудного пруда
            new LakeColors(
                    new Color(20, 70, 75),      // Темная версия дневного Color(60, 140, 150)
                    new Color(150, 180, 190),   // Темная версия дневного Color(210, 240, 250)
                    new Color(35, 100, 50)      // Темная версия дневного Color(70, 200, 100)
            ),
            // Вариант 2: Ночная версия лесного пруда
            new LakeColors(
                    new Color(40, 60, 55),      // Темная версия дневного Color(80, 120, 110)
                    new Color(160, 180, 165),   // Темная версия дневного Color(230, 245, 235)
                    new Color(45, 85, 55)       // Темная версия дневного Color(90, 170, 110)
            )
    ));

    private final ArrayList<Color> dayStonePalette = new ArrayList<>(Arrays.asList(
            new Color(169, 169, 169),
            new Color(128, 128, 128),
            new Color(112, 128, 144),
            new Color(200, 200, 200),
            new Color(150, 150, 150)
    ));
    private final ArrayList<Color> nightStonePalette = new ArrayList<>(Arrays.asList(
            new Color(100, 100, 100),
            new Color(80, 80, 80),
            new Color(70, 70, 70),
            new Color(90, 90, 90),
            new Color(112, 112, 112)
    ));

    private final ArrayList<DuckColors> dayDuckPalette = new ArrayList<>(Arrays.asList(
            // Вариант 1: Классическая желтая утка
            new DuckColors(
                    new Color(255, 140, 0),   // Клюв: оранжевый
                    new Color(255, 255, 0),   // Шея: ярко-желтый
                    new Color(255, 255, 0),   // Голова: ярко-желтый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(255, 255, 255), // Блик глаза: белый
                    new Color(255, 215, 0),   // Тело: золотистый
                    new Color(255, 165, 0)    // Крыло: оранжевый
            ),

            // Вариант 2: Белая утка
            new DuckColors(
                    new Color(255, 140, 0),   // Клюв: оранжевый
                    new Color(255, 250, 250), // Шея: белый
                    new Color(255, 250, 250), // Голова: белый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(255, 255, 255), // Блик глаза: белый
                    new Color(240, 248, 255), // Тело: бело-голубоватый
                    new Color(220, 220, 220)  // Крыло: светло-серый
            ),

            // Вариант 3: Коричневая утка
            new DuckColors(
                    new Color(210, 105, 30),  // Клюв: темно-оранжевый
                    new Color(160, 120, 80),  // Шея: коричневый
                    new Color(160, 120, 80),  // Голова: коричневый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(255, 255, 255), // Блик глаза: белый
                    new Color(139, 69, 19),   // Тело: коричневый
                    new Color(160, 82, 45)    // Крыло: темно-коричневый
            ),

            // Вариант 4: Серо-белая утка
            new DuckColors(
                    new Color(255, 165, 0),   // Клюв: оранжевый
                    new Color(200, 200, 200), // Шея: светло-серый
                    new Color(200, 200, 200), // Голова: светло-серый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(255, 255, 255), // Блик глаза: белый
                    new Color(220, 220, 220), // Тело: серо-белый
                    new Color(180, 180, 180)  // Крыло: серый
            )
    ));

    private final ArrayList<DuckColors> nightDuckPalette = new ArrayList<>(Arrays.asList(
            // Вариант 1: Приглушенная желтая утка
            new DuckColors(
                    new Color(180, 100, 0),   // Клюв: темно-оранжевый
                    new Color(180, 180, 0),   // Шея: тускло-желтый
                    new Color(180, 180, 0),   // Голова: тускло-желтый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(150, 150, 150), // Блик глаза: серый
                    new Color(180, 150, 0),   // Тело: темно-золотистый
                    new Color(150, 100, 0)    // Крыло: темно-оранжевый
            ),

            // Вариант 2: Темная белая утка
            new DuckColors(
                    new Color(180, 100, 0),   // Клюв: темно-оранжевый
                    new Color(150, 150, 150), // Шея: серый
                    new Color(150, 150, 150), // Голова: серый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(120, 120, 120), // Блик глаза: темно-серый
                    new Color(170, 170, 170), // Тело: серый
                    new Color(140, 140, 140)  // Крыло: темно-серый
            ),

            // Вариант 3: Темная коричневая утка
            new DuckColors(
                    new Color(150, 75, 20),   // Клюв: темно-оранжевый
                    new Color(100, 80, 50),   // Шея: темно-коричневый
                    new Color(100, 80, 50),   // Голова: темно-коричневый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(100, 100, 100), // Блик глаза: серый
                    new Color(80, 50, 20),    // Тело: очень темный коричневый
                    new Color(60, 40, 20)     // Крыло: почти черный коричневый
            ),

            // Вариант 4: Темная серо-белая утка
            new DuckColors(
                    new Color(150, 100, 0),   // Клюв: темно-оранжевый
                    new Color(120, 120, 120), // Шея: темно-серый
                    new Color(120, 120, 120), // Голова: темно-серый
                    new Color(0, 0, 0),       // Глаз: черный
                    new Color(100, 100, 100), // Блик глаза: серый
                    new Color(140, 140, 140), // Тело: серый
                    new Color(110, 110, 110)  // Крыло: темно-серый
            )
    ));

    public TimeManager(Random random) {
        this.colorManager = new ColorManager(random);
    }

    public boolean isDay() {
        return isDay;
    }

    public void toggleTime(){
        this.isDay = !isDay;
    }

    public Color getSkyColor(){
        return isDay ?
                colorManager.getColor(daySkyPalette, "sky") :
                colorManager.getColor(nightSkyPalette, "sky");
    }

    public Color getGroundColor(){
        return isDay ?
                colorManager.getColor(dayGroundPalette, "ground") :
                colorManager.getColor(nightGroundPalette, "ground");
    }

    public Color getSunColor(){
        return isDay ?
                colorManager.getColor(daySunPalette, "sun") :
                colorManager.getColor(nightSunPalette, "sun");
    }


    public Color getMoonColor(){
        return isDay ?
                colorManager.getColor(dayMoonPalette, "moon") :
                colorManager.getColor(nightMoonPalette, "moon");
    }

    public Color getCloudColor(int cloudIndex){
        String key = "cloud_" + cloudIndex;
        return isDay ?
                colorManager.getColor(dayCloudPalette, key) :
                colorManager.getColor(nightCloudPalette, key);
    }

    public Color getStarColor(int starIndex){
        String key = "star_" + starIndex;
        return isDay ?
                colorManager.getColor(dayStarPalette, key) :
                colorManager.getColor(nightStarPalette, key);
    }

    public FirColors getFirColors(int firIndex){
        String key = "fir_" + firIndex;
        return isDay ?
                colorManager.getObjectColor(dayFirPalette, key) :
                colorManager.getObjectColor(nightFirPalette, key);
    }

    public AppleTreeColors getAppleTreeColors(){
        return isDay ?
                colorManager.getObjectColor(dayAppleTreePalette, "appleTree") :
                colorManager.getObjectColor(nightAppleTreePalette, "appleTree");
    }

    public HomeColors getHomeColors() {
        return isDay ?
                colorManager.getObjectColor(dayHomePalette, "home") :
                colorManager.getObjectColor(nightHomePalette, "home");
    }

    public FlowerColors getFlowerColors(int flowerIndex){
        String key = "flower_" + flowerIndex;
        return isDay ?
                colorManager.getObjectColor(dayFlowerPalette, key) :
                colorManager.getObjectColor(nightFlowerPalette, key);
    }

    public Color getFenceColor(){
        return isDay ?
                colorManager.getColor(dayFencePalette, "fence") :
                colorManager.getColor(nightFencePalette, "fence");
    }

    public LamppostColors getLamppostColors(){
        return isDay ?
                colorManager.getObjectColor(dayLamppostPalette,"lamppost") :
                colorManager.getObjectColor(nightLamppostPalette, "lamppost");
    }

    public Color getBushColor(int bushIndex){
        String key = "bush_" + bushIndex;
        return isDay ?
                colorManager.getColor(dayBushPalette, key) :
                colorManager.getColor(nightBushPalette, key);
    }

    public LakeColors getLakeColors(){
        return isDay ?
                colorManager.getObjectColor(dayLakePalette,"lake") :
                colorManager.getObjectColor(nightLakePalette, "lake");
    }

    public Color getStoneColor(int stoneIndex){
        String key = "stone_" + stoneIndex;
        return isDay ?
                colorManager.getColor(dayStonePalette, key) :
                colorManager.getColor(nightStonePalette, key);
    }

    public DuckColors getDuckColors(int duckIndex){
        String key = "duck_" + duckIndex;
        return isDay ?
                colorManager.getObjectColor(dayDuckPalette, key) :
                colorManager.getObjectColor(nightDuckPalette, key);
    }

}
