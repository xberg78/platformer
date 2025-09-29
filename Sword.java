import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sword extends Actor
{
    private boolean swung = false;
    
    int i = 0;
    
    GreenfootImage image3;
    GreenfootImage image2;
    GreenfootImage image1;
    
    public Sword()
    {
        image1 = new GreenfootImage("sword.png");
        image2 = new GreenfootImage("turned-sword.png");
        image3 = new GreenfootImage("swinging-sword.png");
        setImage(image1);
    }
    
    public void act()
    {
        checkKey();
    }
    
    /**
     * If the sword key is pressed, it will call the attack method
     */
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("f") && !swung || Greenfoot.isKeyDown("down") && !swung)
        {
            Greenfoot.playSound("sword.mp3");
            attack();
            swung = true;
        }
        else if (!Greenfoot.isKeyDown("f") && swung && !Greenfoot.isKeyDown("down"))
        {
            swung = false;
        }
    }
    
    /**
     * If it touches an enemy besides Atlas, they will be removed
     * If it touches Atlas, it needs to touch him two more times to remove him
     */
    private void attack()
    {
        if(isTouching(Faller.class))
        {
            removeTouching(Faller.class);
        }
        else if(isTouching(Walker.class))
        {
            removeTouching(Walker.class);
        }
        else if(isTouching(Obstacle.class))
        {
            removeTouching(Obstacle.class);
        }
        else if(isTouching(Attack.class))
        {
            removeTouching(Attack.class);
        }
        else if(isTouching(Atlas.class))
        {
            i++;
            if(i > 3)
            {
                removeTouching(Atlas.class);
                Greenfoot.delay(100);
                EndWorld end = new EndWorld();
                Greenfoot.setWorld(end);
            }
        }
    }
    
    /**
     * Doesn't work
     * Is supposed to change its image to a swinging sword
     */
    private void swing()
    {
        if(getImage() == image1)
        {
            setImage(image3);
        }
        else if(getImage() == image3)
        {
            i++;
            if(i >= 1)
            {
                setImage(image1);
            }
        }
    }
}
