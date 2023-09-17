
package Control;

import Model.MCustomer;


public class CCustomer 
{

    
    public void letssave(String i1,String n2,String a3,int n4)
    {
        MCustomer x=new MCustomer();
        x.save(i1,n2,a3,n4);
    }
   public void Display1()
   {
       MCustomer e =new MCustomer();
       e.Display();
   }
    public void bringData1()
    {
        MCustomer q=new MCustomer();
        q.bringData();
    }
    public void deleteData1(String id)
    {
        MCustomer z=new MCustomer();
        z.deleteData(id);
    }
    public void editData1(String id11, String name22, String address33, int phone44)
    {
        MCustomer v=new MCustomer();
       v.editData(id11, name22, address33, phone44);
    }
    public void Reset1()
    {
        MCustomer q=new MCustomer();
        q.Reset();
    }
    public void search(String id)
    {   MCustomer q=new MCustomer();
        q.search(id);
    }
    }
