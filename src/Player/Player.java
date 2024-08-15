package Player;

import Piece.IPiece;

public class Player extends IPlayer {
    public Player(IPiece piece, String name) {
        this.piece = piece;
        this.playerName = name;
    }
}
