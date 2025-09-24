import GeomObjects.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SceneBuilder {
    private final int width, height;
    private final Random random;

    public SceneBuilder(int width, int height, Random random) {
        this.width = width;
        this.height = height;
        this.random = random;
    }
    
    public Sun buildSun() {
        return new Sun(width/ 12,  height/ 12, width/ 24, width/ 17, new Color(221, 240, 14));
    }
    
    public ArrayList<Cloud> buildCloudList(){
        ArrayList<Cloud>  cloudList = new ArrayList<>();
        for (int curX = width / 4; curX <= width / 1.2; curX += width / 4) {
            cloudList.add(new Cloud(curX, height / 24 + random.nextInt(height / 6), width / 24 + random.nextInt(width / 24), 1,
                    new Color(213, 224, 227)));
        }
        return cloudList;
    }
    
    public ArrayList<Fir> buildFirList(){
        ArrayList<Fir> firList = new ArrayList<>();
        for (int curX = 0; curX <= width; curX += width / 8) {
            firList.add(new Fir(curX, (int) (height / 2.4 - random.nextInt(height / 17)), width / 24 + random.nextInt(width / 60), new Color(52, 130, 33), new Color(74, 77, 43)));
        }
        return firList;
    }
    
    public AppleTree buildAppleTree(){
        AppleTree appleTree = new AppleTree(width / 4, (int) (height / 3.4), width / 12, 70
                , new Color(38, 148, 57), new Color(74, 65, 44));
        appleTree.initializedApples(random);
        appleTree.getAppleList().forEach(apple -> apple.setColor(new Color(222, 29, 51)));
        return appleTree;
    }

    public Home buildHome(){
        Home home = new Home((int) (width / 1.5), height / 4 ,width / 6, new Color(78, 84, 80),
                new Color(226, 229, 25), new Color(227, 71, 36), new Color(232, 232, 232),
                new Color(27, 106, 196), new Color(226, 229, 25), new Color(159, 156, 58),
                new Color(227, 71, 36), new Color(160, 161, 163), new Color(49, 50, 51));

        home.initFlowersOnWindowsill();
        home.initFlowersOnGarden(random);

        home.getFlowersOnGarden().forEach(flower -> {
            flower.setColorOfCenterFlower(Color.YELLOW);
            flower.setColorOfPetals(Color.RED);
            flower.setColorOfStem(Color.GREEN);
        });

        home.getFlowersOnWindowsill().forEach(flower -> {
            flower.setColorOfCenterFlower(Color.YELLOW);
            flower.setColorOfPetals(Color.BLUE);
            flower.setColorOfStem(Color.GREEN);
        });

        home.getFence().setColor(new Color(38, 38, 34));
        return home;
    }

    public Lamppost buildLamppost(){
        return new Lamppost((int) (width / 1.142857), (int) (height / 2.4), width / 4, new Color(76, 77, 76), new Color(161, 173, 29));
    }

    public ArrayList<Bush> buildBushes(){
        ArrayList<Bush> bushList = new ArrayList<>();
        bushList.add(new Bush((int) (width / 2.18), (int) (height / 1.714), width / 32, new Color(50, 127, 63)));
        bushList.add(new Bush(width / 12, (int) (height / 1.714), width / 25, new Color(50, 127, 63)));
        return bushList;
    }

    public Lake buildLake(){
        Lake lake = new Lake(width / 3, (int) (height / 1.090909), width / 6, 90, 30,
                new Color(48, 84, 42), new Color(47, 96, 102),
                new Color(27, 117, 47));

        lake.initializedStones(random);
        lake.getStoneList().forEach(stone -> stone.setColor(new Color(82, 81, 78)));
        lake.initializedDucks(random);

        lake.sortedDuckList();

        lake.getDuckList().forEach(duck -> {
            duck.setBounds((int) (lake.getX() - lake.getSize() * 0.5), lake.getX() + lake.getSize());
            duck.setColorOfBody(Color.RED);
            duck.setColorOfBeak(Color.ORANGE);
            duck.setColorOfEye(Color.WHITE);
            duck.setColorOfHead(Color.RED);
            duck.setColorOfInsideOfEye(Color.BLACK);
            duck.setColorOfNeck(Color.ORANGE);
            duck.setColorOfWing(Color.ORANGE);
        });
        return lake;
    }
}
