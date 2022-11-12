package mx.uv;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/usuarioDB";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String pass = "1234";
    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            Class.forName(driverName);
            connection = Driver.getConnection(url, username, pass);
        }catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
    
}
