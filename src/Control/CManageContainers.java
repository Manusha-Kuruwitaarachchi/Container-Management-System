
package Control;

import Model.MManageContainers;

public class CManageContainers {
    public void save(String rc,String m,int c,String d,String s,int p)
    {MManageContainers w=new MManageContainers();
     w.save(rc, m, c, d, s, p);
   
    }
    public void display1()
    {MManageContainers g=new MManageContainers();
     g.Display();
    }
    public void bringData1()
    {MManageContainers j=new MManageContainers();
     j.bringData();
    }
    public void edit1(String r,String m,int c,String d,String s,int p)
    {MManageContainers x=new MManageContainers();
     x.edit(r, m, c, d, s, p);
    }
    public void delete1(String id1)
    {MManageContainers l=new MManageContainers();
     l.delete(id1);
    }
    public void reset1()
    {MManageContainers z=new MManageContainers();
     z.reset();
    }
    public void search(String id)
    {MManageContainers p=new MManageContainers();
     p.search(id);
    } 
}

  
    

  
   

    

    
    


   
