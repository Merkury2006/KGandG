import GeomObjects.*;


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
        return new Sun(width/ 12,  height/ 12, width/ 24, width/ 12);
    }

    public Moon buildMoon(){
        return new Moon(width/ 12, width / 16);
    }
    
    public ArrayList<Cloud> buildCloudList(){
        ArrayList<Cloud>  cloudList = new ArrayList<>();
        for (int curX = width / 4; curX <= width / 1.2; curX += width / 4) {
            cloudList.add(new Cloud(curX, height / 24 + random.nextInt(height / 6), width / 24 + random.nextInt(width / 24), 1));
        }
        return cloudList;
    }

    public ArrayList<Star> buildStarList(int chanceOfAppearanceStar){
        ArrayList<Star>  starList = new ArrayList<>();
        for (int curX = width / 18; curX < width; curX += width / 16) {
            for (int curY = height / 20; curY < height / 3; curY +=  width / 16) {
                int curChanceOfAppearanceStar = random.nextInt(100);
                if (curChanceOfAppearanceStar <= chanceOfAppearanceStar) {
                    starList.add(new Star(curX + random.nextInt(width / 16), curY + random.nextInt(width / 16)));
                }
            }
        }
        return starList;
    }
    
    public ArrayList<Fir> buildFirList(){
        ArrayList<Fir> firList = new ArrayList<>();
        for (int curX = 0; curX <= width; curX += width / 8) {
            firList.add(new Fir(curX, (int) (height / 2.4 - random.nextInt(height / 17)), width / 24 + random.nextInt(width / 60)));
        }
        return firList;
    }
    
    public AppleTree buildAppleTree(){
        AppleTree appleTree = new AppleTree(width / 4, (int) (height / 3.4), width / 12, 70);
        appleTree.initializedApples(random);
        return appleTree;
    }

    public Home buildHome(){
        Home home = new Home((int) (width / 1.5), height / 4 ,width / 6);
        home.initFlowersOnWindowsill();
        home.initFlowersOnGarden(random);
        return home;
    }

    public Lamppost buildLamppost(){
        return new Lamppost((int) (width / 1.142857), (int) (height / 2.4), width / 4);
    }

    public ArrayList<Bush> buildBushes(){
        ArrayList<Bush> bushList = new ArrayList<>();
        bushList.add(new Bush((int) (width / 2.18), (int) (height / 1.714), width / 32));
        bushList.add(new Bush(width / 12, (int) (height / 1.714), width / 25));
        return bushList;
    }

    public Lake buildLake(){
        Lake lake = new Lake(width / 3, (int) (height / 1.090909), width / 6, 90, 30);

        lake.initializedStones(random);

        lake.initializedDucks(random);
        lake.sortedDuckList();
        lake.getDuckList().forEach(duck -> {
            duck.setBounds((int) (lake.getX() - lake.getSize() * 0.5), lake.getX() + lake.getSize());
        });
        return lake;
    }
}
