import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionsButton extends Buttons
{
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            InstructionsWorld inst = new InstructionsWorld();
            Greenfoot.setWorld(inst);
        }
    }
}
