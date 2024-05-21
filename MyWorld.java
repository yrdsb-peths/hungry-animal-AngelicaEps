import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1, false); 
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    public void createApple()
    {
        if(level > 1)
        {
            if(Greenfoot.getRandomNumber(8) == 1)
            {
                SlowApple slowApple = new SlowApple();
                int a = Greenfoot.getRandomNumber(600);
                int b = 0;
                addObject(slowApple, a, b);
            }
            else if(Greenfoot.getRandomNumber(7) == 2)
            {
                ScoreUp scoreUp = new ScoreUp();
                int a = Greenfoot.getRandomNumber(600);
                int b = 0;
                addObject(scoreUp, a, b);
            }
            else if (Greenfoot.getRandomNumber(10) == 3)
            {
                SpeedUp speedUp = new SpeedUp();
                int a = Greenfoot.getRandomNumber(600);
                int b = 0;
                addObject(speedUp, a, b);
            }
            else
            {
                Apple apple = new Apple();
                apple.setSpeed(level);
                int x = Greenfoot.getRandomNumber(600);
                int y = 0;
                addObject(apple, x, y);
            }
        }
        else if(Greenfoot.getRandomNumber(7) == 2)
        {
            ScoreUp scoreUp = new ScoreUp();
            int a = Greenfoot.getRandomNumber(600);
            int b = 0;
            addObject(scoreUp, a, b);
        }
        else
        {
            Apple apple = new Apple();
            apple.setSpeed(level);
            int x = Greenfoot.getRandomNumber(600);
            int y = 0;
            addObject(apple, x, y);
        }

    }
}