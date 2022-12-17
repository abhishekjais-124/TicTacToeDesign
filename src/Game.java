import ticTacToe.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Queue<Player> players = new LinkedList<>();
    Board board;
    int size;

    public Game(int size){
        intializeGame(size);
    }

    private void intializeGame(int size) {
        Player player1 = new Player("player1", new PieceX());
        Player player2 = new Player("player2", new PieceO());
        players.add(player1);
        players.add(player2);
        board = new Board(size);
        this.size = size;
    }

    public void startGame(){
        Player winner = null;
        for(int round = 0;round < size*size; round++){
            Player playerTurn = getNextPlayer();
            board.printBoard();
            boolean validMove = false;
            while (validMove == false) {
                //read the user input
                System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
                Scanner inputScanner = new Scanner(System.in);
                String s = inputScanner.nextLine();
                String[] values = s.split(",");
                int inputRow = Integer.valueOf(values[0]);
                int inputColumn = Integer.valueOf(values[1]);
                validMove = board.addPiece(inputRow, inputColumn, playerTurn.getPiece());
                if (validMove == false) System.out.println("Please enter valid row and columns");
            }
            if (checkWinner(playerTurn.getPiece().getPieceType())) {
                board.printBoard();
                winner = playerTurn;
                break;
            }
        }

        if (winner == null){
            System.out.println("Draw");
        }else{
            System.out.println("Winner is "+ winner.getName());
        }

    }

    private Player getNextPlayer(){
        Player player = players.remove();
        players.add(player);
        return player;
    }

    private boolean checkWinner(PieceType pType){

        for (int i = 0; i < board.getSize(); i++){
            int c = 0;
            for (int j = 0; j < board.getSize(); j++){
                if (board.getBoard()[i][j] != null && pType == board.getBoard()[i][j].getPieceType())	c++;
            }
            if (c == board.getSize()) return true;
        }

        for (int i = 0; i < board.getSize(); i++){
            int c = 0;
            for (int j = 0; j < board.getSize(); j++){
                if (board.getBoard()[i][j] != null && pType == board.getBoard()[i][j].getPieceType())	c++;
            }
            if (c == board.getSize()) return true;
        }


        for (int i = 0; i < board.getSize(); i++){
            int c = 0,d = 0;
            for (int j = 0; j < board.getSize(); j++){
                if (i==j && board.getBoard()[i][j] != null && pType == board.getBoard()[i][j].getPieceType())	c++;
                if (i+j == board.getSize() - 1 && board.getBoard()[i][j] != null &&  pType == board.getBoard()[i][j].getPieceType())	d++;
            }
            if (c == board.getSize() || d == board.getSize()) return true;
        }

        return false;

    }

}
