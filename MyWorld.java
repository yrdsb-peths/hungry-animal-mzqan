import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero lives in.
 * 
 * @author Megan Lee
 * @version May 2023
 */
public class MyWorld extends World {    
    //Var for points scored
    public int score = 0;

    //Scope of scoreLabel
    Label scoreLabel;
    
    //Var for increasing difficulty
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
        createBomb();
    }
    
    /**
     * End the game and draw 'Game Over'
     */
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0) {
            level+=1;
        }
    }
    
    /**
     * Decrease score
     */
    public void decreaseScore() {
        score--;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at a random location at top of screen
     */
    public void createApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * Create a new bomb at a random location at top of screen
     */
    public void createBomb(){
        Bomb bomb = new Bomb();
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bomb, x, y);
    }
}
