import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Walker extends Enemy
{
    public static GreenfootImage birdR = new GreenfootImage("bird.png");
    public static GreenfootImage birdL = new GreenfootImage("turned-bird.png");
    public static GreenfootImage cowR = new GreenfootImage("cow.png");
    public static GreenfootImage cowL = new GreenfootImage("turned-cow.png");
    public static GreenfootImage snakeR = new GreenfootImage("snake.png");
    public static GreenfootImage snakeL = new GreenfootImage("turned-snake.png");
    private static GreenfootSound hiss = new GreenfootSound("snake-hiss.mp3");
    private static GreenfootSound moo = new GreenfootSound("cow-mooing-loudly-223546.mp3");
    private static GreenfootSound caw = new GreenfootSound("an_ominous-crow-call-255173.mp3");
    private int runningSpeed = 2;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private int vSpeed = 1;
    private int acceleration = 0;
    private int i = 0;
    
    public void act()
    {
        checkKill();
        
        moveLeft();
        
        moveRight();
        
        imageCheck();
        
        checkFall();
        
        sounds();
    }
    
    /**
     * Credit to Nathaniel Ferguson
     * 
     * Moves the object right and prevents them from going into a platform
     * Will bounce off walls and won't go off the platform it is on
     */
    public void moveRight()
    {
        Actor PlatformTopright = getOneObjectAtOffset(23, 20, Platform.class);
        Actor Platformrightbottom = getOneObjectAtOffset(23, 21, Platform.class);
        if(PlatformTopright == null && movingLeft == false
        && Platformrightbottom != null)
        {
            setLocation (getX() + runningSpeed, getY());
            movingRight = true;
            imageCheck();
        }
        else
        {
            movingRight = false;
        }
    }
    
    /**
     * Credit to Nathaniel Ferguson
     * 
     * Moves the object left and prevents them from going into a platform
     * Will bounce off walls and won't go off the platform it is on
     */
    public void moveLeft()
    {
        Actor PlatformTopleft = getOneObjectAtOffset(23, 20, Platform.class);
        Actor Platformleftbottom = getOneObjectAtOffset(-23, 21, Platform.class);
        if(PlatformTopleft == null && movingRight == false
        && Platformleftbottom != null)
        {
            setLocation (getX() - runningSpeed, getY());
            movingLeft = true;
            imageCheck();
        }
        else
        {
            movingLeft = false;
        }
    }
    
    /**
     * Returns if the walker is on a Platform
     */
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Platform.class);
        return under != null;
    }
    
    /**
     * Returns if the walker is on a Floor
     */
    public boolean onFloor()
    {
        Actor on = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Floor.class);
        return on != null;
    }
    
    /**
     * Checks for if and when the walker should fall
     */
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else if(onFloor())
        {
            vSpeed = 0;
            setLocation(getX(), 865);
        }
        else if(getY() >= 865)
        {
            setLocation(getX(), 865);
        }
        else
        {
            fall();
        }
    }
    
    /**
     * Makes the walker fall
     */
    public void fall()
    {
        if(getWorld() instanceof StartWorld)
        {
            setLocation( getX(), getY() + vSpeed);
            vSpeed = vSpeed + acceleration;
            if(getY() >= 495 || Greenfoot.mouseClicked(this))
            {
                moo.play();
                getWorld().removeObject(this);
            }
        }
        else
        {
            setLocation( getX(), getY() + vSpeed);
            vSpeed = vSpeed + acceleration;
        }
    }

    
    /**
     * Depending on the walker's direction and world, its image will change
     */
    public void imageCheck()
    {
        if(getWorld() instanceof AncientGreece)
        {
            if(movingRight)
            {
                setImage(cowR);
            }
            else if(movingLeft)
            {
                setImage(cowL);
            }
        }
        else if(getWorld() instanceof Olympus)
        {
            if(movingRight)
            {
                setImage(snakeR);
            }
            else if(movingLeft)
            {
                setImage(snakeL);
            }
        }
        else if(getWorld() instanceof AtlasMountains)
        {
            if(movingRight)
            {
                setImage(birdR);
            }
            else if(movingLeft)
            {
                setImage(birdL);
            }
        }
    }  
    
    /**
     * Every 100 act methods, the walker will make a sound 
     * The sound corresponds with their image
     */
    public void sounds()
    {
        if(i > 100 && getWorld() instanceof AncientGreece)
        {
            i = 0;
            moo.play();
        }
        else if(i > 100 && getWorld() instanceof Olympus)
        {
            i = 0;
            hiss.play();
        }
        else if(i > 100 && getWorld() instanceof AtlasMountains)
        {
            i = 0;
            caw.play();
        }
        else
        {
            i++;
        }
    }
}
