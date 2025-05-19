import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private Actor sword;
    private int hSpeed = 5;
    private int vSpeed = 2;
    private int acceleration = 2;
    public int jumpStrength = 22;
    private boolean jumped = false;
    
    public void act() 
    {
        checkKeys();
        
        attachSword();

        checkFall();
        
        currentWorld();
        
        preventColision();
    }

    /**
     * Depending on whatever key is pressed, a movement method is called
     */
    public void checkKeys()
    {
        rightKey();

        leftKey();

        jumpKey();
    }
    
    /**
     * Moves the player left
     */
    public void leftKey()
    {
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            moveLeft();
        }
    }
    
    /**
     * Moves the player right
     */
    public void rightKey()
    {
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            moveRight();
        }
    }
    
    /**
     * Allows the player to jump if on the floor or on a platform
     * It also works with three different keys
     */
    public void jumpKey()
    {
        if (Greenfoot.isKeyDown("space") && onPlatform() && !jumped 
        || Greenfoot.isKeyDown("space") && onFloor() && !jumped 
        || Greenfoot.isKeyDown("w") && onPlatform() && !jumped 
        || Greenfoot.isKeyDown("w") && onFloor() && !jumped 
        || Greenfoot.isKeyDown("up") && onPlatform() && !jumped 
        || Greenfoot.isKeyDown("up") && onFloor() && !jumped)
        {
            jump();
            jumped = true;
            Greenfoot.playSound("grunt.wav");
        }
        else if(!Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("up") && jumped)
        { 
            jumped = false;
        }
    }
    
    public void attachSword()
    /**
     * Credit to DanPost for attachment code
     * Attaches the sword class to the player
     */
    {
        if (sword == null && isTouching(Sword.class))
        {
            sword = getOneIntersectingObject(Sword.class);
        }
        else if (sword != null && sword.getWorld() != null 
        && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("a"))
        {
            sword.setLocation(getX() + 45, getY() - 8);
            sword.setImage("sword.png");
            setImage("playerR.png");
        }
        else if (sword != null && sword.getWorld() != null 
        && !Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("d"))
        {
            sword.setLocation(getX() - 45, getY() - 8);
            sword.setImage("turned-sword.png");
            setImage("playerL.png");
        }
    }

    /**
     * Collaboration with Nathaniel Ferguson
     * Moves the player right if there is no blocking platform
     */
    public void moveRight()
    {
        Actor RightTop = getOneObjectAtOffset(35,-45,Platform.class);
        Actor RightMiddle = getOneObjectAtOffset(35,0,Platform.class);
        Actor RightBottom = getOneObjectAtOffset(35,45,Platform.class);
        if(RightTop == null && RightMiddle == null && RightBottom == null)
        {
            setLocation (getX() + hSpeed, getY());  
        }
    }

    /**
     * Collaboration with Nathaniel Ferguson
     * Moves the player left if there is no blocking platform
     */
    public void moveLeft()
    {
        Actor LeftTop = getOneObjectAtOffset(-31,-45,Platform.class);
        Actor LeftMiddle = getOneObjectAtOffset(-31,0,Platform.class);
        Actor LeftBottom = getOneObjectAtOffset(-31,45,Platform.class);
        if(LeftTop == null && LeftMiddle == null && LeftBottom == null)
        {
            setLocation (getX() - hSpeed, getY());
        }
    }
    
    /**
     * Checks if the player is on a platform
     */
    public boolean onPlatform()
    {
        Actor under = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Platform.class);
        return under != null;
    }
    
    /**
     * Checks if the player is on a floor
     */
    public boolean onFloor()
    {
        Actor under = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Floor.class);
        return under != null;
    }

    /**
     * Credit to Nathaniel Ferguson
     * Checks if the player should fall
     */
    public void checkFall()
    {
        Actor Platformleftbottom = getOneObjectAtOffset(-25, 50, Platform.class);
        Actor Platformrightbottom = getOneObjectAtOffset(25, 50, Platform.class);
        Actor Floorleftbottom = getOneObjectAtOffset(-25, 50, Floor.class);
        Actor Floorrightbottom = getOneObjectAtOffset(25, 50, Floor.class);
        if(Platformleftbottom !=null && Platformrightbottom !=null || Floorleftbottom != null && Floorrightbottom != null)
        {
            acceleration = 0;
        }
        else
        {   
            if(Platformleftbottom ==null && Platformrightbottom == null)
            {   
                fall();
                if(vSpeed < 12)
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
     * Prevents the player from clipping into platforms
     */
    public void preventColision()
    {
        Actor PlatformLeftbottom = getOneObjectAtOffset(-25, 56, Platform.class);
        Actor PlatformRightbottom = getOneObjectAtOffset(25, 56, Platform.class);
        Actor FloorLeftbottom = getOneObjectAtOffset(-25, 50, Floor.class);
        Actor FloorRightbottom = getOneObjectAtOffset(25, 50, Floor.class);
        if(PlatformLeftbottom !=null || PlatformRightbottom !=null || FloorLeftbottom !=null || FloorRightbottom !=null)
        {
            vSpeed = 4;
            acceleration = 0;
        }
        Actor PlatformleftTop = getOneObjectAtOffset(-27, -50, Platform.class);
        Actor PlatformrightTop = getOneObjectAtOffset(27, -50, Platform.class);
        if(PlatformleftTop !=null || PlatformrightTop !=null)
        {
            vSpeed = 0;
            fall();
        }
    }

    /**
     * Causes the player to drop semi-realistically
     */
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }

    /**
     * Makes the player jump before plummetting down
     */
    public void jump()
    {
        vSpeed = -jumpStrength;
        fall();
    }
    
    /**
     * Sets the player's jump strength and the barrier depending on the world
     */
    public void currentWorld()
    {
        if(getWorld() instanceof BossFight)
        {
            jumpStrength = 40;
            bossFightBarrier();
        }
        else if(getWorld() instanceof AncientGreece)
        {
            jumpStrength = 25;
            regularBarrier();
            passLevel();
        }
        else if(getWorld() instanceof Olympus)
        {
            jumpStrength = 30;
            regularBarrier();
            passLevel();
        }
        else if(getWorld() instanceof AtlasMountains)
        {
            jumpStrength = 35;
            regularBarrier();
            passLevel();
        }
        else 
        {
            regularBarrier();
            passLevel();
        }
    }
    
    /**
     * Stops the player from walking offscreen in regular levels
     */
    public void regularBarrier()
    {   
        if(getX() >= getWorld().getWidth()-25)
        {
            setLocation(getWorld().getWidth()-25, getY());
        }
        else if(getX() <= getWorld().getWidth()/14 - 75)
        {
            setLocation(getWorld().getWidth()/14 - 75, getY());
        }
    }
    
    /**
     * Stops the player from walking past the mountain peak barriers
     */
    public void bossFightBarrier()
    {   
        if(getX() >= getWorld().getWidth() - 80)
        {
            setLocation(getWorld().getWidth() - 80, getY());
        }
        else if(getX() <= getWorld().getWidth()/14 - 20)
        {
            setLocation(getWorld().getWidth()/14 - 20, getY());
        }
    }
    
    /**
     * Depending on what level you are on, it sends you to the next
     */
    public void passLevel()
    {   
        if(getY() == 0 && getWorld() instanceof AncientGreece)
        {
            Olympus oly = new Olympus();
            Greenfoot.setWorld(oly);
        }
        else if(getY() == 0 && getWorld() instanceof Olympus)
        {
            AtlasMountains am = new AtlasMountains();
            Greenfoot.setWorld(am);
        }
        else if(getY() == 0 && getWorld() instanceof AtlasMountains)
        {
            BossFight bf = new BossFight();
            Greenfoot.setWorld(bf);
        }
    }
}
