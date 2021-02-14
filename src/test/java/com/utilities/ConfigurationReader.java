package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // Here I am creating an object of Class Properties that comes from Java. Properties Class is
    // the child of HashTable Class. The purpose that this Class serves is to maintain the List of
    // Strings that are represented in key and value format. Such as " browser=chrome "
    private static Properties properties = new Properties();

    static  {
        try {

        /*
        FileInputStream is a byte streams that reads data in binary format, exactly 8-bit bytes.
        They are descended from the abstract classes InputStream and OutputStream I/O Class which are
        the super types of all byte streams. Because of I/O Class we are able to read and write files
        such as text, pdf or image, Reason being they have the ability to read the binary format.
         */
            FileInputStream file = new FileInputStream("configuration.properties");

            // Here I am loading the configuration.properties file into the properties object
            properties.load(file);

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Here I am creating a method so that I can read it through the configuration
    // properties file.
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
