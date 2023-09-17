package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MyDbConnection {
   public static Connection con;
    public static Connection getConnection()
    {
    try
    {
   String path="jdbc:mysql://localhost/container";
   con=DriverManager.getConnection(path,"root","");
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    return con;
    }
    
    
    
}
