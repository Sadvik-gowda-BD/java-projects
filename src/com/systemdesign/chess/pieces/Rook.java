package com.systemdesign.chess.pieces;

import com.systemdesign.chess.Board;
import com.systemdesign.chess.Box;
import com.systemdesign.chess.Piece;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box from, Box to) {
        return false;
    }
}
