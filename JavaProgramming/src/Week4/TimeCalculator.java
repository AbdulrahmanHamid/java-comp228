package Week4;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeCalculator {
    //Method to get local time using LocalDateTime
    public void getCurrentLocalDateTime(){
        LocalDateTime LDT = LocalDateTime.now();
        System.out.println("Current Local Date Time: " + LDT);

    }

    //Method to get local time using ZoneDateTime

    public void getCurrentZonedDate(){
        ZonedDateTime ZDT = ZonedDateTime.now();
        System.out.println("Current Zoned Date Time: " + ZDT);
    }

    public static void main(String[] args) {
        TimeCalculator t = new TimeCalculator();
        t.getCurrentLocalDateTime();
        t.getCurrentZonedDate();
    }
}
