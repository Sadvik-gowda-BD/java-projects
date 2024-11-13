package com.systemdesign.snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    Queue<Player> players = new LinkedList<>();
    Queue<Player> winners = new LinkedList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public void movePosition(Player player, int pos) {
        int nextPos = player.pos + pos;

        if (nextPos == 100) {
            player.pos = nextPos;
            winners.add(player);
            players.remove();
        } else if (nextPos < 100) {
            if (Ladder.canJump(nextPos)) {
                nextPos = Ladder.jumpTo(nextPos);
            } else if (Snake.canSnakeBite(nextPos)) {
                nextPos = Snake.getFallToBox(nextPos);
            }
            player.pos = nextPos;
            players.add(players.remove());
        } else {
            players.add(players.remove());
        }
    }

    public boolean canContinueGame() {
        return players.size() > 1;
    }

    public Queue<Player> getWinnerList() {
        return winners;
    }
}
