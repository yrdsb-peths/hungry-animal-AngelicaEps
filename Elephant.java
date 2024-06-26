import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    int speed = 3;
    
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length;i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        animationTimer.mark();
        
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return; 
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a"))
        {
            move(-speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(speed);
            facing = "right";
        }
        
        eat();
        
        animateElephant();
        
    }

    // Eats the apple and spawns new apple. 
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
        else if(isTouching(SlowApple.class))
        {
           removeTouching(SlowApple.class);
            MyWorld world = (MyWorld) getWorld();
            world.level -= 1; 
            world.createApple();
        }
        else if(isTouching(ScoreUp.class))
        {
            removeTouching(ScoreUp.class);
            MyWorld world = (MyWorld) getWorld();
            world.score += 3;
            world.createApple();
        }
        else if(isTouching(SpeedUp.class))
        {
            removeTouching(SpeedUp.class);
            MyWorld world = (MyWorld) getWorld();
            speed = 5;
            world.createApple();
        }
    }
    
}
