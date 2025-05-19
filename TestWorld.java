import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    public static GreenfootImage platformAG = new GreenfootImage("ag-platform.png");
    public static GreenfootImage floorAG = new GreenfootImage("ag-floor.png");
    public Player player = new Player();

    /**
     * Credit to Tanner Crow and Skylar Bender
     */
    private int[][] positions = 
        {{0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0}};

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TestWorld()
    {    
        super(600,900,1);
        
        setPaintOrder(Player.class, Sword.class);

        for(int row = 0; row < 18; row++)
        {
            for(int col = 0; col < 12; col++)
            {
                if(positions[row][col] == 1)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAG);
                    addObject(platform, col*75 + 38, row*75 + 37);
                }
                else if(positions[row][col] == 2)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAG);
                    addObject(platform, col*75 + 38, row*75 + 37);
                    Walker walker = new Walker();
                    addObject(walker,col*75 + 38, row*75 + 4);
                }
            }
        }
        Floor floor = new Floor();
        floor.setImage(floorAG);
        addObject(floor, getWidth()/2, getHeight());

        player.jumpStrength = 22;
        addObject(player, getWidth()/6 - 65, getHeight() - 45);

        Sword sword = new Sword();
        addObject(sword, getWidth()/6 - 32, getHeight() - 52);
    }
}
