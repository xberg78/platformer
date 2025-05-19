import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Faller extends Enemy
{
    public static GreenfootImage cloudR = new GreenfootImage("cloud-nymph.png");
    public static GreenfootImage cloudL = new GreenfootImage("turned-cloud-nymph.png");
    public static GreenfootImage dryadR = new GreenfootImage("dryad.png");
    public static GreenfootImage dryadL = new GreenfootImage("turned-dryad.png");
    public boolean turned = false;
    private int vSpeed = 2;
    private int hSpeed = 1;
    private int acceleration = 2;
    private boolean left = false;
    private boolean right = false;
    
    public void act()
    {
        move();
        
        checkFall();
        
        checkKill();
        
        checkTurn();
        
        imageCheck();
        
        preventColision();
    }
    
    /**
     * Collaboration with Nathaniel Ferguson
     * Allows enemies to move if there is no platform in the way
     */
    public void move()
    {
        Actor LeftTop = getOneObjectAtOffset(-20,-20,Platform.class);
        Actor RightTop = getOneObjectAtOffset(20,-20,Platform.class);
        Actor LeftBottom = getOneObjectAtOffset(-20,20,Platform.class);
        Actor RightBottom = getOneObjectAtOffset(20,20,Platform.class);
        if(RightTop == null && RightBottom == null && left == false)
        {
           setLocation (getX() + hSpeed, getY());
           right = true;
        }
        else
        {
            right = false;
        }
        
        if(LeftTop == null && LeftBottom == null && right == false)
        {
           setLocation (getX() - hSpeed, getY()); 
           left = true;
        }
        else
        {
            left = false;
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
     * Credit to Nathaniel Ferguson
     * 
     * Checks if the faller should fall
     */
    public void checkFall()
    {
        Actor Platformleftbottom = getOneObjectAtOffset(-19, 23, Platform.class);
        Actor Platformrightbottom = getOneObjectAtOffset(19, 23, Platform.class);
        Actor Floorleftbottom = getOneObjectAtOffset(-19, 23, Floor.class);
        Actor Floorrightbottom = getOneObjectAtOffset(19, 23, Floor.class);
        if(onGround()&& Platformleftbottom !=null && Platformrightbottom !=null || onGround()&& Floorleftbottom !=null && Floorrightbottom !=null)
        {
            acceleration = 0;
        }
        else
        {   
            if(Platformleftbottom == null && Platformrightbottom == null && Floorleftbottom ==null && Floorrightbottom == null)
            {   
                fall();
                if(vSpeed < 6)
                {
                    acceleration = 2;
                }
                else
                {
                    acceleration = 0;
                }
            }
        }
    }

    /**
     * Credit to Nathaniel Ferguson
     * 
     * Prevents the faller from clipping into platforms
     */
    public void preventColision()
    {
        Actor PlatformLeftbottom = getOneObjectAtOffset(-19, 60, Platform.class);
        Actor PlatformRightbottom = getOneObjectAtOffset(19, 60, Platform.class);
        if(PlatformLeftbottom !=null || PlatformRightbottom !=null)
        {
            vSpeed = 4;
            acceleration = 0;
        }
    }
    
    /**
     * Makes the faller fall
     */
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    /**
     * Depending on the faller's direction and world, its image will change
     */
    public void imageCheck()
    {
        if(getWorld() instanceof AncientGreece)
        {
            if(right)
            {
                setImage(dryadR);
            }
            else
            {
                setImage(dryadL);
            }
        }
        else if(getWorld() instanceof Olympus)
        {
            if(right)
            {
                setImage(cloudR);
            }
            else
            {
                setImage(cloudL);
            }
        }
    }
    
    /**
     * A turn method for regular enemies
     */
    public void checkTurn()
    {
        if(getX() <= getWorld().getWidth()/14 - 90)
        {
            left = false;
            right = true;
        }
        else if(getX() >= getWorld().getWidth() - 10)
        {
            right = false;
            left = true;
        }
    }
}
