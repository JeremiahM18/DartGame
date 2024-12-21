/* Name: Jeremiah McDonald
# Date: 12/6/2024
# Class: CSC1120
# Pledge: I have neither given nor received unauthorized aid on this program.
# Description: This program simulates a dart game between two players. Each player
# throws darts at a dartboard, and their scores are determined based on where on the dartboard
# they hit.
# Input: The program prompts the user for the file path to a text file containing the dart throws
# for both players.
# Output: The program displays the total score for each player and displays the winner.
 */





import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a game of Darts.
        GameOfDarts game = new GameOfDarts();

        // Prompt the user for the file for player throws
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path for the dart throws: ");
        String filePath = sc.nextLine();

        // String filePath = C:\Users\cover\IdeaProjects\P5_Darts\src\coordinates.txt

        try{
            // Read player throws from the file
            double[][] p1Throws = readPlayerThrows(filePath, 1);
            double[][] p2Throws = readPlayerThrows(filePath, 2);

            //Play the game
            game.playRound(p1Throws, p2Throws);

            //Display the results
            game.displayResults();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (NumberFormatException e){
            System.out.println("Error with coordinates: " + e.getMessage());
        }
    }

    //Method to read player throws from the file
    private static double[][] readPlayerThrows(String filePath, int player) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Read all lines into a list
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        //Ensure the file has enough lines for both players
        if(lines.size() < player) {
            throw new FileNotFoundException("Not enough data in the file for player " + player);
        }

        //Get the specific player's line
        String line = lines.get(player -1).trim();
        System.out.println("Player " + player + " data: " + line); //Debugging: print raw line for player

        //Split the line by one or more spaces
        String[] coords = line.split("\\s+");

        //If the number of coordinates is odd, skip the last one
        if(coords.length % 2 != 0){
            System.out.println("Odd number of coordinates found in player " +
                    player + "'s data. Skipping the last coordinates.");
            coords = java.util.Arrays.copyOf(coords, coords.length - 1);
        }

        //Parse coordinates into a 2D array
        double[][] throwsArray = new double[coords.length / 2][2];
        for (int i = 0; i < coords.length; i += 2){
            // Check if we're accessing an index that's out of bounds
            if(i + 1 < coords.length){
                throwsArray[i / 2][0] = Double.parseDouble(coords[i]);
                throwsArray[i / 2][1] = Double.parseDouble(coords[i + 1]);
            }
        }

        return throwsArray;
    }
}