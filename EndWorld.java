import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EndWorld extends TextWorlds
{
    /**
     * Constructor for objects of class EndWorld.
     */
    public EndWorld()
    {    
        Text text = new Text();
        addObject(text, getWidth()/2, getHeight()/2);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            StartWorld start = new StartWorld();
            Greenfoot.setWorld(start);
        }
    }
}
