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
        final String fileName = "C:\\Users\\dylan\\Projects\\Advent-Of-Code\\Java\\Day2\\Input\\Input.txt";
        File file = new File(fileName);

        // Get values into variable

        // Based on first input (A = 1, B = 2, C = 3)
        // Maybe use enums?

        // then make rock paper scissors and base points on who wins


        // Not sure best way to store the first and second value, could do a char array and just compare the first
        // And second index and base points.


        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}