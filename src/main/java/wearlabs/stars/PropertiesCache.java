package wearlabs.stars;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {
    private final static PropertiesCache INSTANCE = new PropertiesCache();
    private final Properties configProp = new Properties();

    private PropertiesCache() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesCache getInstance() {
        return INSTANCE;
    }

    public String getStringProperty(String key) {
        return configProp.getProperty(key);
    }

    /*public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }*/

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(configProp.getProperty(key));
    }
}