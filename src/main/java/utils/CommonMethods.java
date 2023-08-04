package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public static JsonObject parseToJsonObject(CloseableHttpResponse response){
        try{
        String jsonString = EntityUtils.toString(response.getEntity());
        Gson gson = new Gson();
            return gson.fromJson(jsonString, JsonObject.class);

        }catch(Exception e){
            print(e.getMessage());
            return null;
        }
    }

    public static String generateDateTimeString() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String formattedDateTime = sdf.format(currentDate);

        return formattedDateTime;
    }

    public static String todayDayAndMonth() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        String formattedDateTime = sdf.format(currentDate);

        return formattedDateTime;
    }

    public static String generateNewPincode() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
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

    public static String convertDateTime(String input) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM d 'at' HH:mm");
            String formattedDateTime = dateTime.format(outputFormatter);

            return formattedDateTime;
        } catch (DateTimeParseException e) {
            print("Error: Invalid date-time format.");
            return null;
        }
    }

    public static boolean parseStringToBoolean(String value){
        if(value=="f"){
            return false;
        }
        else{
            return true;
        }
    }


}
