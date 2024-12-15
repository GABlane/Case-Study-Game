package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // This is the first batch, I'll work with this for this is the scope of our
        // case study

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("The Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}