
package electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.ResultSet;


public class ViewInformation extends JFrame implements ActionListener{
    JLabel Name,meter,address,city,state,email,phone;
    JButton cancel,print;

    ViewInformation(String meterUse){
        super("View Information");
        setVisible(true);
        setBounds(200,50,900,680);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255, 255));
        panel.setBorder(new LineBorder(Color.black,2));
        add(panel);

//      Headings

        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,460,50);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(heading);

//        Name Label

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(80,90,100,20);
        labelName.setForeground(Color.BLACK);
        labelName.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelName);

//        For displaying name

        Name = new JLabel("");
        Name.setBounds(250,85,200,30);
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("serif",Font.ITALIC,18));
        Name.setForeground(Color.BLUE);
        panel.add(Name);

//        Meter Number Label

        JLabel labelMeterNum = new JLabel("Meter Number");
        labelMeterNum.setBounds(80,150,150,15);
        labelMeterNum.setForeground(Color.BLACK);
        labelMeterNum.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelMeterNum);

//        For displaying Meter Number

        meter = new JLabel("");
        meter.setBounds(260,145,200,30);
        meter.setForeground(Color.BLACK);
        meter.setFont(new Font("serif",Font.ITALIC,18));
        meter.setForeground(Color.BLUE);
        panel.add(meter);

//                Address Label

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(80,210,150,15);
        labelAddress.setForeground(Color.BLACK);
        labelAddress.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelAddress);

//        For displaying Address

        address = new JLabel("");
        address.setBounds(260,205,200,30);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("serif",Font.ITALIC,18));
        address.setForeground(Color.BLUE);
        panel.add(address);

//                City Label

        JLabel labelCity = new JLabel("City");
        labelCity.setBounds(80,270,150,25);
        labelCity.setForeground(Color.BLACK);
        labelCity.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelCity);

//        For displaying City

        city = new JLabel("");
        city.setBounds(260,265,200,30);
        city.setForeground(Color.BLACK);
        city.setFont(new Font("serif",Font.ITALIC,18));
        city.setForeground(Color.BLUE);
        panel.add(city);

//              State Label

        JLabel labelState = new JLabel("State");
        labelState.setBounds(500,90,150,20);
        labelState.setForeground(Color.BLACK);
        labelState.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelState);

//        For displaying State

        state = new JLabel("");
        state.setBounds(650,85,200,30);
        state.setForeground(Color.BLACK);
        state.setFont(new Font("serif",Font.ITALIC,18));
        state.setForeground(Color.BLUE);
        panel.add(state);

//              Email Label

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(500,150,150,20);
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelEmail);

//        For displaying Email

        email = new JLabel("");
        email.setBounds(650,145,200,30);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("serif",Font.ITALIC,18));
        email.setForeground(Color.BLUE);
        panel.add(email);


//              Phone Label

        JLabel labelPhone = new JLabel("Phone Number");
        labelPhone.setBounds(500,210,200,20);
        labelPhone.setForeground(Color.BLACK);
        labelPhone.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(labelPhone);

//        For displaying Phone

        phone = new JLabel("");
        phone.setBounds(680,205,100,30);
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("serif",Font.ITALIC,18));
        phone.setForeground(Color.BLUE);
        panel.add(phone);
        
//        DataBase Info Collect

        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from customer where meter ='"+meterUse+"'");
            while(rs.next()){
                Name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state")); 
                email.setText(rs.getString("email"));  
                phone.setText(rs.getString("phone"));
                meter.setText(rs.getString("meter"));
               
            }
        }catch(Exception exe){
       exe.printStackTrace();
    }

//        Cancel Button

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Sefif-Bold",Font.BOLD,15));
        cancel.setBounds(400,350,100,30);
        cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        panel.add(cancel);

//        Image Uses

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image scaledImage =image.getImage().getScaledInstance(880,270,Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(scaledImage);
        JLabel newImage = new JLabel(finalImage);
        newImage.setBounds(2,400,880,270);
        panel.add(newImage);
        setVisible(true);
    }
      public void actionPerformed(ActionEvent ae){
          
          if(ae.getSource()==cancel){
             setVisible(false);
          }
          
      }

    public static void main (String [] args){
        new ViewInformation("");
    }
}
