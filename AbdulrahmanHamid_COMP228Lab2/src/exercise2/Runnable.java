package exercise2;

import javax.swing.JOptionPane;

public class Runnable {
    public static void main(String[] args) {
        //using JOptionPan to initialize
        int userNumber = Integer.parseInt(JOptionPane.showInputDialog("Pick from 3 to 27:"));
        //if true it will break that is why we set it to false
        boolean userWin = false;

        for (int i = 0; i < 5; i++) {
            //creating lotto object
            Lotto lotto = new Lotto();
            //calling the getSum method
            int sum = lotto.getSum();
            JOptionPane.showMessageDialog(null, "The Lotto numbers are " + lotto.getArray()[0] + ", " +
                    lotto.getArray()[1] + ", " + lotto.getArray()[2] + "\n The Sum of the lotto: " + sum);

            if (userNumber == sum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                userWin = true;
                break;
            }
        }
        if (!userWin) {
            JOptionPane.showMessageDialog(null, "Sorry, you lose. The computer wins.");
        }
    }
}

