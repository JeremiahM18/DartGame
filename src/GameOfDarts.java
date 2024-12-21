public class GameOfDarts {
    private Dartboard dartboard;
    private int player1;
    private int player2;

    //Constructor
    public GameOfDarts() {
        dartboard = new Dartboard();
        player1 = 0;
        player2 = 0;
    }

    //Method to play a round
    public void playRound(double[][] p1Throws, double[][] p2Throws) {
        for(double[] throwCoordinates : p1Throws) {
            player1 += dartboard.score(throwCoordinates[0], throwCoordinates[1]);
        }

        for(double[] throwCoordinates : p2Throws) {
            player2 += dartboard.score(throwCoordinates[0], throwCoordinates[1]);
        }
    }

    //Method to display results
    public void displayResults(){
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        if(player1 > player2){
            System.out.println("Player 1 wins!");
        } else if(player2 > player1){
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
