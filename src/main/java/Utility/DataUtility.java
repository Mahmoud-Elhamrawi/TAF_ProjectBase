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
    public static String readJsonFile(String fileName , String key)  {

         String file_path ="src/test/resources/";

        try {
            FileReader fileReader = new FileReader(file_path+fileName+".json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            return  jsonElement.getAsJsonObject().get(key).getAsString();
        } catch (Exception e) {
          e.printStackTrace();
        }
         return "";
    }

    //read data from property file
    public static String readPropertyFile(String fileName , String propertyKey)  {
        String file_path ="src/test/resources/";
        Properties  properties = new Properties();
        try {
            properties.load(new FileInputStream(file_path+fileName+".properties"));
            return properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
