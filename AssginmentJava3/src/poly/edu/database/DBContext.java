/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.database;

/**
 *
 * @author phamh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBContext {
    private static Connection con;
    public DBContext()
    {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DIONSQL;encrypt=false";
            String username = "sa";
            String password = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connect Success");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect Fail" + ex);
        }
    }
    
    public Connection getConnect(){
        return con;
    }
}