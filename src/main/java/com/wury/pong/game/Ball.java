package com.wury.pong.game;

import com.wury.pong.game.shared.Constant;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author WURI
 * 2017/10/17
 */
public class Ball {
    
    private int x = Constant.WIDTH / 2;
    private int y = Constant.HEIGHT / 2;
    private int xAxis = 1;
    private int yAxis = 1;
    
    private Game game;
    
    public Ball(Game game) {
        this.game = game;
    }
    
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
        
        if(isPlayerCollide()) {
            xAxis = -1;
            System.out.println("jes");
        }
        
        if(isEnemyCollide()) {
            xAxis = +1;
            System.out.println("jes");
        }
        
        x = x + xAxis;
        y = y + yAxis;
    }
    
    private boolean isPlayerCollide() {
        Rectangle ballRect = new Rectangle(x, y, Constant.BALL_DIAMETER, Constant.BALL_DIAMETER);
        return game.getPlayer().getBounds().intersects(ballRect);
    }
    
    private boolean isEnemyCollide() {
        Rectangle ballRect = new Rectangle(x, y, Constant.BALL_DIAMETER, Constant.BALL_DIAMETER);
        return game.getEnemy().getBounds().intersects(ballRect);
    }
    
    public void draw(Graphics2D g) {
        ImageIcon ballIcon = new ImageIcon(Ball.class.getClassLoader().getResource("ball.png"));
        g.drawImage(ballIcon.getImage(), x, y, Constant.BALL_DIAMETER, Constant.BALL_DIAMETER, null);
    }

}
