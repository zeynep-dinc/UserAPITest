package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

    static Properties prop = new Properties();

    public String readToProperties(String variable) {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
            System.out.println(prop.getProperty(variable));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            return prop.getProperty(variable);
        }
    }
}
