package Board;

import Piece.IPiece;

import java.util.ArrayList;
import java.util.List;

public class Board  extends IBoard {
    List<List<IPiece>> board;

    public Board(int size) {
        this.board = new ArrayList<List<IPiece>>(size);
        for(int i = 0; i < size; i++) {
            this.board.add(new ArrayList<IPiece>(size));
        }
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
             this.board.get(i).add(null);
            }
        }
    }

    @Override
    public void addPiece(int x, int y, IPiece piece) {
        if(board.get(x).get(y) == null) {
            board.get(x).set(y, piece);
        }
        else {
            System.out.println("Piece already exists");
        }
    };

    //Check optimize solution for this
    @Override
    public Boolean isWinner(int x, int y, IPiece piece) {
        Boolean isWinner = true;
        int i=x,j=y;
        while(i>=0 && j>=0) {
            if(board.get(i).get(j) == null || board.get(i).get(j).pieceType != piece.pieceType) {
                return false;
            }
            i--; j--;
        }
        i=x; j=y;
        while(i>=0 && j<this.board.size()) {
            if(board.get(i).get(j) == null || board.get(i).get(j).pieceType != piece.pieceType) {
                return false;
            }
            i--; j++;
        }
        i=x; j=y;
        while(j>=0 && i<this.board.size()) {
            if(board.get(i).get(j) == null || board.get(i).get(j).pieceType != piece.pieceType) {
                return false;
            }
            i++; j--;
        }
        i=x; j=y;
        while(i<this.board.size() && j<this.board.size()) {
            if(board.get(i).get(j) == null || board.get(i).get(j).pieceType != piece.pieceType) {
                return false;
            }
            i++; j++;
        }
        for (List<IPiece> iPieces : this.board) {
            if (iPieces.get(y).pieceType == null || iPieces.get(y).pieceType != piece.pieceType) {
                return false;
            }
        }
        for ( j=0;j<this.board.size();j++) {
            if(board.get(x).get(j) == null || this.board.get(x).get(j).pieceType != piece.pieceType) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printBoard() {
        for(List<IPiece> iPieces : this.board) {
            for(IPiece piece : iPieces) {
                if(piece != null) {
                    System.out.print(piece.pieceType+"\t"+"|");
                }
               else {
                   System.out.print("_\t|");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Boolean isFull() {
        for(List<IPiece> iPieces : this.board) {
            for(IPiece piece : iPieces) {
                if(piece == null)
                    return false;
            }
        }
        return true;
    }
}
