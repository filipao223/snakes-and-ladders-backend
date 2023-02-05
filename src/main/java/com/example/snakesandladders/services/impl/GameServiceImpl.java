package com.example.snakesandladders.services.impl;

import com.example.snakesandladders.models.board.Board;
import com.example.snakesandladders.models.board.Ladders;
import com.example.snakesandladders.models.board.Snakes;
import com.example.snakesandladders.models.game.Game;
import com.example.snakesandladders.models.player.Player;
import com.example.snakesandladders.services.BoardService;
import com.example.snakesandladders.services.DiceService;
import com.example.snakesandladders.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);

    private final BoardService boardService;
    private final DiceService diceService;

    private Game gameInstance;

    public GameServiceImpl(BoardService boardService, DiceService diceService) {
        this.boardService = boardService;
        this.diceService = diceService;
    }
    @Override
    public Game newGame(List<Player> players) {
        Map<String, Integer> startingPositions = players.stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toMap(playerName -> playerName, playerName -> 0));

        gameInstance = new Game(players, createBoard(), startingPositions);

        LOGGER.info("Starting a new game with {} players... ", players.size());

        return gameInstance;
    }

    @Override
    public Game playerMove(String playerName) {
        Integer diceRoll = diceService.rollDice();

        LOGGER.info("Player {} rolled for {} positions!", playerName, diceRoll);

        Map<String, Integer> playerPositions = gameInstance.getPlayerPositions();

        int currentPosition = playerPositions.get(playerName);

        int i = 0;
        Board board = gameInstance.getBoard();
        for (; i < diceRoll && currentPosition != 100; i++) {
            ++currentPosition;
        }

        // If player exceeded final spot (i is not yet equal to diceRoll), they now go backwards
        for (; i < diceRoll; i++) {
            --currentPosition;
        }

        currentPosition = checkSnakePenalty(currentPosition, board.getSnakes());
        currentPosition = checkLadderAdvantage(currentPosition, board.getLadders());

        LOGGER.info("Player '{}' is now at position {}!", playerName, currentPosition);

        playerPositions.replace(playerName, currentPosition);

        return gameInstance;
    }

    private Board createBoard() {
        return boardService.createBoard();
    }

    private Integer checkSnakePenalty(Integer currentPosition, Snakes snakes) {
        Integer newPosition = snakes.getPositions().getOrDefault(currentPosition, currentPosition);
        if (!Objects.equals(newPosition, currentPosition)) {
            LOGGER.info("Player has hit a snake! Going down {} places...", currentPosition-newPosition);
        }
        return newPosition;
    }

    private Integer checkLadderAdvantage(Integer currentPosition, Ladders ladders) {
        Integer newPosition = ladders.getPositions().getOrDefault(currentPosition, currentPosition);
        if (!Objects.equals(newPosition, currentPosition)) {
            LOGGER.info("Player has hit a ladder! Going up {} places...", newPosition-currentPosition);
        }
        return newPosition;
    }
}
