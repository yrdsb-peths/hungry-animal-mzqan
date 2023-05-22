import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Megan Lee 
 * @version May 2023
 */
public class Elephant extends Actor{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("bombexplosion.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Elephant () {
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
        
        //Initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
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
        //Remove apple if elephant eats it
        eat();
        explode();
        
        //Animate the elephant
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten.
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
