import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Megan Lee
 * @version May 2023
 */
public class Apple extends Actor {
    private int speed = 1;
    
    public void act(){
        //Apple falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //If apple gets to bottom, remove apple and draw game over
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.gameOver();
            world.removeObject(this);
            Greenfoot.stop();
        }
    }
    
    /**
     * Set speed at which apple falls
     * 
     */
    public void setSpeed(int spd) {
        speed = spd; 
    }
}
