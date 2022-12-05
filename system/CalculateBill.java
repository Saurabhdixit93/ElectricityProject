
package electricity.billing.system;





import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class CalculateBill extends JFrame implements ActionListener {
    JTextField lblUnitsField;
    JButton submit,cancel;
    JLabel addressLable,nameLable;
    Choice meterNumberChoice,cMonths;


    CalculateBill(){
        super("Calculate Bill");
        setVisible(true);
        setSize(700,500);
        setLocation(280,110);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        add(panel);

//        Main heading

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setBounds(100,15,400,25);
        heading.setForeground(Color.BLACK);
        panel.add(heading);

//        Information Headings
        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setFont(new Font("Monospaced",Font.ITALIC,18));
        meterNumber.setBounds(90,90,150,40);
        meterNumber.setForeground(Color.BLACK);
        panel.add(meterNumber);

        meterNumberChoice = new Choice();
        try {
            Connect c= new Connect();
            ResultSet result= c.s.executeQuery("select * from customer");
            while (result.next()){
                
                meterNumberChoice.add(result.getString("meter"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        meterNumberChoice.setBounds(254,99,150,20);
        meterNumberChoice.setBackground(Color.WHITE);
        panel.add(meterNumberChoice);

//        Meter No

        JLabel lblname =  new JLabel("Name");
        lblname.setFont(new Font("Monospaced",Font.ITALIC,18));
        lblname.setBounds(90,130,150,40);
        lblname.setForeground(Color.BLACK);
        panel.add(lblname);
        
        nameLable = new JLabel();
        nameLable.setBounds(255,134,150,20);
        nameLable.setBackground(Color.WHITE);
        nameLable.setFont(new Font("serif",Font.BOLD,15));
        panel.add(nameLable);

        

//        For Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Monospaced",Font.ITALIC,18));
        lblAddress.setBounds(90,175,150,40);
        lblAddress.setForeground(Color.BLACK);
        panel.add(lblAddress);

        addressLable = new JLabel();
        addressLable.setBounds(255,178,150,20);
        addressLable.setBackground(Color.WHITE);
        addressLable.setFont(new Font("serif",Font.BOLD,15));
        panel.add(addressLable);
        
//        Auto Name And Address Function
  
        try{
            Connect c = new Connect();
            ResultSet result = c.s.executeQuery("select * from customer where meter = '"+meterNumberChoice.getSelectedItem()+"'");
            while(result.next()){
                nameLable.setText(result.getString("name"));
                addressLable.setText(result.getString("address"));
                  
            }
             }catch(Exception ex){
            ex.printStackTrace();
        }
            meterNumberChoice.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                       try{
                        Connect c = new Connect();
                        ResultSet result = c.s.executeQuery("select * from customer where meter = '"+meterNumberChoice.getSelectedItem()+"'");
                        while(result.next()){
                         nameLable.setText(result.getString("name"));
                         addressLable.setText(result.getString("address"));

                        } 
                            }catch(Exception ex){
                           ex.printStackTrace();
                       }
                   }

                });


//        State Field;
        JLabel lblUnits = new JLabel("Units Consume");
        lblUnits.setFont(new Font("Monospaced",Font.ITALIC,18));
        lblUnits.setBounds(90,215,150,40);
        lblUnits.setForeground(Color.BLACK);
        panel.add(lblUnits);

        lblUnitsField = new JTextField();
        lblUnitsField.setBorder(new LineBorder(new Color(0,0,0),1));
        lblUnitsField.setBounds(255,218,150,20);
        lblUnitsField.setBackground(Color.WHITE);
        panel.add(lblUnitsField);

//        City Field

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setFont(new Font("Monospaced",Font.ITALIC,18));
        lblMonth.setBounds(92,255,150,40);
        lblMonth.setForeground(Color.BLACK);
        panel.add(lblMonth);

        cMonths = new Choice();
        cMonths.setBounds(254,260,150,20);
        cMonths.setBackground(Color.WHITE);
        cMonths.add("Jan");
        cMonths.add("Feb"); 
        cMonths.add("Mar");
        cMonths.add("Apr");
        cMonths.add("May");
        cMonths.add("Jun");   
        cMonths.add("Jul"); 
        cMonths.add("Aug");
        cMonths.add("Sep");
        cMonths.add("Oct");
        cMonths.add("Nov");
        cMonths.add("Dec");
        panel.add(cMonths);

//        Buttons

        submit = new JButton("Submit");
        submit.setBounds(130,320,90,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Serif",Font.BOLD,15));
        submit.addActionListener(this);
        panel.add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(260,320,90,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.addActionListener(this);
        panel.add(cancel);
        setLayout(new BorderLayout());
        add(panel,"Center");

//        Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image newImage = image.getImage().getScaledInstance(250,360,Image.SCALE_DEFAULT);
        ImageIcon FinalImage = new ImageIcon(newImage);
        JLabel iconImage = new JLabel(FinalImage);
        add(iconImage,"West");
        getContentPane().setBackground(Color.WHITE);


    }
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==submit){
            
            String meter = meterNumberChoice.getSelectedItem();
            String units = lblUnitsField.getText();
            String months= cMonths.getSelectedItem();
            
            int totalBill = 0;
            int unit_consumed = Integer.parseInt(units);
            
            
            String query ="select * from tax";
            try {
                Connect c = new Connect();
               ResultSet result=  c.s.executeQuery(query);
               while(result.next()){
                 totalBill = unit_consumed *Integer.parseInt( result.getString("cost_per_unit"))+totalBill;
                 totalBill = Integer.parseInt(result.getString("meter_rent"))+totalBill;
                 totalBill = Integer.parseInt(result.getString("service_charge"))+totalBill;
                 totalBill = Integer.parseInt(result.getString("service_tax"))+totalBill;
                 totalBill = Integer.parseInt(result.getString("swach_bharar_cess"))+totalBill;
                 totalBill = Integer.parseInt(result.getString("fixed_tax"))+totalBill;
             
               }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            String query2 = "insert into bill values('"+ meter+"','"+ months+"','"+ units+"','"+ totalBill+"','Not Paid')";
            try{
                 
                 Connect c = new Connect();
                 c.s.executeUpdate(query2);
                 JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                 setVisible(false);
                
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else {
            setVisible(false);

        }

    }
    public static void main(String[] args) {
        new CalculateBill();

    }
}

