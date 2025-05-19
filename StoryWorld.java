import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StoryWorld extends TextWorlds
{
    /**
     * Constructor for objects of class StoryWorld.
     */
    public StoryWorld()
    {    
        Text text = new Text();
        addObject(text, getWidth()/2, getHeight()/2 + 10);
    }

    public void act()
    {
        if(Greenfoot.getKey() == "enter")
        {
            AncientGreece ag = new AncientGreece();
            Greenfoot.setWorld(ag);
        }
    }
}
