package Utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
    //read data from json
    public static final String file_path ="src/test/resources/";
    public static String readJsonFile(String fileName , String key) throws FileNotFoundException {
        FileReader fileReader =new FileReader(file_path+fileName+".json");
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        return jsonElement.getAsJsonObject().get(key).getAsString();
    }

    //read data from property file
    public static String readPropertyFile(String fileName , String propertyKey) throws IOException {
        Properties  properties = new Properties();
        properties.load(new FileInputStream(file_path+fileName+".properties"));
        return properties.getProperty(propertyKey);
    }
}
