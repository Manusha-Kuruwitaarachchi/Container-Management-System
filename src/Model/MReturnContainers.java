
package Model;

import static View.ReturnContainers.Instance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MReturnContainers 
{  PreparedStatement pst=null; 
    ResultSet Rs=null;
    Connection con=null;
    Statement st=null;
    public void returnData(String id1,String reg2,String name3,String date4,int delay1,String final1)
    {
        try
    {
        Statement st=MyDbConnection.getConnection().createStatement();
        int count=st.executeUpdate("Insert into returnContainers values('"+id1+"','"+reg2+"','"+name3+"','"+date4+"','"+delay1+"','"+final1+"')");
        
            
            if(count>0)
            {   JOptionPane.showMessageDialog(null,"Record submitted");
                diplayReturn();
                updateContainers();
                remove();
                displayDeploy();
            }
             
            else
            {
            JOptionPane.showMessageDialog(null,"record not submitted");
            }
       
    }
   catch(Exception e)
    {
         JOptionPane.showMessageDialog(null,"Error");  
    } 
    }
    public void displayDeploy()
    {
        try
        {
        String sql="Select * from deployContainers";
        Statement st=MyDbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
        DefaultTableModel model=(DefaultTableModel) Instance.tb0.getModel();
        
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
    public void bringData()
    {
        try
       {
       
       DefaultTableModel model=(DefaultTableModel) Instance.tb0.getModel();
       int MyIndex=Instance.tb0.getSelectedRow();
       Instance.id.setText(model.getValueAt(MyIndex, 0).toString());
       Instance.reg22.setText(model.getValueAt(MyIndex, 1).toString());
       Instance.name.setText(model.getValueAt(MyIndex, 3).toString());
       
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());  
       }
    }
   public void diplayReturn()
   {
       try
        {
        String sql="Select * from returnContainers";
       Statement st=MyDbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
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
        
        String reg1=Instance.reg22.getText();
        String containerStatus1="Avaliable";
        Statement st=MyDbConnection.getConnection().createStatement();
        st.executeUpdate("Update manageContainers set status='"+containerStatus1+"' where registration_no='"+reg1+"'");

        JOptionPane.showMessageDialog(null,"Updated");    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");  
        }
    }
   public void remove()
   { try
        {
        String path="jdbc:mysql://localhost/container";
        con=DriverManager.getConnection(path,"root",""); 
        String sql="Delete from deploycontainers where deploy_id=?";
        pst=con.prepareStatement(sql);
        pst.setString(1,Instance.id.getText());
        pst.execute();
        //JOptionPane.showMessageDialog(null,"Deleted successfully");
       diplayReturn();
        
   }
   catch(Exception e)
   {
       JOptionPane.showMessageDialog(null,"Error");  
   }
   
   }
   
}

    

