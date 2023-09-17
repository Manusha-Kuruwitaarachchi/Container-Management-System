
package Control;

import Model.MDeployContainers;


public class CDeployContainers
{
     public void DisplayContainers1()
     {
         MDeployContainers v=new MDeployContainers();
         v.DisplayContainers();
     }
     public void bringData1()
     {
         MDeployContainers h=new MDeployContainers();
         h.bringData();
     }
     public void bringCustomer2()
     {   MDeployContainers m=new MDeployContainers();
         m.bringCustomer();
     }
     public void deploy1(String id1,String reg2,String model3,String name4,String date5,String return6,int price7)
     {  MDeployContainers p=new MDeployContainers();
        p.deploy(id1, reg2, model3, name4, date5, return6, price7);
     }
     public void displayReturn1()
     {   MDeployContainers y=new MDeployContainers();
         y.displayReturn();
     }
    
}
