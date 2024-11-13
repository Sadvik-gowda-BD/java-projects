package com.systemdesign.snakeAndLadder;

import java.util.Queue;

public class Game {

    public static void main(String[] args) {
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();

        Player player1 = new Player("abc", 0);
        Player player2 = new Player("def", 0);
        Player player3 = new Player("ghi", 0);

        snakeAndLadder.addPlayer(player1);
        snakeAndLadder.addPlayer(player2);
        snakeAndLadder.addPlayer(player3);

        System.out.println("Game started:");
        while (snakeAndLadder.canContinueGame()) {
            Player currPlayer = snakeAndLadder.getCurrentPlayer();
            int pos = Dice.rollDice();
            System.out.println("Current player:" + currPlayer.name + " current position:" + currPlayer.pos);
            snakeAndLadder.movePosition(currPlayer, pos);
        }

        Queue<Player> winners = snakeAndLadder.getWinnerList();

        int rank = 1;
        while (!winners.isEmpty()) {
            System.out.println("Rank:" + rank + " " + winners.poll().name);
            rank++;
        }

    }
}
