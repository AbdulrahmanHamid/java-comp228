package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //placing the tips in an array
        String[] mortgageType = new String[] {"Business mortgage", "Personal mortgage"};

        //Mortgage array, with size of 3
        Mortgage[] mortgagesList = new Mortgage[3];

        //to get the current rate
        System.out.println("Enter the current interest rate:");
        double interestRate = scanner.nextDouble();
        scanner.nextLine();
        for (int i = 0; i < mortgagesList.length; i++) {
            Mortgage mortgage = null;
            //asking for the type and make the user enter the type
            System.out.println("Enter the mortgage type:");
            String type = scanner.nextLine();
            //if the type Business mortgage ask for the other info
            if(type.equals(mortgageType[0])) {
                System.out.println("Enter the customer name:");
                String customerName = scanner.nextLine();
                System.out.println("Enter the mortgage number:");
                int mortgageNumber = scanner.nextInt();
                System.out.println("Enter mortgage amount:");
                double mortgageAmount = scanner.nextDouble();
                System.out.println("Enter mortgage term 1/3/5");
                int Term = scanner.nextInt();
                scanner.nextLine();
                mortgage = new BusinessMortgage(customerName,mortgageNumber,type,mortgageAmount,interestRate,Term);
             }
            //if the type is Personal ask the user to put all the information
            else if(type.equals(mortgageType[1])) {
                System.out.println("Enter the customer name:");
                String customerName = scanner.nextLine();
                System.out.println("Enter the mortgage number:");
                int mortgageNumber = scanner.nextInt();
                System.out.println("Enter mortgage amount:");
                double mortgageAmount = scanner.nextDouble();
                System.out.println("Enter  mortgage term from 1,3,or 5 any other term will be set to 1");
                int Term = scanner.nextInt();
                scanner.nextLine();
                mortgage = new PersonalMortgage(customerName,mortgageNumber,type,mortgageAmount,interestRate,Term);
            }
            //at the end of each loop add to the mortgage
            mortgagesList[i] = mortgage;
        }
        //closing the scanner
        scanner.close();

        // show all the content
        for(Mortgage display : mortgagesList) {
            display.getMortgageInfo();
        }

    }




}
