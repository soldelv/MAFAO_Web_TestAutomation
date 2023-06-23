package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWebpageUrl() {
        loadProperties();
        return properties.getProperty("url");
    }
}

