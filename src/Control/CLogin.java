
package Control;

import Model.*;


public class CLogin 
{   public int login(String username,String password)
    {
        MLogin m=new MLogin();
        int v=m.login(username,password);
        return v;
    }
    public void showCaptcha()
    {
    MLogin m=new MLogin();
    m.showCaptcha();
    }
    public void vc1()
    {
    MLogin q=new MLogin();
    q.vc();
    }
  
}
