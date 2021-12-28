package com.week4;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        GameView gameView = new GameView(gameController);
        SwingUtilities.invokeLater(gameView::init);
    }
}

