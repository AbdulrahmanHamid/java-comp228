package exercise2;

public abstract class GameTester {
    public String name;
    public boolean isFullTime;
    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public abstract double setSalary();
}
