package com.wury.pong;

import com.wury.pong.game.Game;
import com.wury.pong.game.shared.Constant;
import javax.swing.JFrame;

/**
 *
 * @author WURI
 * 2017/10/17
 */
public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new JFrame("Pong");
        Game game = new Game();
        frame.add(game);
        frame.setSize(Constant.WIDTH, Constant.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();
    }

}
