package connect4;

import java.util.Scanner;   //Scanner from java.util to handle user input

public class Connect4 {     //game logic + usre interations
    private Board board;    //refrence board object representing game board
    private char currentPlayer;
    private GameStats stats;    //refrence GameStats
    
    public Connect4() {         //initialize gane state
        board = new Board();
        currentPlayer = 'X';    //set starting player X
        stats = new GameStats();    //new GAmeStats object
    }
    
    //primary method running game loop (gameplay + players input)
    public void play() {
        Scanner scanner = new Scanner(System.in);   //create "Scanner" object in order to read input from the CONSOLE
        boolean keepPlaying = true;                 //Falg/signal to determine if player wanna continue play multiple games
        
        //OUTER loop to handle multiple games; run as long as player desires
        while(keepPlaying) {
            boolean gameOver = false;
            board = new Board();
            currentPlayer = 'X';
            
            System.out.println("\nWelcome to Connect 4!");
            System.out.println("Player 1: X, Player 2: O");
            
            while(!gameOver) {      //INNER loophandle the single game; run until the game is over (win/draw)
                board.displayBoard();   //display current state
                
                System.out.println("\nPlayer " +            //Display which players turn using CONDITIONAL OPERATOR :)
                    (currentPlayer == 'X' ? "1" : "2") +    //(if-else operator)    X --> 1; o --> 2
                    "'s turn (" + currentPlayer + ")");
                
                boolean validMove = false;      //Falg/singal to see if player move valid
                while(!validMove) {     //Loop will continue until a valid move made
                    System.out.print("Enter column (1-7): ");
                    while(!scanner.hasNextInt()) {      //checking value entered is INT; if not it'll loop until it is
                        System.out.print("Please enter a number: ");
                        scanner.next();
                    }
                    int column = scanner.nextInt();     //reads col number player entered
                    validMove = board.dropPiece(column, currentPlayer);     //erturn true if player move is valid into column
                    if(!validMove) {
                        System.out.println("Invalid move, try again");
                    }
                }
                
                //check if currrent player win after every move
                if(board.checkWin(currentPlayer)) {
                    board.displayBoard();       //display board current state 
                    System.out.println("\nPlayer " + 
                        (currentPlayer == 'X' ? "1" : "2") + 
                        " wins!");
                    stats.addWin(currentPlayer);        //update game stats record winner
                    gameOver = true;    //gameOver flag --> true
                }
                //draw condition
                else if(board.isFull()) {
                    board.displayBoard();
                    System.out.println("\nIt's a draw!");
                    gameOver = true;
                }
                
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';     //switch to the next player (X-->O; O-->X)
            }
            
            stats.displayStats();   //display stats (total games played + wins for each player name)
            
            System.out.print("\nType YES to play again: ");
            keepPlaying = scanner.next().equalsIgnoreCase("yes");     //another game?
        }
        
        System.out.println("\nThanks for playing!");        //final msg after exit game
    }
    
    //main method
    public static void main(String[] args) {
        Connect4 game = new Connect4();
        game.play();
    }
}