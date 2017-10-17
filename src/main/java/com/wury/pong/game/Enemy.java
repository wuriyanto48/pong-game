package com.wury.pong.game;

import com.wury.pong.game.shared.Constant;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author WURI
 * 2017/10/17
 */
public class Enemy {
    
    private int x = 20;
    private int y = Constant.HEIGHT / 2;
    private int yAxis = 1;
    
    private Game game;
    
    public Enemy(Game game) {
        this.game = game;
    }
    
    public void move() {
        if(y + yAxis < 0){
            yAxis = 1;
        }
        
        if(y + yAxis > Constant.HEIGHT - Constant.PLAYER_HEIGHT) {
            yAxis = -1;
        }
        
        y = y + yAxis;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT);
    }
    
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT);
    }

}
