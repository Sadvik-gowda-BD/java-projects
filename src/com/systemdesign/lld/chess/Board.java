package com.systemdesign.lld.chess;

import com.systemdesign.lld.chess.pieces.Rook;

public class Board {
    Box[][] boxes;
    public Board(){
        this.initialize();
    }

    public void initialize(){
        boxes = new Box[8][8];
        boxes[0][0] = new Box(0,0,new Rook(true));


    }
}
