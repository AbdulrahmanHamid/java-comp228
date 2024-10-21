package exercise2;

import javax.swing.*;
import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameTester gameTester = null;

        //enter name
        System.out.println("Enter the name of the Game Tester");
        String name = scanner.nextLine();

        //choosing game tester type
        System.out.println("enter the type of game tester (full time / part time");
        String type = scanner.nextLine();

        if(type.equals("full time")){
            //Creating full time game tester
            gameTester = new FullTimeGameTester(name);
        }else if (type.equals("part time")){
            //ask to enter the hour
            System.out.println("Enter The Part time Tester Hours Worked:");
            int hours = scanner.nextInt();
            //Creating full time game tester
            gameTester = new PartTimeGameTester(name, hours);
        }
        //printing all the info
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + gameTester.setSalary());
        System.out.println("Type of game tester: " + type);


        scanner.close();


    }
}
