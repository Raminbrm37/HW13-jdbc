package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbConnection {
    private static Properties properties;

    public static Connection getConnection() throws SQLException {
        properties=new Properties();

        try {
            properties.load(new FileReader("H:\\javaproject\\maktab_sharif_HW" +
                    "\\src\\Maktab_Sharif_HW13\\Resources\\setting\\setting.txt"));
        }catch (IOException e){
            e.printStackTrace();
        }

        return DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password"));
    }

}
