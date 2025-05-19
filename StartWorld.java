import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartWorld extends World
{

    /**
     * Constructor for objects of class StartWorld.
     */
    public StartWorld()
    {    
        super(500, 500, 1); 

        Text text = new Text();
        addObject(text, getWidth()/2, getHeight()* 2/5);

        InstructionsButton ibutton = new InstructionsButton();
        addObject(ibutton, getWidth()/2, getHeight()* 4/5);

        StartButton sbutton = new StartButton();
        addObject(sbutton, getWidth()/2, getHeight()* 4/5 - 50);
    }

    /**
     * Drops cows from the sky randomly
     */
    public void act()
    {
        if(Greenfoot.getRandomNumber(1000) > 975)
        {
            Walker walker = new Walker();
            addObject(walker, Greenfoot.getRandomNumber(500), 0);
        }
    }
}
