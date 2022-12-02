
package electricity.billing.system;
import java.sql.*;
public class Connect {
    Connection c;
    Statement s;
    Connect(){
         try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Prarabh@000");
            s =c.createStatement();
         } catch(Exception e){
              e.printStackTrace();
         }
    }
    
}
