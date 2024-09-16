package com.systemdesign.chess.pieces;

import com.systemdesign.chess.Board;
import com.systemdesign.chess.Box;
import com.systemdesign.chess.Piece;

public class King extends Piece {

    public King(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Box from, Box to) {
        return false;
    }
}
