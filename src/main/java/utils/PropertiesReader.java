package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Constants.Constants.*;

public class PropertiesReader {

    public static Properties loadProperties(String environment) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(DIRECTORY_ENV_CONFIG+environment);
            properties.load(fis);
            fis.close();
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return properties;
        }
    }

    public static Properties getStagingProperties(){
        return loadProperties(ENV_CONFIG_STG);
    }

    public static Properties getQAProperties(){
        return loadProperties(ENV_CONFIG_QA);
    }

    public static Properties getProdProperties(){
        return loadProperties(ENV_CONFIG_PROD);
    }

    public static String getAndroidApp(){
        return getStagingProperties().getProperty("android_version");
    }

    public static String getIOSApp(){
        return getStagingProperties().getProperty("ios_version");
    }

    public static String getUrlStaging(){
        return getStagingProperties().getProperty("url");
    }

    public static String stgUserCountry(){
        return getStagingProperties().getProperty("country");
    }

    public static String stgUserMobile(){
        return getStagingProperties().getProperty("mobile_number");
    }
    public static String stgUserCountryCode(){
        return getStagingProperties().getProperty("country_code");
    }
    public static String stgUserSecretCode(){
        return getStagingProperties().getProperty("secret_code");
    }

    public static String qaPaypalEmail(){
        return getQAProperties().getProperty("paypal_email");
    }

    public static String qaPaypalPassword(){
        return getQAProperties().getProperty("paypal_password");
    }

}