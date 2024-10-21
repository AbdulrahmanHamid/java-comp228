package exercise3;

public abstract class Mortgage implements MortgageConstants{
    // instance variable
    public int mortgageNumber;
    public String customerName;
    public double mortgageAmount;
    public double interestRate;
    public int mortgageTerm = MortgageConstants.shortTerm;
    public String mortgageType;

    // constructor
    public Mortgage(String customerName, int mortgageNumber,String mortgageType,double interestRate, double mortgageAmount, int term) {
        this.customerName = customerName;
        this.mortgageNumber = mortgageNumber;
        this.mortgageAmount = mortgageAmount;
        this.interestRate = interestRate;
        this.mortgageTerm = term;
        this.mortgageType = mortgageType;
    }

    // getter methods for all the instance variable  that i will use to display info
    public String getCustomerName(){
        return customerName;
    }
    public int getMortgageNumber(){
        return mortgageNumber;
    }
    public String getMortgageType(){
        return mortgageType;
    }
    public double getMortgageInterest(){
        return interestRate;
    }
    //if the amount entered more than the max amout
    public double getMortgageAmount(){
        if(mortgageAmount> MortgageConstants.maxAmount){
            System.out.println("mortgage amounts over $300,000 is not allowed it will be set to $300,000");
            mortgageAmount = MortgageConstants.maxAmount;
            return mortgageAmount;
        }else {
            return mortgageAmount;
        }

    }
    //getting the term from the interface if anything other than mentioned it will be short term
    public int getMortgageTerm(){
        if(mortgageTerm != MortgageConstants.shortTerm || mortgageTerm != MortgageConstants.longTerm || mortgageTerm != MortgageConstants.mediumTerm){
            mortgageTerm = MortgageConstants.shortTerm;
            return mortgageTerm;}
        else return mortgageTerm;
    }

    // to get the owed amount
    public double calculateTotalOwed() {
        return mortgageAmount + (mortgageAmount * (interestRate / 100) * mortgageTerm);
    }

    //an abstract method for display
    public abstract void getMortgageInfo();

}
