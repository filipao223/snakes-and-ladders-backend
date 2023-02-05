package com.example.snakesandladders.services;

import com.example.snakesandladders.models.game.Game;
import com.example.snakesandladders.models.player.Player;

import java.util.List;

public interface GameService {

    Game newGame(List<Player> players);

    Game playerMove(String playerName);
}
