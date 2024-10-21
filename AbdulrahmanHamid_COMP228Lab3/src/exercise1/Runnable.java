package exercise1;

import javax.swing.*;

public class Runnable {

    public static void main(String[] args) {
        String[] insuranceTypes = new String[] {"Health", "Life"};
        Insurance[] insuranceList = new Insurance[3];

        for (int i = 0; i < 3; i++) {
            //to get selection type
            String userSelection = JOptionPane.showInputDialog( null, "Please select your insurance type: ");
            //if selection is health we create new object and assign to insurance
            if(userSelection.equals(insuranceTypes[0])) {
                Insurance insurance = new Health(userSelection);
                insuranceList[i] = insurance;
            }
            //if selection is Life we create new object and assign to insurance
            else if (userSelection.equals(insuranceTypes[1])) {
                Insurance insurance = new Life(userSelection);
                insuranceList[i] = insurance;
            }
            //ask for the monthly cost
            double fee = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your monthly fee: "));
            //set the monthly cost
            insuranceList[i].setInsuranceCost(fee);
            //show the information
            insuranceList[i].displayInfo();
        }
    }
}

