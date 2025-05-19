import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionsWorld extends TextWorlds
{
    /**
     * Constructor for objects of class InstructionsWorld.
     */
    public InstructionsWorld()
    {    
        Text text = new Text();
        addObject(text, getWidth()/2, getHeight()/2);

        BackButton back = new BackButton();
        addObject(back, getWidth()/2, getHeight() - 25);
    }
}
