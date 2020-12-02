import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {

//      FileOutputStream fos = null;
        FileInputStream fis = null;
        File configFile = null;


        try {
            configFile = new File("config.properties");
            fis = new FileInputStream(configFile); // fos(FileOutputStream)/fis(FileInputStream)
            Properties propConfig = new Properties();

        /*    propConfig.setProperty("url","jdbc:mysql://localhost:3306/");
            propConfig.setProperty("database","my_company");
            propConfig.setProperty("timezone","?serverTimezone=UTC");
            propConfig.setProperty("username","root");
            propConfig.setProperty("password","1212Hugo");

            propConfig.store(fos, "Settings");
            fos.close();
            System.out.println("Config Saved");
*/

            propConfig.load(fis);

            // Get the properties
            String url = propConfig.getProperty("url");
            String dataBase = propConfig.getProperty("database");
            String timeZone = propConfig.getProperty("timezone");
            String userName = propConfig.getProperty("username");
            String passWord = propConfig.getProperty("password");


            System.out.println(url);
            System.out.println(dataBase);
            System.out.println(timeZone);
            System.out.println(userName);
            System.out.println(passWord);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
