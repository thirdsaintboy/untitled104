package com.week4;

public class GameModel {
    private final char[][] field = new char[3][3];
    private int turnCount;
    private char player;

    public int getTurnCount() {
        return turnCount;
    }

    public char getPlayer() {
        return player;
    }

    public void doTurn(){
        turnCount ++;
    }

    public GameModel(){
        for (int i = 0; i < 3; i++){
            for (int j =  0; j < 3; j++){
                field[i][j] = '-';
            }
        }
        player = 'X';
        turnCount = 0;
    }

    public boolean add(int i, int j){
        if (i < 3 && j < 3 && field[i][j] == '-'){
            field[i][j] = player;
            return true;
        }
        else return false;
    }

    public char win(){
        for (int i = 0; i < 3; i++){
            if (field[i][0] + field[i][1] + field[i][2] == 264 || field[0][i] + field[1][i] + field[2][i] == 264)
                return 'X';
            else if (field[i][0] + field[i][1] + field[i][2] == 144 || field[0][i] + field[1][i] + field[2][i] == 144)
                return '0';
        }
        if (field[0][0] + field[1][1] + field[2][2] == 264 || field[0][2] + field[1][1] + field[2][0] == 264)
            return 'X';
        else if (field[0][0] + field[1][1] + field[2][2] == 144 || field[0][2] + field[1][1] + field[2][0] == 144)
            return '0';
        return '-';
    }

    public void switchPlayer(){
        if (player == 'X')
            player = '0';
        else
            player = 'X';
    }
}
