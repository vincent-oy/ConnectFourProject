package connect4;

//Tracking gmae stats
public class GameStats {
    private int player1Wins;    //variable to store number of games won by Player 1 (X)
    private int player2Wins;    //variable to store number of games won by Player 2 (O)
    private int gamesPlayed;    //variable to store number of games played in total
    
    //set initial values
    public GameStats() {
        player1Wins = 0;
        player2Wins = 0;
        gamesPlayed = 0;
    }
    
    //record win for X or O; adding win count by 1 for each winner
    public void addWin(char player) {
        if(player == 'X') player1Wins++;
        else player2Wins++;
        gamesPlayed++;      //total number of games player +1
    }
    
    public void displayStats() {
        System.out.println("\n=== Game Statistics ===");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Player 1 (X) Wins: " + player1Wins);
        System.out.println("Player 2 (O) Wins: " + player2Wins);
        System.out.println("===================");
    }
}