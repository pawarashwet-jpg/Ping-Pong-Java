package com.ashwet.pingpong;  
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameFrame extends Rectangle{
    final int PAD_HEIGHT = 100;
    final int PAD_WIDTH = 20;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = (int)(FRAME_WIDTH * 0.55);

    int Speed = 2;
    boolean isLeftPlayer;
    int pad_yVelocity;

    GameFrame(){
        //Getting the Frame to display
        JFrame frame = new JFrame();
        frame.setTitle("Ping Pong");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setResizable(false); //stops the user from changing the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //centers the window
        //frame.pack();


        //IMPORTING PADELS
        Pads player1 = new Pads(0, (FRAME_HEIGHT/2) - PAD_HEIGHT, true,false);//495 = frame width - pad width
        player1.setBounds(0,0,FRAME_WIDTH, FRAME_HEIGHT);
        player1.isLeftPlayer = true;

        Pads player2 = new Pads(FRAME_WIDTH - PAD_WIDTH -18, (FRAME_HEIGHT/2)- PAD_HEIGHT, false, true);
        player2.setBounds(0,0,FRAME_WIDTH, FRAME_HEIGHT);

        //IMPORTING BALL
        Ball ball = new Ball(player1, player2);
        ball.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        //adding the ball and the padel to the window
        frame.add(ball);
        frame.add(player1);
        frame.add(player2);
        
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                player1.keyPressed(e);
                player2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player1.keyReleased(e);
                player2.keyReleased(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // This MUST be here, even if empty, to satisfy the interface
            }
        });

        frame.setFocusable(true); // Ensure the frame can receive focus
        frame.setVisible(true); //MUST BE AT THE END
    }
    
}

