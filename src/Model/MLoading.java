
package Model;

import View.LoadingPage;
import View.Login;

public class MLoading 
{
    public void loadingPage()
    {   
        
     { LoadingPage l =new LoadingPage();
       l.setVisible(true);
       Login m= new Login();
       m.setVisible(false);
       try 
       {
        for(int x=0;x<=100;x++)
       {
        Thread.sleep(80);
        l.Instance.lbl2.setText(Integer.toString(x)+"%");
        l.Instance.pb.setValue(x);
        if(x==20)
        {
         l.Instance.lbl.setText("Turning on modules");
        }
        if(x==40)
        {
        l.Instance.lbl.setText("Loading on modules");
        }
        if(x==60)
        {
        l.Instance.lbl.setText("Connecting to database");
        }
        if(x==80)
        {
        l.Instance.lbl.setText("Connection Successful");
        }
        if(x==90)
        {
        l.Instance.lbl.setText("Launching application");
        }
        if(x==100)
        {
        l.setVisible(false);
        m.setVisible(true);
        }
        }
        } 
        catch (Exception e) 
        {
        }
        }
    }}

