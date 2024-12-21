import java.util.TreeMap;

public class Dartboard {
    private TreeMap<Double, Integer> board;

    //Constructor to initialize the dartboard
    public Dartboard() {
        board = new TreeMap<>();

        // Add regions to the Dartboard
        board.put(3.0, 100); // Bullseye
        board.put(6.0, 80); //
        board.put(9.0, 60);
        board.put(12.0, 40);
        board.put(15.0, 20);
    }

    //Method to calculate score based on dart position
    public int score(double x, double y) {
        double distance = Math.sqrt(x * x + y * y);

        //Find the nearest scoring region that the dart falls into
        for(double radius : board.keySet()) {
            if(distance <= radius) {
                return board.get(radius);
            }
        }
        //Outside the board
        return 0;
    }

    //Print the dartboard
    public void printDartboard(){
        System.out.println("Dartboard");
        for(double radius : board.keySet()) {
            System.out.println(radius + " " + board.get(radius));
        }
    }
}
