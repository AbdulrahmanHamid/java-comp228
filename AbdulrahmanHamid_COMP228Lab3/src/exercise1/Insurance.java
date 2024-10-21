package exercise1;

public abstract class Insurance {

    public String insuranceType;
    public double monthlyCost;

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() {
        return insuranceType;
    }
    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double Fee);
    public abstract void displayInfo();
}
