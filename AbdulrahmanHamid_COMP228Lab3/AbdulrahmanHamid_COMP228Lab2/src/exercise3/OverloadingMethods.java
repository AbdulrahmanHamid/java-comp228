package exercise3;

public class OverloadingMethods {
    // string method
    public static String addNum(String num1, String num2) {
        int x = Integer.parseInt(num1);
        int y = Integer.parseInt(num2);
        int sum = x + y;
        return Integer.toString(sum);
    }
    //an int method
    public static int addNum(int num1, int num2) {
        return num1 + num2;
    }
    // double method
    public static Double addNum(Double num1, Double num2) {
        return num1 + num2;
    }


    public static void main(String[] args) {
       //initializing verbals
        String num1 = "10";
        String num2 = "30";

        int num3 = 30;
        int num4 = 20;

        double num5 = 10.646278482644274;
        double num6 = 30.848292048282945;

        System.out.printf("The method addNum with parameters String is adding %s to %s:%n ", num1, num2);
        System.out.printf("The Sum is: %s%n%n", addNum(num1,num2));
        System.out.printf("The method addNum with parameters int is adding %d to %d:%n ", num3, num4);
        System.out.printf("The Sum is: %d%n%n", addNum(num3,num4));
        System.out.printf("The method addNum with parameters Double is adding %.4f to %.4f:%n ", num5, num6);
        System.out.printf("The Sum is: %.4f", addNum(num5, num6));
    }
}
