
package Model;

import static View.DeployContainers.Instance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MDeployContainers 
{   PreparedStatement pst=null; 
    ResultSet Rs=null;
    Connection con=null;
    Statement st=null;
    public void DisplayContainers()
    { String containerStatus="Avaliable";
        try
        {
        String path="jdbc:mysql://localhost/container";
        con=DriverManager.getConnection(path,"root","");
        String sql=("Select * from manageContainers where status='"+containerStatus+"'");
        PreparedStatement psr=con.prepareStatement(sql);
        ResultSet rs=psr.executeQuery();
        DefaultTableModel model=(DefaultTableModel) Instance.tb1.getModel();
        
        model.setRowCount(0);
        while(rs.next())
        {
            model.addRow(new String []{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
           
        }
            }
        
      
    catch(Exception e)
    {
          JOptionPane.showMessageDialog(null,"Error");  
    }
    }
    public void updateContainers()
    {
        try
        {
        String path="jdbc:mysql://localhost/container";
        con=DriverManager.getConnection(path,"root","");
        String reg1=Instance.reg_no1.getText();
        String containerStatus1="Sent";
        String sql=("Update manageContainers set status='"+containerStatus1+"' where registration_no='"+reg1+"'");
        Statement add=con.createStatement();
        add.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Updated");  
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");  
        }
    }
    public void bringCustomer()
    {
        try
        {
        String path="jdbc:mysql://localhost/container";
        con=DriverManager.getConnection(path,"root","");
        st=con.createStatement();
        String sql="Select * from client";
        Rs=st.executeQuery(sql);
        while(Rs.next())
        {
            String customername=Rs.getString("Client_Name");
            Instance.name.addItem(customername);
        }
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());  
        }
    }
    public void bringData()
    {
        try
       {
       
       DefaultTableModel model=(DefaultTableModel) Instance.tb1.getModel();
       int MyIndex=Instance.tb1.getSelectedRow();
       Instance.reg_no1.setText(model.getValueAt(MyIndex, 0).toString());
       Instance.model.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
       Instance.price.setText(model.getValueAt(MyIndex, 5).toString());
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());  
       }
    }
    
     public void deploy(String id1,String reg2,String model3,String name4,String date5,String return6,int price7) 
    {
   try
    {
        Statement st=MyDbConnection.getConnection().createStatement();
        int count=st.executeUpdate("Insert into deployContainers values('"+id1+"','"+reg2+"','"+model3+"','"+name4+"','"+date5+"','"+return6+"','"+price7+"')");
        
            
            if(count>0)
            {   JOptionPane.showMessageDialog(null,"Record submitted");
                displayReturn();
                updateContainers();
              DisplayContainers(); 
                
            }
             
            else
            {
            JOptionPane.showMessageDialog(null,"record not submitted");
            }
       
    }
   catch(SQLException e)
    {
         JOptionPane.showMessageDialog(null,e.getMessage());  
    } 
}
     public void displayReturn()
     {
        try
        {
        String path="jdbc:mysql://localhost/container";
        con=DriverManager.getConnection(path,"root","");
        String sql="Select * from deployContainers";
        PreparedStatement psr=con.prepareStatement(sql);
        ResultSet rs=psr.executeQuery();
        DefaultTableModel model=(DefaultTableModel) Instance.tb2.getModel();
        
        model.setRowCount(0);
        while(rs.next())
        {
            model.addRow(new String []{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
           
        }
       }
      
    catch(Exception e)
    {
          JOptionPane.showMessageDialog(null,"Error");  
    }
     }
    
}

