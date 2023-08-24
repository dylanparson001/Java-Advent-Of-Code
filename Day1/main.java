import java.io.*;
import java.util.ArrayList;
public class main {
    public static void main(String args[]) {
        final String fileName = "C:\\Users\\dylan\\Projects\\Advent-Of-Code\\Java\\Day1\\Input\\Input.txt";
        ArrayList<Integer> foodList = new ArrayList<>();
        ArrayList<Elf> elves = new ArrayList<>();
        int currentLargest = 0; // For comparing largest amount of calories
        int elfIndex = 0;
        ArrayList<Integer> listOfTopThree = new ArrayList<>();

        File file = new File(fileName);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // add food calories to a list if the line is not empty
                if (!line.isBlank()) {
                    foodList.add(Integer.parseInt(line));

                    // when you hit whitespace, make an elf with the current list to elves
                } else {
                    ArrayList<Integer> copyOfFoodList = new ArrayList<>(foodList);
                    Elf newElf = new Elf(copyOfFoodList);
                    elves.add(newElf);
                    // Empty list
                    foodList.clear();
                }
            }
            // get last elf
            ArrayList<Integer> copyOfFoodList = new ArrayList<>(foodList);
            Elf newElf = new Elf(copyOfFoodList);
            elves.add(newElf);
            // Empty list
            foodList.clear();

        } catch (Exception ex) {
            System.out.println(ex);
        }


        listOfTopThree.add(findCurrentLargestSum(elves, currentLargest));
        listOfTopThree.add(findCurrentLargestSum(elves, currentLargest));
        listOfTopThree.add(findCurrentLargestSum(elves, currentLargest));
        int topThreeSum = 0;

        for (int i = 0; i< 3; i++){
            topThreeSum+= listOfTopThree.get(i);
        }
        System.out.println("The top three total is: " + topThreeSum);
    }

    private static int findCurrentLargestSum(ArrayList<Elf> elves, int currentLargest){
        int elfIndex = 0;
        // Loop through list of elves
        for (int i = 0; i < elves.size(); i++){
            int sumPerElf = 0;
            Elf currentElf = elves.get(i);

            // Loop through the current elf's list of food items
            for ( int j = 0; j < currentElf.getFoodItems().size(); j++){
                sumPerElf += currentElf.getFoodItems().get(j);
            }
            // Add up sum of current elf, if it is larger than the current largest, the current elf is holding the most
            if (sumPerElf > currentLargest){
                currentLargest = sumPerElf;
                elfIndex = elves.indexOf(currentElf);
            }
        }
        elves.remove(elfIndex);
        return currentLargest;
    }
}
