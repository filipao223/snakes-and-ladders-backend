package com.example.snakesandladders.controllers.impl;

import com.example.snakesandladders.controllers.GameController;
import com.example.snakesandladders.models.player.Player;
import com.example.snakesandladders.services.GameService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameControllerImpl implements GameController {

    private final GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/move/{playerName}")
    public ResponseEntity<?> playerMove(@PathVariable String playerName) {
        return ResponseEntity.ok(gameService.playerMove(playerName));
    }

    @PostMapping(value = "/reset", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newGame(@RequestBody List<Player> players) {
        return ResponseEntity.ok(gameService.newGame(players));
    }
}
