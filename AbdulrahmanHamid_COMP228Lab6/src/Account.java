public class Account {
    public int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized int deposit(int amount) {
        // to show balance and amount when calling the method
        System.out.println("During deposit balance is " + balance + " and amount to deposit is " + amount);
        balance += amount;
        return balance;
    }
    public synchronized int withdraw(int amount) {
        // to show balance and amount when calling the method
        System.out.println("During withdraw balance is " + balance + " and amount to withdrew is " + amount);
        balance -= amount;
        return balance;
    }



}
