package com.example.snakesandladders.models.board;

import java.util.Map;

public class Snakes {
    private final Map<Integer, Integer> positions;

    public Snakes(Map<Integer, Integer> positions) {
        this.positions = positions;
    }

    public Map<Integer, Integer> getPositions() {
        return positions;
    }
}
