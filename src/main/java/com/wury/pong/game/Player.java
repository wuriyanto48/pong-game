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
public class Player {
    
    private int x = Constant.WIDTH - 40;
    private int y = Constant.HEIGHT / 2;
    private int yAxis = 1;
    
    private Game game;
    
    public Player(Game game) {
        this.game = game;
    }
    
    public void move() {
        if(y + yAxis > 0 && y + yAxis < Constant.HEIGHT - Constant.PLAYER_HEIGHT) y = y + yAxis;
    }
    
    public int getYAxis() {
        return yAxis;
    }
    
    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, Constant.PLAYER_WIDTH, Constant.PLAYER_HEIGHT);
    }
    
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, Constant.PLAYER_WIDTH, Constant.PLAYER_HEIGHT);
    }

}
