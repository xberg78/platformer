import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BackButton extends Buttons
{
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            StartWorld start = new StartWorld();
            Greenfoot.setWorld(start);
        }
    }
}
