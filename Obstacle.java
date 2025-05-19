import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * It's not just a boulder, it's a rock!
 */
public class Obstacle extends Enemy
{
    private int vSpeed = 1;
    private int acceleration = 2;
    
    public void act()
    {
        fall();
        
        checkKill();
        
        friendlyFire();
        
        checkBreak();
    }
    
    /**
     * Makes the obstacle fall
     */
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        
        if(vSpeed > 15)
        {
            vSpeed = 12;
        }
    }
    
    /**
     * Once past a certain Y level, the obstacle will be removed
     */
    public void checkBreak()
    {
        if(getY() >= 895)
        {
            getWorld().removeObject(this);
        }
        else if(isTouching(Player.class))
        {
            setLocation(getX(), 900);
        }
    }
    
    /**
     * Kills other enemies if touched
     */
    public void friendlyFire()
    {
        if(isTouching(Enemy.class) && !isTouching(Atlas.class))
        {
            removeTouching(Enemy.class);
        }
    }
}
