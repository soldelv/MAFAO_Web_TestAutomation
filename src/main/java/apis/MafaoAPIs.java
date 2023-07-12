package apis;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import static Constants.Constants.URL_STG;
import static utils.CommonMethods.print;

public class MafaoAPIs {
    private static String apiOTPCode =URL_STG+"meveo/rest/TestOTP";

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

}
