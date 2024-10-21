package exercise1;

import javax.swing.*;

public class Health extends Insurance{

    public Health(String insuranceType) {
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
