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
        //Apple falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //Remove apple and draw game over when apple gets to bottom 
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd) {
        speed = spd; 
    }
}
