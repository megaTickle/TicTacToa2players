package com.example.tictactoe2player;

public class Position {
    private int line;
    private int col;

    public Position() { // חייבים פעולה בונה ריקה בשביל ה// fb
    }

    public Position(int line, int color) {
        this.line = line;
        this.col = color;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColor() {
        return col;
    }

    public void setColor(int color) {
        this.col = color;
    }
}
