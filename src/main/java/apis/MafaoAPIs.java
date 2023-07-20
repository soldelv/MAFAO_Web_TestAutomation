package apis;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.Objects;

import static Constants.Constants.*;
import static utils.CommonMethods.print;

public class MafaoAPIs {
    private static final String apiOTPCode =URL_STG+"meveo/rest/TestOTP";
    private static final String listProducts = URL_STG+"meveo/rest/odooProductsAPI";

    public static String login(String userName, String password) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String otpCode = "";
        try{
        HttpUriRequest httpget = RequestBuilder.post()
                .setUri(new URI("https://staging.jips.io/auth/realms/meveo/protocol/openid-connect/token"))
                .addParameter("client_id", "meveo-web")
                .addParameter("username", userName)
                .addParameter("password", password)
                .addParameter("grant_type", "password")
                .addParameter("client_secret", "afe07e5a-68cb-4fb0-8b75-5b6053b07dc3")
                .build();


            Gson gson = new Gson();
            CloseableHttpResponse response = httpclient.execute(httpget);
            String responseStr=otpCode = EntityUtils.toString(response.getEntity());
            JsonObject jsonObject = gson.fromJson(responseStr, JsonObject.class);

            // Print the access token
            print(String.valueOf(jsonObject.get("access_token")));
            return jsonObject.get("access_token").getAsString();
        }catch(Exception e){
            print(e.getMessage());
            return otpCode;
        }
    }

    public static String getOTPCode(String mobileNumber) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String otpCode = "";

        print("USING THIS MOBILE NUMBER: --> "+mobileNumber);

        HttpUriRequest httpget = RequestBuilder.get()
                .setUri(new URI(apiOTPCode))
                .addParameter("destinationNumber", mobileNumber)
                .build();

        try{
            CloseableHttpResponse response = httpclient.execute(httpget);
            otpCode = EntityUtils.toString(response.getEntity());
            print("OTP code sent: " + otpCode);
            return otpCode;
        }catch(Exception e){
            print(e.getMessage());
            return otpCode;
        }
    }

    public static String getProductPrice(String productName) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String productPrice = "";
        try{
        HttpUriRequest httpget = RequestBuilder.get()
                .setUri(new URI(listProducts))
                .addHeader("Authorization","Bearer "+login(FULL_MOBILE_NUMBER, SECRET_CODE))
                .addParameter("currentPage", "1")
                .build();


            CloseableHttpResponse response = httpclient.execute(httpget);
            String jsonString = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();

            // Parse the JSON string into a Java object.
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            // Get the list of products from the JSON object.
            JsonArray productsArray = jsonObject.getAsJsonArray("rows");
            Product[]  products = gson.fromJson(productsArray, Product[] .class);

            // Print the list of products.
            for (Product product : products) {
                if(Objects.equals(product.getDisplay_name(), productName)){
                    productPrice = String.valueOf(product.getList_price());
                    productPrice = productPrice.substring(0, productPrice.length() - 2);
                }
            }
            return productPrice;
        }catch(Exception e){
            print(e.getMessage());
            return productPrice;
        }
    }

}
