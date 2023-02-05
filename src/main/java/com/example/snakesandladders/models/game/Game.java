package com.example.snakesandladders.models.game;

import com.example.snakesandladders.models.board.Board;
import com.example.snakesandladders.models.player.Player;

import java.util.List;
import java.util.Map;

public class Game {
    private final List<Player> players;
    private final Board board;
    private final Map<String, Integer> playerPositions;

    public Game(List<Player> players, Board board, Map<String, Integer> playerPositions) {
        this.players = players;
        this.board = board;
        this.playerPositions = playerPositions;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Map<String, Integer> getPlayerPositions() {
        return playerPositions;
    }
}
