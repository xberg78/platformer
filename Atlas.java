import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Atlas extends Enemy
{
    private int attackDelay = 0;
    private int jumpDelay = 0;
    private int hSpeed = 1;
    private int vSpeed = 2;
    private int acceleration = 2;
    private int jumpStrength = 25;
    private boolean turn = false;
    
    /**
     * Act - do whatever the Faller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        attackDelay++;
        
        jumpDelay++;
        
        move();
        
        checkFall();
        
        checkKill();
        
        atlasTurn();
        
        attack();
        
        jump();
    }
    
    /**
     * Allows Atlas to constantly move
     */
    public void move()
    {
        setLocation (getX() - hSpeed, getY());
    }
    
    /** 
     * Returns if Atlas is on the floor
     */
    public boolean onFloor()
    {
        Actor on = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Floor.class);
        return on != null;
    }
    
    /**
     * Checks if Atlas should fall
     */
    public void checkFall()
    {
        if(onFloor())
        {
            vSpeed = 0;
            setLocation(getX(), getWorld().getHeight()-110);
        }
        else if(getY() >= getWorld().getHeight()-45)
        {
            setLocation(getX(), getWorld().getHeight()-110);
        }
        else
        {
            fall();
        }
    }
    
    /**
     * Causes Atlas to fall if need be
     */
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    /**
     * Every 125 act methods, a cloud will be shot to the right
     */
    public void attack()
    {
        if(attackDelay > 125 && !turn)
        {
            Attack cloud = new Attack();
            cloud.hSpeed = 3;
            getWorld().addObject(cloud, getX() - 25, getY() + 20);
            attackDelay = 0;
        }
        else if(attackDelay > 125 && turn)
        {
            Attack cloud = new Attack();
            cloud.hSpeed = -3;
            getWorld().addObject(cloud, getX() + 25, getY() + 20);
            attackDelay = 0;
        }
    }
    
    /**
     * A turn method specifically for Atlas, as he has special methods
     */
    public void atlasTurn()
    {
        if(getX() >= getWorld().getWidth() * 13/14)
        {
            setLocation(getWorld().getWidth() * 13/14 - 2, getY());
            hSpeed = -hSpeed;
            setImage(lAtlas);
            turn = false;
        }
        else if(getX() <= getWorld().getWidth()/14 - 30)
        {
            setLocation(getWorld().getWidth()/14 - 28, getY());
            hSpeed = -hSpeed;
            setImage(rAtlas);
            turn = true;
        }
    }
    
    /**
     * Every 175 act methods, Atlas jumps
     */
    public void jump()
    {
        if(jumpDelay > 175)
        {
            vSpeed = -jumpStrength;
            fall();
            jumpDelay = 0;
        }
    }
}
