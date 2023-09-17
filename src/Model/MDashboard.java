
package Model;

import View.*;


public class MDashboard 
{
    public void customerclick()
    {
        Customer q=new Customer();
        q.setVisible(true);
        
    }
     public void containerclick()
    {
        ManageContainers w=new  ManageContainers();
        w.setVisible(true);
        
    }
    public void deployContainerClick()
    {
        DeployContainers z=new  DeployContainers();
        z.setVisible(true);
        
    }
     public void returnclick()
    {
        ReturnContainers q=new ReturnContainers();
        q.setVisible(true);
        
    }
     
}
