package com.example.snakesandladders.config;

import java.util.Map;

public interface AppConfiguration {
    Boolean isFrontendEnabled();

    Map<Integer, Integer> getBoardSnakePositions();

    Map<Integer, Integer> getBoardLadderPositions();
}
