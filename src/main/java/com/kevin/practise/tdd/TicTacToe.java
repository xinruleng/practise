package com.kevin.practise.tdd;

public class TicTacToe {
    private char[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},};

    private char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);

        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        }
        else if (isDraw()) {
            return "The result is draw";
        }

        return "No winner";
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;

        char horizontal = '\0';
        char vertical = '\0';

        char diagonal1 = '\0';
        char diagonal2 = '\0';

        for (int i = 0; i < 3; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][3 - i - 1];

            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];

        }

        if (horizontal == playerTotal ||
                vertical == playerTotal ||
                diagonal1 == playerTotal ||
                diagonal2 == playerTotal) {
            return true;
        }

        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        }
        else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    private void checkAxis(int x) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
