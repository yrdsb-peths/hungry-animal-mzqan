import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Megan Lee 
 * @version May 2023
 */
public class Elephant extends Actor{
    //Sound effects
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("bombexplosion.mp3");
    
    //Array for sprites
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //Var for direction the elephant is facing
    String facing = "right";
    
    //Manage interval at which animations change
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Elephant () {
        //Assigning array elements to images 
        for(int i = 0; i < idleRight.length;i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        for(int i = 0; i < idleLeft.length;i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i ].scale(100,100);
        }
        
        
        animationTimer.mark();    
        
        //Set initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     * Loop through sprites at 100msec intervals
     * 
     */
    int imageIndex = 0;
    public void animateElephant() {
        if(animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else { 
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    
    public void act() {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        eat();
        explode();
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     * Increase score and play elephant sound effect
     * 
     */
    public void eat() {
        if(isTouching(Apple.class)) {    
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
    /**
     * Explode the bomb and spawn new bomb if bomb is touched
     * Decrease score and play explosion sound effect
     * 
     */
    public void explode() {
        if(isTouching(Bomb.class)) {    
            removeTouching(Bomb.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBomb();
            world.decreaseScore();
            bombSound.play();
        }
    }
}
