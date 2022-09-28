import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

    static Properties prop = new Properties();

    protected static String readToProperties(String variable) {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
            System.out.println(prop.getProperty("driver." + variable));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            return prop.getProperty("driver." + variable);
        }
    }
}
