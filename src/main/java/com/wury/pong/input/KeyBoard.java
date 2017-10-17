package com.wury.pong.input;

import com.wury.pong.game.Game;
import com.wury.pong.game.shared.Constant;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author WURI
 * 2017/10/17
 */
public class KeyBoard implements KeyListener {
    
    private Game game;
    
    public KeyBoard(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //game.getPlayer().move();
        
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            game.getPlayer().setYAxis(-1);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            game.getPlayer().setYAxis(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //game.getPlayer().setYAxis(Constant.HEIGHT / 2);
    }

}
