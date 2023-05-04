import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero lives in.
 * 
 * @author Megan Lee
 * @version May 2023
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        Label scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    

    /**
     * Create a new apple at a random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
