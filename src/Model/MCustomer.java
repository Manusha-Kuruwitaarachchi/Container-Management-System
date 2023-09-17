
package Model;

import static View.Customer.Instance;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MCustomer
{ 
    
    ResultSet Rs=null;
    Connection con=null;
   
    
    public void Display()
    {
        try
        {
        
        String sql="Select * from client";
        Statement st=MyDbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
        DefaultTableModel model=(DefaultTableModel) Instance.t11.getModel();
        
        model.setRowCount(0);
        while(rs.next())
        {
            model.addRow(new String []{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
           
        }
        
    }
      
    catch(Exception e)
    {
          JOptionPane.showMessageDialog(null,"Error");  
    }
    }
    
    
    public void save(String id,String name,String address,int noo)
    {
   if(Instance.id.getText().trim().isEmpty())
   {
    Instance.iid.setText("Id cannot be empty");
    Instance.iid.setForeground(Color.red);
   }
   if(Instance.name.getText().trim().isEmpty())
   {
    Instance.nname.setText("Id cannot be empty");
    Instance.nname.setForeground(Color.red);
   }
   if(Instance.address.getText().trim().isEmpty())
    {
    Instance.aad.setText("Address cannot be empty");
    Instance.aad.setForeground(Color.red);
    }
   if(Instance.phone_no.getText().trim().isEmpty())
    {
    Instance.pphone.setText("Phone no cannot be empty");
    Instance.pphone.setForeground(Color.red);
    }
   else
   {
   try{
     String d = "insert into client values('"+id+"','"+name+"','"+address+"','"+noo+"')";
    
    Statement st=MyDbConnection.getConnection().createStatement();
   int i=st.executeUpdate(d);
   
       if(i>0)
       {
       
                  JOptionPane.showMessageDialog(null,"Registration successful"); 
                  Display();
       
       }
       else
       {
       
                   JOptionPane.showMessageDialog(null,"Registration failed");
       }
      }
       catch(Exception e)
      {
               JOptionPane.showMessageDialog(null,"Error");        
      }}
    
}
    public void deleteData(String cid)
    {

       try
         {int dialogResult=JOptionPane.showConfirmDialog(null,"Do you really want to Delete?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
          System.out.println(dialogResult);
          if(dialogResult==JOptionPane.YES_OPTION)
          {
             Statement st=MyDbConnection.getConnection().createStatement();
             st.executeUpdate("delete from client where Client_Id='"+cid+"'");
             if(st.equals(st))
             {
             JOptionPane.showMessageDialog(null,"Deleted successfully");
             Instance.id.setText("");
             Instance.name.setText("");
             Instance.address.setText("");
             Instance.phone_no.setText("");
             }
          }
          else if(dialogResult==JOptionPane.NO_OPTION)
          {
              
          }
             else
             {
             JOptionPane.showMessageDialog(null,"Deleted unsuccesssful");   
             }
             
         }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot delete data"); 
        }
       Display();
    
    }
    public void editData(String id,String name,String address,int no)
    {
    
       
        try
        {
          int dialogResult=JOptionPane.showConfirmDialog(null,"Do you really want to Update?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
          System.out.println(dialogResult);
          if(dialogResult==JOptionPane.YES_OPTION)
          {
         Statement st=MyDbConnection.getConnection().createStatement();
         st.executeUpdate("update client set Client_Id='"+id+"',Client_Name='"+name+"',Client_Address='"+address+"',TP='"+no+"' where Client_Id='"+id+"' " );
         
         JOptionPane.showMessageDialog(null,"Updated successfully"); 
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"); 
        }
        Display();
    
 }
   public void bringData()
  {
    DefaultTableModel model=(DefaultTableModel) Instance.t11.getModel();
    int MyIndex=Instance.t11.getSelectedRow();
    Instance.id.setText(model.getValueAt(MyIndex, 0).toString());
    Instance.name.setText(model.getValueAt(MyIndex, 1).toString());
    Instance.address.setText(model.getValueAt(MyIndex, 2).toString());
    Instance.phone_no.setText(model.getValueAt(MyIndex, 3).toString());
  }
   public void Reset()
   {
      Instance.id.setText("");
      Instance.name.setText("");
      Instance.address.setText("");
      Instance.phone_no.setText("");
      Instance.search.setText("");
          
   }
    public void search(String c_id) 
      {   try
    {     ResultSet rs1 = null;
          String s ="select * from client where Client_Id='"+c_id+"'";
          Statement st=MyDbConnection.getConnection().createStatement();
          rs1=st.executeQuery(s);
          
     if(rs1.next()==true)
          {  
             Instance.id.setText(rs1.getString("Client_Id"));
             Instance.name.setText(rs1.getString("Client_Name"));
             Instance.address.setText(rs1.getString("Client_Address"));
             Instance.phone_no.setText(rs1.getString("TP"));
          }
          else 
            { 
            JOptionPane.showMessageDialog(null,"No records found!");
     
            } 
      }
    catch(Exception e)
    {
     JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }
      
   
    
}
