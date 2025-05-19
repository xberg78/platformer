import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Attack extends Atlas
{
    public int hSpeed = 3;
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        
        checkKill();
        
        checkDisperse();
    }
    
    /**
     * Moves the attack in a certain direction
     */
    public void move()
    {
        setLocation (getX() - hSpeed, getY());
    }
    
    /**
     * If at a barrier, the attack will remove itself
     */
    public void checkDisperse()
    {
        if(getX() >= getWorld().getWidth() * 13/14)
        {
            getWorld().removeObject(this);
        }
        else if(getX() <= getWorld().getWidth()/14 - 30)
        {
            getWorld().removeObject(this);
        }
    }
}
