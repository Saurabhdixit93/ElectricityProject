package electricity.billing.system;
import javax.swing.*;
import java.awt.Desktop;

import java.net.URI;


public class Paytm extends JFrame {
     String meter;
     Paytm(String meter)  {
         super("Paytm");
         this.meter =meter;


         Desktop desk = Desktop.getDesktop();


         try {
             desk.browse(new URI("https://paytm.com"));

         }catch (Exception e){
             e.printStackTrace();

         }
     }

    public static void main(String[] args)
            throws Exception
    {
       new Paytm("");
    }
}