package exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String customerName, int mortgageNumber, String mortgageType, double mortgageAmount, double interestRate, int term) {
        super(customerName, mortgageNumber,mortgageType,interestRate + 2, mortgageAmount, term);

    }

    //the display Method
    @Override
    public void getMortgageInfo(){
        System.out.println("Customer name: " + getCustomerName() +
                "\nMortgage number: " + getMortgageNumber() +
                "\nType: " + getMortgageType() +
                "\nInterest: %" + getMortgageInterest() +
                "\nTerms: " + getMortgageTerm() + " years"+
                "\nMortgage amount: $" + getMortgageAmount() +
                "\nTotal Owed: $" + calculateTotalOwed() + "\n\n");
    }
}
