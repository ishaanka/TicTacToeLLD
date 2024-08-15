import Board.Board;
import Board.IBoard;
import Game.Game;
import Game.IGame;
import Piece.CirclePiece;
import Piece.CrossPiece;
import Player.IPlayer;
import Player.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ! Enter player 1 name : ");
        String playerName1 = scanner.next();
        IPlayer player1 = new Player(new CirclePiece(), playerName1);
        System.out.println("Cool ! Enter player 2 name : ");
        String playerName2 = scanner.next();
        IPlayer player2 = new Player(new CrossPiece(), playerName2);
        Deque<IPlayer> players = new ArrayDeque<IPlayer>();
        players.add(player1);
        players.add(player2);

        IBoard board = new Board(3);

        IGame game = new Game(players, board);

        game.playGame();

    }
}