package com.example.snakesandladders.models.board;

public class Board {
    private final Snakes snakes;
    private final Ladders ladders;

    public Board(Snakes snakes, Ladders ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Snakes getSnakes() {
        return snakes;
    }

    public Ladders getLadders() {
        return ladders;
    }
}
