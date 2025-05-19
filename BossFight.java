import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BossFight extends Levels
{
    public static GreenfootImage floorAM = new GreenfootImage("am-floor.png");
    public static GreenfootImage floorOLY = new GreenfootImage("oly-floor.png");

    /**
     * Constructor for objects of class BossFight.
     */
    public BossFight()
    {    
        setPaintOrder(Player.class, Sword.class);

        Barrier leftBarrier = new Barrier();
        addObject(leftBarrier, getWidth()/14 - 65, getHeight() * 2/3);

        Barrier rightBarrier = new Barrier();
        rightBarrier.setImage("right-barrier.png");
        addObject(rightBarrier, getWidth() - 35, getHeight() * 2/3 + 10);

        Floor floor = new Floor();
        floor.setImage(floorOLY);
        addObject(floor, getWidth()/2, getHeight());

        Floor floor2 = new Floor();
        floor2.setImage(floorOLY);
        addObject(floor2, getWidth()/14, getHeight());

        Floor floor3 = new Floor();
        floor3.setImage(floorOLY);
        addObject(floor3, getWidth() * 13/14, getHeight());

        Player player = new Player();
        addObject(player, getWidth()/6 - 65, getHeight() - 55);

        Sword sword = new Sword();
        addObject(sword, getWidth()/6 - 20, getHeight() - 63);

        Atlas atlas = new Atlas();
        addObject(atlas, getWidth() * 13/14, getHeight() - 110);
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
