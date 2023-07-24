package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CommonMethods {

    public static void print(String string){
        System.out.println(string);
    }

    public static void holdOn(long seconds){
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            print(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Method to generate a string using the current date and time
    public static String generateDateTimeString() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String formattedDateTime = sdf.format(currentDate);

        return formattedDateTime;
    }

    public static String getDateThreeMonthsAfterToday() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateThreeMonthsAfter = currentDate.plusMonths(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = dateThreeMonthsAfter.format(formatter);
        return formattedDate;
    }

    public static int generateRandom3DigitNumber() {
        Random random = new Random();
        // Generate a random integer between 100 and 999 (inclusive)
        int randomNumber = random.nextInt(900) + 100;
        return randomNumber;
    }
}
