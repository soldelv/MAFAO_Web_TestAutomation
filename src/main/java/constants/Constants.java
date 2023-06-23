package constants;

import utils.ConfigReader;

import java.io.FileInputStream;
import java.util.Properties;

public class Constants {
    public static final int EXPLICIT_WAIT = 10;

    public static final String YES = "yes";
    public static final String NO = "no";

    public static final String PROJECT_NAME = "Automation Test Suite Report - MAFAO - Web";

    /* SUPPORTED BROWSERS */
    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String BROWSER_SAFARI = "safari";
    public static final String BROWSER_EDGE = "edge";
    public static final String BROWSER_OPERA = "opera";

    public static final String ATTRIBUTE_VALUE = "value";

    /* ENVIRONMENT CONFIGURATION FILES */
    public static final String DIRECTORY_ENV_CONFIG = "src/test/resources/config/";
    public static final String ENV_CONFIG_QA = "qa_config.properties";
    public static final String ENV_CONFIG_INT = "int_config.properties";
    public static final String ENV_CONFIG_STG = "stg_config.properties";
    public static final String ENV_CONFIG_PROD = "prod_config.properties";

    public static String MAFAO_URL = ConfigReader.getWebpageUrl();

    /* CUCUMBER REPORTS */
    public static final String REPORTS_CUCUMBER_LOCATION = "./target/cucumber/";
    public static final String REPORTS_CUCUMBER_LOCAL = REPORTS_CUCUMBER_LOCATION + "cucumber.html";
    public static final String REPORTS_ZIPPED_FILE_NAME = "CucumberReports.zip";
}
