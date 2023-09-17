
package Model;
import static View.ManageContainers.Instance;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class MManageContainers 
{ 
  
    PreparedStatement pst=null; 
    ResultSet Rs=null;
    Connection con=null;
   public void save(String r1,String m2,int c3,String d0,String s6,int p7) 
    {
   if(Instance.reg_no.getText().trim().isEmpty())
   {
       Instance.e.setText("Registration cannot be empty");
       Instance.e.setForeground(Color.red);
   }  
   else
   {   
   try
    {
        Statement st=MyDbConnection.getConnection().createStatement();
        int count=st.executeUpdate("Insert into managecontainers values('"+r1+"','"+m2+"','"+c3+"','"+d0+"','"+s6+"','"+p7+"')");
        
            
            if(count>0)
            {   JOptionPane.showMessageDialog(null,"Record submitted");
                Display();
                
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
    }
    public void Display()
   {
       try
        {
        String sql="Select * from manageContainers";
        Statement st=MyDbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
        DefaultTableModel model=(DefaultTableModel) Instance.tb2.getModel();
        
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
   public void bringData()
   {
    try
       {
       
       DefaultTableModel model=(DefaultTableModel) Instance.tb2.getModel();
       int MyIndex=Instance.tb2.getSelectedRow();
       Instance.reg_no.setText(model.getValueAt(MyIndex, 0).toString());
       Instance.model.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
       Instance.capacity.setText(model.getValueAt(MyIndex, 2).toString());
       Date date1=new SimpleDateFormat("yyy-MM-dd").parse((String)model.getValueAt(MyIndex,3));
       Instance.date.setDate(date1);     
       Instance.status.setSelectedItem(model.getValueAt(MyIndex, 4).toString());
       Instance.price.setText(model.getValueAt(MyIndex, 5).toString());
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());  
       }
    
   }
   public void edit(String register_no,String model,int capacity,String date,String status,int price)
   {
       try
        {
         
          int dialogResult=JOptionPane.showConfirmDialog(null,"Do you really want to Update?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
          System.out.println(dialogResult);
          if(dialogResult==JOptionPane.YES_OPTION)
          {
         Statement st=MyDbConnection.getConnection().createStatement();
         st.executeUpdate("update manageContainers set registration_no='"+register_no+"',model='"+model+"',capacity='"+capacity+"',date_of_purchase='"+date+"',status='"+status+"',price='"+price+"' where registration_no='"+register_no+"' ");
         JOptionPane.showMessageDialog(null,"Updated successfully"); 
         Display();
          }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"); 
        }
        Display();
   }
   public void delete(String i)
   {
       try
         {int dialogResult=JOptionPane.showConfirmDialog(null,"Do you really want to Delete?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
          System.out.println(dialogResult);
          if(dialogResult==JOptionPane.YES_OPTION)
          {
             Statement st=MyDbConnection.getConnection().createStatement();
             st.executeUpdate("delete from managecontainers where registration_no='"+i+"'");
             if(st.equals(st))
             {
             JOptionPane.showMessageDialog(null,"Deleted successfully");
             Instance.reg_no.setText("");
             Instance.model.setSelectedIndex(-1);
             Instance.capacity.setText("");
             Instance.date.setDate(null);
             Instance.status.setSelectedIndex(-1);
             Instance.price.setText("");
             
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
   public void reset()
  {
      Instance.reg_no.setText("");
      Instance.model.setSelectedIndex(-1);
      Instance.capacity.setText("");
      Instance.date.setDate(null);
      Instance.status.setSelectedIndex(-1);
      Instance.price.setText("");
      Instance.search.setText("");
  }
    public void search(String r_id) 
      {   try
    {     ResultSet rs1 = null;
          String s ="select * from managecontainers where registration_no='"+r_id+"'";
          Statement st=MyDbConnection.getConnection().createStatement();
          rs1=st.executeQuery(s);
          
     if(rs1.next()==true)
          {  
             Instance.reg_no.setText(rs1.getString("registration_no"));
             Instance.model.setSelectedItem(rs1.getString("model"));
             Instance.capacity.setText(rs1.getString("capacity"));
             Instance.date.setDate(rs1.getDate("date_of_purchase"));
             Instance.status.setSelectedItem(rs1.getString("status"));
             Instance.price.setText(rs1.getString("price"));
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
