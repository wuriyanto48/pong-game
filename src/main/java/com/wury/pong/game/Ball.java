package com.wury.pong.game;

import com.wury.pong.game.shared.Constant;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author WURI
 */
public class Ball {
    
    private int x = Constant.WIDTH / 2;
    private int y = Constant.HEIGHT / 2;
    private int xAxis = 1;
    private int yAxis = 1;
    
//    private Game game;
//    
//    public Ball(Game game) {
//        this.game = game;
//    }
    
    public void move() {
        if(x + xAxis < 0){
            xAxis = 1;
        }
        
        if(x + xAxis > Constant.WIDTH - Constant.BALL_DIAMETER) {
            xAxis = -1;
        }
        
        if(y + yAxis < 0){
            yAxis = 1;
        }
        
        if(y + yAxis > Constant.HEIGHT - Constant.BALL_DIAMETER) {
            yAxis = -1;
        }
        
        x = x + xAxis;
        y = y + yAxis;
    }
    
    public void draw(Graphics2D g) {
        ImageIcon ballIcon = new ImageIcon(Ball.class.getClassLoader().getResource("ball.png"));
        g.drawImage(ballIcon.getImage(), x, y, Constant.BALL_DIAMETER, Constant.BALL_DIAMETER, null);
    }

}
