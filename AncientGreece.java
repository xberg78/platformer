import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AncientGreece extends Levels
{
    public static GreenfootImage platformAG = new GreenfootImage("ag-platform.png");
    public static GreenfootImage floorAG = new GreenfootImage("ag-floor.png");

    /**
     * Credit to Tanner Crow and Skylar Bender
     */
    private int[][] positions = 
        {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,2,0,0,2,3,0,0,3,1,0,0,1,2,0,0,2,3,0,0,3,1,0,0,1,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0,0,3},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,0,0,1,0,0,2,0,0,1,0,0,2,0,0,1,0,0,2,0,0,1,0,0,2,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    /**
     * Constructor for objects of class AncientGreece.
     */
    public AncientGreece()
    {    
        setPaintOrder(Player.class, Sword.class);
        for(int row = 0; row < 18; row++)
        {
            for(int col = 0; col < 28; col++)
            {
                if(positions[row][col] == 1)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAG);
                    addObject(platform, col*50 + 25, row*50 + 25);
                }
                else if(positions[row][col] == 2)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAG);
                    addObject(platform, col*50 + 25, row*50 + 25);
                    Walker walker = new Walker();
                    addObject(walker, col*50 + 25, row*50 - 25);
                }
                else if(positions[row][col] == 3)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAG);
                    addObject(platform, col*50 + 25, row*50 + 25);
                    Faller faller = new Faller();
                    addObject(faller, col*50 + 25, row*50 -25);
                }
            }
        }
        Floor floor1 = new Floor();
        floor1.setImage(floorAG);
        addObject(floor1, getWidth()/2, getHeight());

        Floor floor2 = new Floor();
        floor2.setImage(floorAG);
        addObject(floor2, getWidth()/14, getHeight());

        Floor floor3 = new Floor();
        floor3.setImage(floorAG);
        addObject(floor3, getWidth() * 13/14, getHeight());

        Player player = new Player();
        addObject(player, getWidth()/14 - 65, getHeight() - 55);

        Sword sword = new Sword();
        addObject(sword, getWidth()/14 - 20, getHeight() - 63);
    }
}
