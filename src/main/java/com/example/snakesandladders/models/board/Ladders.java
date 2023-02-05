package com.example.snakesandladders.models.board;

import java.util.Map;

public class Ladders {
    private final Map<Integer, Integer> positions;

    public Ladders(Map<Integer, Integer> positions) {
        this.positions = positions;
    }

    public Map<Integer, Integer> getPositions() {
        return positions;
    }
}
