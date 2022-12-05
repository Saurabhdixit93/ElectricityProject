
package electricity.billing.system;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;

public class DepositDetails extends JFrame implements ActionListener {
    Choice meterNumber,choiceMonth;
    JTable table;
    JButton search,print,Back;

    DepositDetails(){

        super("Deposit Details");
        super.setFont(new Font("Serif",Font.BOLD,15));
        setVisible(true);
        setSize(700,700);
        setLocation(400,100);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        panel.setBorder(new LineBorder(Color.black,2));
        add(panel);
        
        
//      getContentPane().setBackground(new Color(173,216,230));

//        Meter Search

        JLabel lblMeterNumber = new JLabel("Search By Meter Number");
        lblMeterNumber.setBounds(10,28,170,30);
        lblMeterNumber.setFont(new Font("Serif",Font.BOLD,15));
        panel.add(lblMeterNumber);

//        Choice
        meterNumber = new Choice();
        meterNumber.setBounds(210,29,150,30);
        meterNumber.setFont(new Font("Tahoma",Font.ITALIC,15));
        panel.add(meterNumber);

        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                meterNumber.add(rs.getString("meter"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
     //        Meter Search

        JLabel lblMonth = new JLabel("Search By Month");
        lblMonth.setBounds(380,28,130,30);
        lblMonth.setFont(new Font("Serif",Font.BOLD,15));
        panel.add(lblMonth);

//        Choice
        choiceMonth = new Choice();
        choiceMonth.setBounds(540,28,130,30);
        choiceMonth.setFont(new Font("Tahoma",Font.ITALIC,15));
        choiceMonth.add("Jan");
        choiceMonth.add("Feb");
        choiceMonth.add("Mar");
        choiceMonth.add("Apr");
        choiceMonth.add("May");
        choiceMonth.add("Jun");
        choiceMonth.add("Jul");
        choiceMonth.add("Aug");
        choiceMonth.add("Sep");
        choiceMonth.add("Oct");
        choiceMonth.add("Nov");
        choiceMonth.add("Dec");
        panel.add(choiceMonth);

//        Table
        table = new JTable();
        try {
            Connect c = new Connect();
            ResultSet rs=  c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 100,700 , 600);
        panel.add(scroll);
        
//        Search Button
  
        search = new JButton("Search");
        search.setBounds(50,70,80,20);
        search.addActionListener(this);
        panel.add(search);
        
        
//        For Print Button

        print = new JButton("Print");
        print.setBounds(160,70,80,20);
        print.addActionListener(this);
        panel.add(print); 
        
        Back = new JButton("Back");
        Back.setBounds(260,70,80,20);
        Back.addActionListener(this);
        panel.add(Back); 
        
        
        

    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query = "select * from bill where meter_no='"+meterNumber.getSelectedItem()+"' and bill_month='"+choiceMonth.getSelectedItem()+"'";
            
            try{
                Connect c = new Connect();
               ResultSet result=  c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(result)); 
                
            }catch(Exception exe){
                exe.printStackTrace();
            }
            
        }
        else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
       
       
    }


    public static void main(String[] args) {
        new DepositDetails();
    }
}
