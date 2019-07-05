package com.company;

class Board {
    private char[][] board;
    private char p1symbol, p2symbol;
    private int boardSize = 3;
    private int count;
    final static int PLAYER_1_WINS = 1;
    final static int PLAYER_2_WINS = 2;
    private final static int DRAW = 3;
    final static int INCOMPLETE = 4;
    final static int INVALID = 5;

    Board(char p1symbol, char p2symbol) {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;
    }

    void print() {
        System.out.println("-------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------");
    }

    int move(char symbol, int x, int y) {
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != ' ') {
            return INVALID;
        }
        board[x][y] = symbol;
        count++;
        if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if (count == boardSize * boardSize) {
            return DRAW;
        }
        return INCOMPLETE;
    }
}
