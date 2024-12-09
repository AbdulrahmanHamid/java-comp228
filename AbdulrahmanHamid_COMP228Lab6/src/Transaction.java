public class Transaction extends Account implements Runnable{

    public int amount;
    public Transaction(int amount) {
        super(0);
        this.amount = amount;
    }
    @Override
    public void run() {
        try{
            // showing the balance in execution time
            System.out.println("After deposit balance is " + deposit(amount));
            System.out.println("After withdraw balance is " + withdraw(amount));
            System.out.println("Transaction completed");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
