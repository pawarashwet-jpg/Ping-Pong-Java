package com.ashwet.pingpong;  
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pads extends JPanel implements KeyListener{
    int px,py;

    final int PAD_HEIGHT = 100;
    final int PAD_WIDTH = 20;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = (int)(FRAME_WIDTH * 0.55);

    final int PAD_PADDING = 41;
    public boolean isLeftPlayer;
    public boolean isRightPlayer;

    int pad_yVelocity = 0;
    int Speed = 10;

    //PADS INITIALIZATION
    Pads(int xStart, int yStart, boolean isLeft, boolean isRight){
        this.px = xStart;
        this.py = yStart;
        this.setOpaque(false);
        this.isLeftPlayer = isLeft;
        this.isRightPlayer = isRight;

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // Convert to 2D for better tools    
        // This makes the edges of the ball smooth (Anti-Aliasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawRect(px,py, PAD_WIDTH, PAD_HEIGHT);
        g2.setColor(Color.RED);
        g2.fillRect(px, py, PAD_WIDTH, PAD_HEIGHT);        
    }

    //MOVE THE PADELS
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(isLeftPlayer){
            if(key== KeyEvent.VK_W){
                pad_yVelocity = -Speed;
            }
            if(key == KeyEvent.VK_S){
                pad_yVelocity = Speed;
            }
        }
        if(isRightPlayer){
            if(key == KeyEvent.VK_UP){
                pad_yVelocity = -Speed;
            }
            if(key == KeyEvent.VK_DOWN){
                pad_yVelocity = Speed;
            }
        }
    }

    //STOP THE MOVEMENT
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (isLeftPlayer) {
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                pad_yVelocity = 0;
            }
        }
        if (isRightPlayer) {
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
                pad_yVelocity = 0;
            }
        }
    }

    //STOPS THE PADEL FROM GOING OFF-SCREEN
    public void move(){
        py +=pad_yVelocity;
        if(isLeftPlayer){
            if(py <= 0){
                py = 0;
            }
            if(py >= (FRAME_HEIGHT - PAD_HEIGHT) - PAD_PADDING){
                py = FRAME_HEIGHT - PAD_HEIGHT - PAD_PADDING;
            }
        }
        if(isRightPlayer){
            if(py <= 0){
                py = 0;
            }
            if(py >= FRAME_HEIGHT - PAD_HEIGHT - PAD_PADDING){
                py = FRAME_HEIGHT - PAD_HEIGHT - PAD_PADDING;
            }
        }
    }


    public void keyTyped(KeyEvent e) {
        //leave empty
    }
}
