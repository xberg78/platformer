import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public GreenfootImage lAtlas = new GreenfootImage("Atlas.png");
    public GreenfootImage rAtlas = new GreenfootImage("turned-Atlas.png");
    public boolean turned = false;
    
    /**
     * Allows enemies to remove the player if they touch him
     * (Credit to Super_Hippo)
     */
    public void checkKill()
    {
        if(isTouching(Player.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Player.class));
            getWorld().removeObjects(getWorld().getObjects(Sword.class));
            Greenfoot.delay(50);
            restartLevel();
        }
    }
    
    /**
     * Restarts the current level over
     */
    public void restartLevel()
    {
        if (getWorld() instanceof AncientGreece)
        {
            AncientGreece take2 = new AncientGreece();
            Greenfoot.setWorld(take2);
        }
        else if (getWorld() instanceof Olympus)
        {
            Olympus take2 = new Olympus();
            Greenfoot.setWorld(take2);
        }
        else if (getWorld() instanceof AtlasMountains)
        {
            AtlasMountains take2 = new AtlasMountains();
            Greenfoot.setWorld(take2);
        }
        else if (getWorld() instanceof BossFight)
        {
            BossFight take2 = new BossFight();
            Greenfoot.setWorld(take2);
        }
    }
}
