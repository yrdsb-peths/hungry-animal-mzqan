import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int speed = 1;

    public void act(){
        //Bomb falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //Remove bomb and create new bomb when it reaches the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.createBomb();
        }
    }
    
    public void setSpeed(int spd) {
        speed = spd; 
    }
}
