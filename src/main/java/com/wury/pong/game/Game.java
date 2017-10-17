package com.wury.pong.game;

import com.wury.pong.input.KeyBoard;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author WURI
 * 2017/10/17
 */
public class Game extends JPanel implements Runnable {
    
    private boolean running = false;
    private Thread thread;
    private Ball ball;
    private Player player;
    private Enemy enemy;
    
    public Game(){
        ball = new Ball(this);
        player = new Player(this);
        enemy = new Enemy(this);
        KeyBoard board = new KeyBoard(this);
        addKeyListener(board);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        Graphics2D gd = (Graphics2D) g;
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.draw(gd);
        player.draw(gd);
        enemy.draw(gd);
        g.dispose();
    }
    
    public Ball getBall() {
        return ball;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Enemy getEnemy() {
        return enemy;
    }
    
    public void update() {
        ball.move();
        enemy.move();
        player.move();
    }
    
    public synchronized void start() {
        running = true;
        if(thread == null) {
            thread = new Thread(this, "Pong Thread");
            thread.start();
        }
    }
    
    public synchronized void stop() {
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void run() {
        while(running) {
            update();
            repaint();
            try {
                Thread.sleep(8);
            } catch(InterruptedException e){
                
            }
        }
    }

}
