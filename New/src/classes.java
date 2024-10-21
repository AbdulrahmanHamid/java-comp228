public class classes {
}

public class Address {
    protected int houseNum;
    protected String street, city, province, zipCode;

    public int getHouseNum() {
        return houseNum;
    }
    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return houseNum + ", " + street + ", " + city + ", " + province
                + ", " + zipCode ;
    }
    public Address(int houseNum, String street, String city, String province, String zipCode) {
        super();
        this.houseNum = houseNum;
        this.street = street;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
    }


}

public class BusinessMortgage extends Mortgage{
    public double businessInsurance;

    public double getBusinessInsurance() {
        return businessInsurance;
    }

    public void setBusinessInsurance(double businessInsurance) {
        if(businessInsurance > 0 ) {
            this.businessInsurance = businessInsurance;
        }
    }

    //constructor
    public BusinessMortgage(int mortageNum, String customerName, Date customerDOB, Address customerAddress,
                            double mortgageAmount, double rateOfInt, double businessInsurance) {
        super(mortageNum, customerName, customerDOB, customerAddress, mortgageAmount, rateOfInt);
        this.businessInsurance = businessInsurance;
    }

    //method
    @Override
    public double CalculateMonthlyMortgageInstallment() {
        return mortgageAmount * rateOfInt /12 + businessInsurance;
    }

    //toString
    @Override
    public String toString() {
        return "\nBusiness Mortgage \n-----\nMortage Number: " + mortageNum
                + "\nCustomer Name: " + customerName + "\nCustomer D.O.B: " + customerDOB + "\nCustomer Address: "
                + customerAddress + "\nMortgage Amount: " + mortgageAmount + "\nRate Of Int: " + rateOfInt
                + "\nBusiness Insurance:" + businessInsurance + "\nMonthly Mortgage Installment: " + this.CalculateMonthlyMortgageInstallment();
    }


}
public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructor: confirm proper value for month and day given the year
    public Date(int month, int day, int year) {
        // check if month in range
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "month (" + month + ") must be 1-12");
        }

        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }

        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        //System.out.printf("Date object constructor for date %s%n", this);
    }

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
public class HouseMortgage extends Mortgage{
    public double propertyTax;
    public double infrastructureTax;

    //getter and setter
    public double getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(double propertyTax) {
        if(propertyTax >0) {
            this.propertyTax = propertyTax;
        }
    }

    public double getInfrastructureTax() {
        return infrastructureTax;
    }

    public void setInfrastructureTax(double infrastructureTax) {
        if(infrastructureTax >0) {
            this.infrastructureTax = infrastructureTax;
        }
    }

    //Constructor
    public HouseMortgage(int mortageNum, String customerName, Date customerDOB, Address customerAddress,
                         double mortgageAmount, double rateOfInt, double propertyTax, double infrastructureTax) {
        super(mortageNum, customerName, customerDOB, customerAddress, mortgageAmount, rateOfInt);
        this.propertyTax = propertyTax;
        this.infrastructureTax = infrastructureTax;
    }

    //method
    @Override
    public double CalculateMonthlyMortgageInstallment() {
        return mortgageAmount * rateOfInt / 12 + propertyTax / 12 + infrastructureTax;
    }

    //toString()
    @Override
    public String toString() {
        return "\nHouse Mortgage \n-----\nMortage Number: " + mortageNum + " \nCustomer Name: " + customerName + " \nCustomer D.O.B: "
                + customerDOB + " \nCustomer Address: " + customerAddress + " \nMortgage Amount: " + mortgageAmount
                + " \nRate Of Interest: " + rateOfInt + "\nProperty Tax: " + propertyTax + "\nInfrastructure Tax: " + infrastructureTax
                + "\nMonthly Mortgage Installment:" + this.CalculateMonthlyMortgageInstallment();
    }


}

public abstract class Mortgage {
    //definition
    public int mortageNum;
    public String customerName;
    public Date customerDOB;
    public Address customerAddress;
    public double mortgageAmount;
    public double rateOfInt;

    //getter and setter
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Date getCustomerDOB() {
        return customerDOB;
    }
    public void setCustomerDOB(Date customerDOB) {
        this.customerDOB = customerDOB;
    }
    public Address getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }
    public double getMortgageAmount() {
        return mortgageAmount;
    }
    public void setMortgageAmount(double mortgageAmount) {
        if(mortgageAmount > 0) {
            this.mortgageAmount = mortgageAmount;
        }
    }
    public double getRateOfInt() {
        return rateOfInt;
    }
    public void setRateOfInt(double rateOfInt) {
        if(rateOfInt > 0 && rateOfInt <= 0.05) {
            this.rateOfInt = rateOfInt;
        }
    }
    public final int getMortageNum() {
        return mortageNum;
    }
    //overloaded constructors
    //all instances
    public Mortgage(int mortageNum, String customerName, Date customerDOB, Address customerAddress, double mortgageAmount,
                    double rateOfInt) {
        super();
        this.mortageNum = mortageNum;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
        this.customerAddress = customerAddress;
        this.mortgageAmount = mortgageAmount;
        this.rateOfInt = rateOfInt;
    }
    //some
    public Mortgage(int mortageNum, String customerName, Date customerDOB, Address customerAddress) {
        super();
        this.mortageNum = mortageNum;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
        this.customerAddress = customerAddress;
    }

    //abstract method
    public abstract double CalculateMonthlyMortgageInstallment() ;

    @Override
    public String toString() {
        return "Mortgage\n-----\nMortage Number: " + mortageNum + "\nCustomer Name: " + customerName + "\nCustomer D.O.B: " + customerDOB
                + "\nCustomer Address:" + customerAddress + "\nMortgage Amount: " + mortgageAmount + "\nRate Of Int:"
                + rateOfInt;
    }


}
public class MortgageTest {

    public static void main(String[] args) {
        Mortgage houseInstallment = new HouseMortgage(1002,"Jackie Chan",new Date(12,01,1986),new Address(675," Mil Ave","HuangRen","HongKong","W2E 4D2"), 89000, 0.3, 0.9, 0.15);
        Mortgage businessInstallment = new BusinessMortgage(2003,"Mefusa Lave",new Date(12,01,1986),new Address(1239,"Bloors Street","Scarborough","Toronto","M2E 8T7"), 16000, 0.5, 0.1);
        System.out.println(houseInstallment);
        System.out.println(businessInstallment);
    }

}