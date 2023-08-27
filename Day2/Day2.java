import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    The winner of the whole tournament is the player with the highest score. Your total score is the sum of
    your scores for each round. The score for a single round is the score for the shape you selected
    (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round
    (0 if you lost, 3 if the round was a draw, and 6 if you won).
 */
public class Day2 {
    public static void main(String[] args){
        // Opponent
        int firstScore = 0;
        // "Your" score
        int secondScore = 0;
        final String fileName = "C:\\Users\\dylan\\Projects\\Advent-Of-Code\\Java\\Day2\\Input\\Input.txt";
        File file = new File(fileName);
        ArrayList<String> listOfInputs = new ArrayList<>();

        // Get values into variable

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                listOfInputs.add(line);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        // Based on first input (A = 1, B = 2, C = 3)

        for (String currentChoices : listOfInputs) {
            char firstChoice = currentChoices.charAt(0);
            char secondChoice = currentChoices.charAt(2);

            // Assign points based on rock paper or scissors
            switch (firstChoice) {
                case 'A' -> firstScore += 1;
                case 'B' -> firstScore += 2;
                case 'C' -> firstScore += 3;
            }

            // Part 2:
            //X means you need to lose, Y means you need to end the round in a draw,
            // and Z means you need to win. Good luck!"
            switch (currentChoices) {
                // Opponent needs to win
                case "A X", "B X", "C X" -> {
                    // Opponent chose Rock, so we choose Scissors
                    if (currentChoices.charAt(0) == 'A')
                        secondScore += 3;
                    // Opponent chose Paper, so we choose Rock
                    if (currentChoices.charAt(0) == 'B')
                        secondScore += 1;
                    // Opponent chose Scissors, so we choose Paper
                    if (currentChoices.charAt(0) == 'C')
                        secondScore += 2;

                    firstScore += 6;
                }
                // You need to win
                case "A Z", "B Z", "C Z" -> {
                    // Opponent chose Rock, so we choose Paper
                    if (currentChoices.charAt(0) == 'A')
                        secondScore += 2;
                    // Opponent chose Paper, so we choose Scissors
                    if (currentChoices.charAt(0) == 'B')
                        secondScore += 3;
                    // Opponent chose Scissors, so we choose Rock
                    if (currentChoices.charAt(0) == 'C')
                        secondScore += 1;
                    secondScore += 6;
                }
                // Needs to be a draw
                case "A Y", "B Y", "C Y" -> {
                    // Opponent chose Rock, so we choose Rock
                    if (currentChoices.charAt(0) == 'A')
                        secondScore += 1;
                    // Opponent chose Paper, so we choose Paper
                    if (currentChoices.charAt(0) == 'B')
                        secondScore += 2;
                    // Opponent chose Scissors, so we choose Scissors
                    if (currentChoices.charAt(0) == 'C')
                        secondScore += 3;
                    firstScore += 3;
                    secondScore += 3;
                }
            }

            /* Answer for part 1:
            switch (secondChoice) {
                case 'X' -> secondScore += 1;
                case 'Y' -> secondScore += 2;
                case 'Z' -> secondScore += 3;
            }
            (0 if you lost, 3 if the round was a draw, and 6 if you won).
            switch (currentChoices) {
                // Draws
                case "A X", "B Y", "C Z" -> {
                    firstScore += 3;
                    secondScore += 3;
               }
                // Opponent wins
                case "A Z", "B X", "C Y" -> firstScore += 6;
                We win
                case "A Y", "B Z", "C X" -> secondScore += 6;
            } */




            System.out.println(firstScore);
            System.out.println(secondScore);

        }

        // then make rock paper scissors and base points on who wins


        // Not sure best way to store the first and second value, could do a char array and just compare the first
        // And second index and base points.


    }
}