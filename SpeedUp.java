import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedUp extends Actor
{
    /**
     * Act - do whatever the SpeedUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(),getY()+3);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.createApple();
        }
    }
}
