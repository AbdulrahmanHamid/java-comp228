package exercise2;

public class PartTimeGameTester extends GameTester{

    public int hoursWorked;
    public PartTimeGameTester(String name, int hoursWorked) {
        super(name,false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double setSalary() {
        int hourlyRate = 20;
        return (hoursWorked * hourlyRate);


    }
}
