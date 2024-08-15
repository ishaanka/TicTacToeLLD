package Game;

import Board.IBoard;
import Piece.IPiece;
import Player.IPlayer;

import java.util.Deque;

public abstract class IGame {
    public Deque<IPlayer> playerChances;
    public IBoard board;

    public abstract void playGame();
}
