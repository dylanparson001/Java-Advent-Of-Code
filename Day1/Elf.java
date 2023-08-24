import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Elf {
    private ArrayList<Integer> foodItems;

    public Elf(ArrayList<Integer> foodItems) {
        this.foodItems = foodItems;
    }

    public ArrayList<Integer> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<Integer> foodItems) {
        this.foodItems = foodItems;
    }
}
