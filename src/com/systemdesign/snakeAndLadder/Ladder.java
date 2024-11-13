package com.systemdesign.snakeAndLadder;

import java.util.HashMap;

public class Ladder {

    static final HashMap<Integer, Integer> ladder = new HashMap<>();

    static {
        ladder.put(10, 25);
        ladder.put(13, 33);
    }

    public static boolean canJump(int boxNum) {
        return ladder.containsKey(boxNum);
    }

    public static Integer jumpTo(int boxNum) {
        Integer box = ladder.get(boxNum);
        if (box == null) {
            throw new RuntimeException("Can't jump");
        }
        return box;
    }
}
