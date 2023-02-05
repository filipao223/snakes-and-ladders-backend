package com.example.snakesandladders.config.impl;

import com.example.snakesandladders.config.AppConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

@ConstructorBinding
@ConfigurationProperties("app")
public class AppConfigurationImpl implements AppConfiguration {
    private final Boolean frontendEnabled;
    private final Map<Integer, Integer> boardSnakePositions;
    private final Map<Integer, Integer> boardLadderPositions;

    public AppConfigurationImpl(Boolean frontendEnabled,
                                Map<Integer, Integer> boardSnakePositions,
                                Map<Integer, Integer> boardLadderPositions) {
        this.frontendEnabled = frontendEnabled;
        this.boardSnakePositions = boardSnakePositions;
        this.boardLadderPositions = boardLadderPositions;
    }

    public Boolean isFrontendEnabled() {
        return frontendEnabled;
    }

    public Map<Integer, Integer> getBoardSnakePositions() {
        return boardSnakePositions;
    }

    public Map<Integer, Integer> getBoardLadderPositions() {
        return boardLadderPositions;
    }
}
