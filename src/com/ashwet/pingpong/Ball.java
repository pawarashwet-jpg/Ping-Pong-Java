package com.ashwet.pingpong;  
import java.awt.*;
import javax.swing.*;

public class Ball extends JPanel{
    final int FRAME_WIDTH = 1000;

    final int BALL_DIAMETER = 20;
    int x,y;

    int xVelocity = 6;
    int yVelocity = 6;

    Pads p1,p2;
    Score score;

    Ball(Pads p1, Pads p2){
        this.p1 = p1;
        this.p2 = p2;
        this.setOpaque(false); //need for public void paintComponent(Graphics g) or something
        this.score = new Score(this);

        //Game LOOP
        Thread gameThread = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    //updates ball location
                    moveBall();

                    //Checks for collision by calling the appropriate method
                    CollisionManager.checkBallCollision(Ball.this);
                    CollisionManager.checkPadCollision(Ball.this, p1);
                    CollisionManager.checkPadCollision(Ball.this, p2);

                    //updates the pad
                    p1.move();
                    p2.move();

                    //repaints the screen
                    repaint();
                    try{
                        Thread.sleep(10); //needed or else the screen will update a million time pe second making the ball fly
                    }
                    catch(Exception e ){
                        System.err.println(e.getMessage()); //Just in case
                     }
                }
            }
        });
        gameThread.start();
    }

    public void resetBall(){
        this.x = FRAME_WIDTH/2;
        this.y = (int)(Math.random() * 400) + 50; //Spawns Ball at random position
        xVelocity = -xVelocity; //changes the ball direction
        yVelocity = (yVelocity > 0) ? 6 : -6;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        score.draw(g);
        
        Graphics2D g2 = (Graphics2D) g; // Convert to 2D

        // This makes the edges of the ball smooth (Anti-Aliasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draws and colours the ball
        g2.drawOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
        g2.setColor(Color.RED);
        g2.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);        
    }

    //Move the Ball
    public void moveBall(){
        
        //move the ball by updating the pos
        x += xVelocity;
        y += yVelocity;

        //System.out.println(x);
        
    }


}
