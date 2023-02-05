package com.example.snakesandladders.services.impl;

import com.example.snakesandladders.services.DiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceServiceImpl implements DiceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiceServiceImpl.class);

    private static final int MAX_NUMBER = 6;
    private static final int MIN_NUMBER = 1;

    private final Random dice;

    public DiceServiceImpl() {
        this.dice = new Random();
    }

    @Override
    public Integer rollDice() {
        Integer firstRoll = dice.nextInt(MAX_NUMBER - MIN_NUMBER) + 1;
        Integer secondRoll = dice.nextInt(MAX_NUMBER - MIN_NUMBER) + 1;

        if (firstRoll.equals(secondRoll)) {
            LOGGER.info("Player has rolled doubles!");
            return firstRoll
                    + secondRoll
                    + dice.nextInt(MAX_NUMBER - MIN_NUMBER) + 1
                    + dice.nextInt(MAX_NUMBER - MIN_NUMBER) + 1;
        }

        return firstRoll + secondRoll;
    }
}
