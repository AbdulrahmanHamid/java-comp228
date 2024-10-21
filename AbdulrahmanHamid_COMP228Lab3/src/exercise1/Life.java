package exercise1;

import javax.swing.*;

public class Life extends Insurance{

    public Life(String insuranceType) {
        super(insuranceType);
    }
    @Override
    public void setInsuranceCost(double fee) {
        monthlyCost = fee;
    }

    @Override
    public void displayInfo() {
        JOptionPane.showMessageDialog(null,
                "Insurance type is: " + getInsuranceType() + "\n" +
                        "The monthly cost is: $" + getMonthlyCost());
    }
}
