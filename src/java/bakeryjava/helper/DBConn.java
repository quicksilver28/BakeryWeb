package bakeryjava.helper;
/**
 *
 * @author Sana
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    
    private static Connection conn = null;
    
    public static Connection getcon(){
        if(conn != null)
            return conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakerydb", "root", "hellohello");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
}