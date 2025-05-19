import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Text extends Actor
{
    public void act()
    {
        if(getWorld() instanceof StartWorld)
        {
            setImage("StartText.png");
        }
        else if(getWorld() instanceof InstructionsWorld)
        {
            setImage("InstructionsText.png");
        }
        else if(getWorld() instanceof StoryWorld)
        {
            setImage("StoryText.png");
        }
        else if(getWorld() instanceof EndWorld)
        {
            setImage("EndText.png");
        }
    }
}
