package com.ashwet.pingpong; 
import java.awt.*;

public class Score {
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = (int)(FRAME_WIDTH * 0.55);
    final int SCORE_PADDING = 50;
    Score(Ball b){

    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE); //Sets the colour of center line white
        g.drawLine(FRAME_WIDTH/2, 0, FRAME_WIDTH/2, FRAME_HEIGHT); //Creates the center line

        //SET FONT, BOLD, AND THE SIZE OF TEXT
        g.setFont(new Font("Consolas", Font.BOLD, 30));

        //prints score of player 1 and player 2
        g.drawString(String.valueOf(CollisionManager.Player1Score), (FRAME_WIDTH/2) - SCORE_PADDING, SCORE_PADDING);
        g.drawString(String.valueOf(CollisionManager.Player2Score), (FRAME_WIDTH/2) + SCORE_PADDING, SCORE_PADDING);
    }
}
