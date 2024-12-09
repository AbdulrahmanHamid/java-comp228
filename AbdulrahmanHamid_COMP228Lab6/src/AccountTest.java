import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        arrayList.add(3000);
        arrayList.add(5000);
        arrayList.add(6000);
        arrayList.add(10000);

        for(int i = 0; i < arrayList.size(); i++){
            Transaction transaction = new Transaction(arrayList.get(i));
            executor.execute(transaction);
        }

        executor.shutdown();
    }
}