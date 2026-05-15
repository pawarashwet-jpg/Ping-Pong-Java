package com.ashwet.pingpong;  
public class CollisionManager{
    public static int Player1Score = 0;
    public static int Player2Score = 0;

    public static void checkBallCollision(Ball b){
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = (int)(FRAME_WIDTH * 0.55);
        final int BALL_COLLISION_R_PADDING = 6;
        final int BALL_COLLISION_B_PADDING = 36;

        //LEFT WALL COLLISION
        if(b.x <= 0){
            Player2Score++;
            b.resetBall();
        }
        //RIGHT WALL COLLISION
        if(b.x >= FRAME_WIDTH - b.BALL_DIAMETER - BALL_COLLISION_R_PADDING){
            Player1Score++;
            b.resetBall();
        }
        //TOP & BOTTOM WALL COLLISION
        if(b.y <= 0 || b.y >= (FRAME_HEIGHT - b.BALL_DIAMETER - BALL_COLLISION_B_PADDING)){
            b.yVelocity = -b.yVelocity;
        }
    }

    public static void checkPadCollision(Ball b, Pads p){
        int speedIncrease = 1;
        int maxSpeed = 15;

        if (p.px < 500) { 
        
        if (b.x <= p.px + p.PAD_WIDTH && //ball's left side and pads right
            b.y + b.BALL_DIAMETER >= p.py &&  //ball's left side and pads right
            b.y <= p.py + p.PAD_HEIGHT) { //ball's top and pads bottom
            
            b.xVelocity = Math.abs(b.xVelocity); //BOUNCE RIGHT


            if (Math.abs(b.yVelocity) < maxSpeed) {
                b.yVelocity += (b.yVelocity > 0) ? speedIncrease : -speedIncrease;
            }
        }
    } 
else {
    if (b.x + b.BALL_DIAMETER >= p.px && //ball's left side and pads right
        b.y + b.BALL_DIAMETER >= p.py && //ball's left side and pads right
        b.y <= p.py + p.PAD_HEIGHT) { //ball's top and pads bottom

        b.xVelocity = -Math.abs(b.xVelocity); // Force move LEFT
        
        b.x = p.px - b.BALL_DIAMETER - 1; 

        if (Math.abs(b.yVelocity) < maxSpeed) {
            b.yVelocity += (b.yVelocity > 0) ? speedIncrease : -speedIncrease;
        }
    }
}
}}
