
package Model;

import View.DashBoard;
import View.Login;
import static View.Login.Instance;
import co.yogesh.Captcha;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MLogin 
{  
   Connection con=null;
   ResultSet rs=null;
   int i=0;
   
    public int login(String username,String password)
    { 
    
     
    if(Instance.u1.getText().isEmpty())
    {
      Instance.q1.setText("Username cannot be blank");
      Instance.q1.setForeground(Color.red);
      
    } 
    
    if(Instance.p1.getText().isEmpty())
    {
      Instance.p_error.setText("Password cannot be blank");
      Instance.p_error.setForeground(Color.red);
    }
    if(Instance.v1.getText().isEmpty())
      {
         Instance.e1.setText("Captcha cannot be blank");
         Instance.e1.setForeground(Color.red);
      }
    else{
    
        try
    { 
        Statement st=MyDbConnection.getConnection().createStatement();
        String sql="select * from login where username='"+username+"' and password='"+password+"'";
        rs=st.executeQuery(sql);
        if(rs.next())
            {
       
        DashBoard b=new DashBoard();
        b.toBack();
        b.setVisible(true);
        i=1;
                
            }
        
            else
            {
                JOptionPane.showMessageDialog(null,"Username or password is incorrect");
      
                
            }
        
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }
    return i;
    }
    
    Captcha cap=new Captcha();
    public void showCaptcha()
    {
      cap.setImageCaptcha(Instance.c1);
    }
   
    public void vc()
    {
    if(Instance.v1.getText().isEmpty())
      {
         Instance.e1.setText("Captcha cannot be blank");
         Instance.e1.setForeground(Color.red);
      }
        
    else if(cap.Validate(Instance.c1,Instance.v1.getText()))
      {
         Instance.e1.setText("Captcha is correct");
         Instance.e1.setForeground(Color.black);
    
      }
    else 
    {
        Instance.e1.setText("Captcha is incorrect");
       Instance.e1.setForeground(Color.red);
    }  
    }
    }
    

