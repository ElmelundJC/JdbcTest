import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private String URL;
    private String DATABASE;
    private String USERNAME;
    private String PASSWORD;
    private String TIMEZONE;

    public DatabaseConnectionManager() {


        /*this.URL = propConfig.getProperty("url");
        this.DATABASE = propConfig.getProperty("database");
        this.TIMEZONE = propConfig.getProperty("timezone");
        this.USERNAME = propConfig.getProperty("username");
        this.PASSWORD = propConfig.getProperty("password");
*/
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File configFile = null;


        try {
            configFile = new File("config.properties");
            fis = new FileInputStream(configFile); // fos(FileOutputStream)/fis(FileInputStream)
            Properties propConfig = new Properties();

/*            propConfig.setProperty("url","jdbc:mysql://localhost:3306/");
            propConfig.setProperty("database","my_company");
            propConfig.setProperty("timezone","?serverTimezone=UTC");
            propConfig.setProperty("username","root");
            propConfig.setProperty("password","1212Hugo");

            propConfig.store(fos, "User Settings");
            fos.close();
            System.out.println("Config Saved");
*/

            propConfig.load(fis);

            // Get the properties

            this.URL = propConfig.getProperty("url");
            this.DATABASE = propConfig.getProperty("database");
            this.TIMEZONE = propConfig.getProperty("timezone");
            this.USERNAME = propConfig.getProperty("username");
            this.PASSWORD = propConfig.getProperty("password");

/*
            System.out.println(url);
            System.out.println(dataBase);
            System.out.println(timeZone);
            System.out.println(userName);
            System.out.println(passWord);
*/
            //System.out.println("Shit works");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getDatabaseConnection() throws SQLException {

        return DriverManager.getConnection(URL + DATABASE + TIMEZONE, USERNAME, PASSWORD);
    }
}
