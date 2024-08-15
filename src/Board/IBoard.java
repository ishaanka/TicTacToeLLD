package Board;

import Piece.IPiece;

import java.util.List;

public abstract class IBoard {
    List<List<IPiece>> board;

    public abstract void addPiece(int x, int y, IPiece piece);

    public abstract Boolean isWinner(int x, int y, IPiece piece);

    public abstract void printBoard();

    public abstract Boolean isFull();
}
