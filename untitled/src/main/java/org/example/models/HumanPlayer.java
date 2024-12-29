package org.example.models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public String email;

    public HumanPlayer(String name, Character symbol, int id) {
        super(name, symbol, id);
    }

    public HumanPlayer(String name, Character symbol, int id, String email) {
        super(name, symbol, id);
        this.email = email;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(this.name+" make your move");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Move(row,col);
    }
}
