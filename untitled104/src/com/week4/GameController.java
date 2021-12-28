package com.week4;

import javax.swing.*;

public class GameController {
    GameModel gameModel;

    public GameController() {
        gameModel = new GameModel();
    }

    public char playerTurn() {
        return gameModel.getPlayer();
    }

    public boolean turn(int i, int j, JButton button, JLabel info, JLabel message) {
        if (gameModel.add(i,j)) {
            button.setText(String.valueOf(gameModel.getPlayer()));
            gameModel.switchPlayer();
            gameModel.doTurn();
            info.setText("Ход игрока " + gameModel.getPlayer());
            message.setText("");
            return endGame(info);
        }
        else {
            message.setText("Ячейка занята!");
            return false;
        }
    }

    public boolean endGame(JLabel info) {
        if (gameModel.getTurnCount() == 9){
            info.setText("Ничья!");
            return true;
        }
        else if (gameModel.win() != '-'){
            gameModel.switchPlayer();
            info.setText("Победил игрок " + gameModel.getPlayer() + "!");
            return true;
        }
        return false;
    }
}
