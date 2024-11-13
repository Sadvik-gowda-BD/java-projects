package com.systemdesign.snakeAndLadder;

import java.util.HashMap;

public final class Snake {

    static final HashMap<Integer, Integer> snake = new HashMap<>();

    static {
        snake.put(20, 10);
        snake.put(30, 15);
    }

    public static boolean canSnakeBite(int boxNum) {
        return snake.containsKey(boxNum);
    }

    public static Integer getFallToBox(int boxNum) {
        Integer toBox = snake.get(boxNum);
        if (toBox == null) {
            throw new RuntimeException("No fall");
        }
        return toBox;
    }
}
