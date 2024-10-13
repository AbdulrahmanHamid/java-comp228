//package Week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LearningExceptions {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the First Value: ");
            double numOne = scanner.nextDouble();
            System.out.println("Enter the Second Value: ");
            double numTwo = scanner.nextDouble();

            double sum = numOne + numTwo;
            System.out.println("The sum of the two numbers is: " + sum);
            scanner.close();
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid Input! Only intger or or decimal numbers are allowed");
        } catch (InputMismatchException oli){
            System.out.println("Input Mismatch Exception: " + oli.getMessage());
        }
        catch (IllegalArgumentException ola) {
            System.out.println("Illegal Argument" + ola.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error occured: " + e.getMessage());
        }

    }
}
