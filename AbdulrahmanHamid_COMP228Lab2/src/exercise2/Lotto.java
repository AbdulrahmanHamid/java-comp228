package exercise2;

import java.util.Random;

public class Lotto {
    //declaring array
    public int[]  numbers;

    // Making a constructor for the array with 3 numbers
    public Lotto() {
        numbers = new int[3];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(9);
        }
    }

    //method for the 3 numbers array
    public int[] getArray() {
        return numbers;
    }
    //Method to sum the array numbers
    public int getSum() {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}
