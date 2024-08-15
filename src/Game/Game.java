package Game;

import Board.IBoard;
import Piece.IPiece;
import Player.IPlayer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Game extends IGame {

    public Game(Deque<IPlayer> playerDeque, IBoard board) {
        this.playerChances = playerDeque;
        this.board = board;
    }

    @Override
    public void playGame() {
        while(!this.playerChances.isEmpty()) {
            IPlayer player = this.playerChances.poll();
            this.playerChances.add(player);
            this.board.printBoard();
            System.out.println("Enter coordinates for your chance! ");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            this.board.addPiece(x,y, player.piece);

            if(this.board.isWinner(x,y, player.piece)) {
                System.out.println("You won!");
                return;
            }
            else if(this.board.isFull()) {
                System.out.println("No winner!");
                return;
            }
        }
    }
}
