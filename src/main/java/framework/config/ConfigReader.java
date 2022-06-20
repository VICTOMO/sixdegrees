package framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final String GLOBAL_PROPERTIES_PATH = "src//main//java//framework/"
            + "config//global.properties";

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(GLOBAL_PROPERTIES_PATH);
        properties.load(fis);

        Settings. AmazonLiveUrl =  properties.getProperty("AmazonLiveUrl");
    }
}
