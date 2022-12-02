
package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;



public class CustomerDetails extends JFrame implements ActionListener{
    JButton print,Back;
    JTable table;
    
    
      CustomerDetails(){
          
        super("Customer Details");
        super.setFont(new Font("Serif",Font.BOLD,15));
        setVisible(true);
        setSize(1250,630);
        setLocation(80,80);
       // getContentPane().setBackground(Color.WHITE);
        
        
        
        
       
//           Table

        table = new JTable();
        try {
            Connect c = new Connect();
            ResultSet rs=  c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        
//        For Print Button

        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South"); 

        
        
        
          
          
          
          
          
          
      }
    
  public void actionPerformed(ActionEvent e) {
      if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception ex){
                ex.printStackTrace();
         }
     }
  }
  public static void main(String [] args){
        new CustomerDetails();
   }
   
}
