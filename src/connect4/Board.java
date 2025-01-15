package connect4;                       //declare part of packge connect4

public class Board {
    private char[][] board;             //declare 2d arr board
    private final int ROWS = 6;         //num rows
    private final int COLS = 7;         //num cols
    
    public Board() {                    //initialize game grid
        board = new char[ROWS][COLS];
        for(int i = 0; i < ROWS; i++) { //every cell of the game grid is a "." to look like empty slot
            for(int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }
    
    public void displayBoard() {
        System.out.println("\n 1 2 3 4 5 6 7");     //print col nums allow players to choose
        for(int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for(int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }                                             //goees through each cell of 2d arr + print value surrounded 
        System.out.println("---------------");      //bottom of board
    }
    
    public boolean dropPiece(int column, char piece) {  //drop pirce X or O and see if conditions allows (enough space, input errors etc...)
        if(column < 1 || column > 7) {
            return false;
        }
        column = column - 1;
        
        for(int row = ROWS-1; row >= 0; row--) {        //start from bottom row looking for "." representing empty slots
            if(board[row][column] == '.') {
                board[row][column] = piece;
                return true;
            }
        }
        return false;                                   //means row is full cuz no "."
    }
    
    public boolean checkWin(char piece) {               //check of X?O has 4 in a row in any direction (vertical, horizontal, diagonal)
        for(int row = 0; row < ROWS; row++) {           //check HORIZONTAL wins (ROWS = 6 btw)
            for(int col = 0; col < COLS-3; col++) {
                if(board[row][col] == piece && 
                   board[row][col+1] == piece &&
                   board[row][col+2] == piece &&
                   board[row][col+3] == piece) {
                    return true;
                }
            }
        }
        
        for(int row = 0; row < ROWS-3; row++) {        //check VERTICAL wins
            for(int col = 0; col < COLS; col++) {
                if(board[row][col] == piece &&
                   board[row+1][col] == piece &&
                   board[row+2][col] == piece &&
                   board[row+3][col] == piece) {
                    return true;
                }
            }
        }
        
        for(int row = 0; row < ROWS-3; row++) {        //check DIAGONAL wins (top lft --> bottom right) :<cooked my brain
            for(int col = 0; col < COLS-3; col++) {
                if(board[row][col] == piece &&
                   board[row+1][col+1] == piece &&
                   board[row+2][col+2] == piece &&
                   board[row+3][col+3] == piece) {
                    return true;
                }
            }
        }
        return false;                                  //no win condition
    }
    
    public boolean isFull() {                          //check board is full no more moves possible
        for(int j = 0; j < COLS; j++) {                //check top row, if there is "." in any of the rows, there is still empty spaces
            if(board[0][j] == '.') {
                return false;
            }
        }
        return true;
    }
}