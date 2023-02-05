package com.example.snakesandladders.services.impl;

import com.example.snakesandladders.config.AppConfiguration;
import com.example.snakesandladders.models.board.Board;
import com.example.snakesandladders.models.board.Ladders;
import com.example.snakesandladders.models.board.Snakes;
import com.example.snakesandladders.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    AppConfiguration appConfiguration;

    @Override
    public Board createBoard() {
        return new Board(
                new Snakes(appConfiguration.getBoardSnakePositions()),
                new Ladders(appConfiguration.getBoardLadderPositions())
        );
    }
}
