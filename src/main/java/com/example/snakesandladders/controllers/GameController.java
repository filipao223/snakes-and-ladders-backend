package com.example.snakesandladders.controllers;

import com.example.snakesandladders.models.player.Player;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameController {

    ResponseEntity<?> playerMove(String playerId);

    ResponseEntity<?> newGame(List<Player> players);
}
