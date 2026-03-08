package com.systemdesign.lld.chess.pieces;

import com.systemdesign.lld.chess.Board;
import com.systemdesign.lld.chess.Box;
import com.systemdesign.lld.chess.Piece;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box from, Box to) {
        return false;
    }
}
