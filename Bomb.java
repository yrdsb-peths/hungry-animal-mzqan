import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Danger for our elephant.
 * 
 * @author Megan Lee
 * @version May 2023
 */
public class Bomb extends Actor
{
    private int speed = 1;
    public void act(){
        //Bomb falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //If bomb gets to bottom, remove bomb
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.createBomb();
        }
    }
    /**
     * Set speed at which bomb falls
     * 
     */
    public void setSpeed(int spd) {
        speed = spd; 
    }
}
