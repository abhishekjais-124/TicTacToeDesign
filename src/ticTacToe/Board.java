package ticTacToe;

public class Board {
    
    int size;
    Piece[][] board;

    public Board(int size){
        this.size= size;
        initializeBoard(size);
    }

    private void initializeBoard(int size) {
        board = new Piece[size][size];
    }

    public boolean addPiece(int row, int col, Piece piece){
        if(row < 0 || col < 0 || row >= size || col >= size){
            return false;
        }

        if (board[row][col] != null){
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public void printBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if (board[i][j] == null){
                    if (j == size - 1) System.out.println("  ");
                    else System.out.print("  |");
                }else{
                    if (j == size - 1) System.out.println(" "+board[i][j].getPieceType().name()+"");
                    else System.out.print(" "+board[i][j].getPieceType().name() + "|");
                }
            }
            if (i != size-1){
                for(int j = 0; j < size; j++){
                    if (j==size-1) System.out.print("__");
                    else System.out.print("__.");
                }
                System.out.println("");
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

}
