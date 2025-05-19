import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AtlasMountains extends Levels
{
    public static GreenfootImage platformAM = new GreenfootImage("am-platform.png");
    public static GreenfootImage floorAM = new GreenfootImage("am-floor.png");

    /**
     * Credit to Tanner Crow and Skylar Bender
     */
    private int[][] positions = 
        {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,2,1,0,0,1,2,1,0,0,1,2,1,0,0,1,2,1,0,0,1,2,1,0,0,1,2,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    /**
     * Constructor for objects of class AtlasMountains.
     */
    public AtlasMountains()
    {    
        setPaintOrder(Player.class, Sword.class);
        for(int row = 0; row < 18; row++)
        {
            for(int col = 0; col < 28; col++)
            {
                if(positions[row][col] == 1)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAM);
                    addObject(platform, col*50 + 25, row*50 + 25);
                }
                else if(positions[row][col] == 2)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAM);
                    addObject(platform, col*50 + 25, row*50 + 25);
                    Walker walker = new Walker();
                    addObject(walker, col*50 + 25, row*50 - 25);
                }
                else if(positions[row][col] == 3)
                {
                    Platform platform = new Platform();
                    platform.setImage(platformAM);
                    addObject(platform, col*50 + 25, row*50 + 25);
                    Faller faller = new Faller();
                    addObject(faller, col*50 + 25, row*50 -25);
                }
            }
        }
        Floor floor = new Floor();
        floor.setImage(floorAM);
        addObject(floor, getWidth()/2, getHeight());

        Floor floor2 = new Floor();
        floor2.setImage(floorAM);
        addObject(floor2, getWidth()/14, getHeight());

        Floor floor3 = new Floor();
        floor3.setImage(floorAM);
        addObject(floor3, getWidth() * 13/14, getHeight());

        Player player = new Player();
        addObject(player, getWidth()/14 - 65, getHeight() - 55);

        Sword sword = new Sword();
        addObject(sword, getWidth()/14 - 20, getHeight() - 63);
    }

    /**
     * Drops rocks from the sky randomly
     */
    public void act()
    {
        if(Greenfoot.getRandomNumber(1000) > 975)
        {
            Obstacle rock = new Obstacle();
            addObject(rock, Greenfoot.getRandomNumber(1400), 0);
        }
    }
}
