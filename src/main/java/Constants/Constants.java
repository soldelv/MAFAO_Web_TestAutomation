package Constants;

import utils.PropertiesReader;

public class Constants {

    public static final String DIRECTORY_ENV_APP = "/src/test/resources/apps/";
    public static String ANDROID_APP_VERSION = PropertiesReader.getAndroidApp();
    public static String ANDROID_APP_PATH = System.getProperty("user.dir")+DIRECTORY_ENV_APP+ ANDROID_APP_VERSION;

    public static String IOS_APP_VERSION = PropertiesReader.getIOSApp();
    public static String IOS_APP_PATH = System.getProperty("user.dir")+DIRECTORY_ENV_APP+ IOS_APP_VERSION;

    public static String URL_STG = PropertiesReader.getUrlStaging();
    public static final int EXPLICIT_WAIT = 10;

    public static final String PROJECT_NAME = "Automation Test Suite Report - MAFAO - Android";

    /* PLATFORMS */
    public static final String MOBILE_ANDROID = "Android";

    /* ENVIRONMENT CONFIGURATION FILES */
    public static final String DIRECTORY_ENV_CONFIG = "src/test/resources/config/";
    public static final String ENV_CONFIG_QA = "qa_config.properties";
    public static final String ENV_CONFIG_STG = "stg_config.properties";
    public static final String ENV_CONFIG_PROD = "prod_config.properties";

    /* STAGING - USER CREDENTIALS */
    public static final String COUNTRY = PropertiesReader.stgUserCountry();
    public static final String MOBILE_NUMBER = PropertiesReader.stgUserMobile();
    public static final String COUNTRY_CODE = PropertiesReader.stgUserCountryCode();
    public static final String SECRET_CODE = PropertiesReader.stgUserSecretCode();

    /* PAYPAL - CREDENTIALS */
    public static final String PAYPAL_EMAIL = PropertiesReader.qaPaypalEmail();
    public static final String PAYPAL_PASSWORD = PropertiesReader.qaPaypalPassword();

}
