package exercise2;

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name,true);
    }

    @Override
    public double setSalary() {

        return  3000;

    }
}
