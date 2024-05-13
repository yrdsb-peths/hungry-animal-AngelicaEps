import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);

        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,102,114);
        elephant.setLocation(106,124);
        elephant.setLocation(110,140);
        Apple apple = new Apple();
        addObject(apple,447,132);
        apple.setLocation(491,151);
        elephant.setLocation(101,160);
        elephant.setLocation(112,141);
        apple.setLocation(487,148);
        apple.setLocation(480,131);
        Label label = new Label("Press Space to Start", 30);
        addObject(label,271,298);
        label.setLocation(294,282);
        removeObject(apple);
        elephant.setLocation(292,100);
        Label label2 = new Label("Press Space to Start", 30);
        addObject(label2,360,338);
        removeObject(label2);
        label2 = new Label("Use A and D to Move", 30);
        addObject(label2,280,346);
        label2.setLocation(296,321);
    }
}
