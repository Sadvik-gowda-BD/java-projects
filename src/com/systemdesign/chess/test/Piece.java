package com.systemdesign.chess.test;

public interface Piece {
    boolean move(Box from, Box to);
    boolean isWhite();
}
