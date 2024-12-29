package org.example.models;

public abstract class Player {

    public String name;
    public Character symbol;
    public int id;

    public abstract Move makeMove(Board board);

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                ", id=" + id +
                '}';
    }

    public Player(String name, Character symbol, int id) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
    }
}
