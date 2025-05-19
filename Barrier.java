import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Barrier extends BuildingBlocks
{
    public void act()
    {
        if(getX() <= getWorld().getWidth()/2)
        {
            setImage("left-barrier.png");
        }
        else if(getX() >= getWorld().getWidth()/2)
        {
            setImage("right-barrier.png");
        }
    }
}
