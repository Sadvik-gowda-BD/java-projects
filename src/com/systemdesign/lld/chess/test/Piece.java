package com.systemdesign.lld.chess.test;

public interface Piece {
    boolean move(Box from, Box to);
    boolean isWhite();
}
