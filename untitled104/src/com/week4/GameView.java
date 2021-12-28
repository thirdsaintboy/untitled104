package com.week4;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private GameController gameController;
    private JButton[][] fieldButton;
    private JButton playButton;
    private JLabel messageLabel;
    private JLabel infoLabel;
    Font fieldFont = new Font("TimesRoman", Font.BOLD, 25);
    Font buttonFont = new Font("TimesRoman", Font.BOLD, 40);
    ImageIcon img = new ImageIcon("icon.png");

    public GameView(GameController gameController) {
        this.gameController = gameController;
    }

    public void init() {
        setSize(600, 350);
        setIconImage(img.getImage());
        setTitle("Крестики-Нолики");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fieldButton = new JButton[3][3];
        playButton = new JButton("Играть");
        infoLabel = new JLabel("Крестики-Нолики");
        messageLabel = new JLabel("");

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                fieldButton[i][j] = new JButton("-");
                fieldButton[i][j].setFont(buttonFont);
                fieldButton[i][j].setBounds(i * 100,j * 100,100,100);
                fieldButton[i][j].setEnabled(false);
                add(fieldButton[i][j]);
            }

        playButton.setBounds(420, 280, 80, 20);
        add(playButton);

        infoLabel.setBounds(350, 0, 220, 30);
        infoLabel.setFont(fieldFont);
        add(infoLabel);

        messageLabel.setBounds(350, 30, 200, 30);
        add(messageLabel);

        playButton.addActionListener(e ->{
            gameController = new GameController();
            clearBtn();
            enableBtn(true);
            infoLabel.setText("Ход игрока " + gameController.playerTurn());
        });

        fieldButton[0][0].addActionListener(e -> {
            if (gameController.turn(0,0, fieldButton[0][0], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[0][1].addActionListener(e -> {
            if (gameController.turn(0,1, fieldButton[0][1], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[0][2].addActionListener(e -> {
            if (gameController.turn(0,2, fieldButton[0][2], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[1][0].addActionListener(e -> {
            if (gameController.turn(1,0, fieldButton[1][0], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[1][1].addActionListener(e -> {
            if (gameController.turn(1,1, fieldButton[1][1], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[1][2].addActionListener(e -> {
            if (gameController.turn(1,2, fieldButton[1][2], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[2][0].addActionListener(e -> {
            if (gameController.turn(2,0, fieldButton[2][0], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[2][1].addActionListener(e -> {
            if (gameController.turn(2,1, fieldButton[2][1], infoLabel, messageLabel))
                enableBtn(false);
        });
        fieldButton[2][2].addActionListener(e -> {
            if (gameController.turn(2,2, fieldButton[2][2], infoLabel, messageLabel))
                enableBtn(false);
        });
    }

    public void enableBtn(boolean enableBtn) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                fieldButton[i][j].setEnabled(enableBtn);
            }
    }

    public void clearBtn() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                fieldButton[i][j].setText("-");
            }
    }
}
