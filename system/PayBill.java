package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    JLabel meter,name,units,totalBill,statusBill;
    JButton back,pay;
    Choice choiceMonth;
    String meterNumber;
    PayBill(String meterNumber) {
        super("Pay Bill");
        super.setFont(new Font("Serif",Font.BOLD,15));
        this.meterNumber= meterNumber;
        setVisible(true);
        setSize(900,600);
        setLocation(250,100);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        panel.setBorder(new LineBorder(Color.black,2));
        add(panel);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setBounds(50,10,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBackground(Color.BLACK);
        panel.add(heading);
//        Meter Search

        JLabel lblMeter = new JLabel("Meter Number");
        lblMeter.setBounds(10,100,150,30);
        lblMeter.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblMeter);

//        Auto generate Field

        meter = new JLabel();
        meter.setBounds(250,105,150,20);
        meter.setFont(new Font("Serif",Font.BOLD,15));
        meter.setBorder(new LineBorder(Color.pink,1));
        meter.setBackground(Color.WHITE);
        meter.setForeground(Color.BLACK);
        panel.add(meter);


//        Name

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10,150,150,30);
        lblName.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblName);

//       name Auto

        name = new JLabel("");
        name.setBounds(250,150,150,20);
        name.setFont(new Font("Serif",Font.BOLD,15));
        name.setBorder(new LineBorder(Color.pink,1));
        name.setBackground(Color.WHITE);
        name.setForeground(Color.BLACK);
        panel.add(name);

//        Month

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setBounds(10,210,150,30);
        lblMonth.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblMonth);

//      Month Select

        choiceMonth = new Choice();
        choiceMonth.setBounds(250,215,150,20);
        choiceMonth.setFont(new Font("serif",Font.ITALIC,15));
        choiceMonth.setBackground(Color.WHITE);
        choiceMonth.setForeground(Color.BLACK);
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

//        Units


        JLabel lblUnits = new JLabel("Units");
        lblUnits.setBounds(10,260,150,30);
        lblUnits.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblUnits);

//        Units Field;

        units = new JLabel("");
        units.setBounds(250,265,150,20);
        units.setFont(new Font("Serif",Font.BOLD,15));
        units.setBorder(new LineBorder(Color.pink,1));
        units.setBackground(Color.WHITE);
        units.setForeground(Color.BLACK);
        panel.add(units);

//        Total Bill

        JLabel lblTotalBill = new JLabel("Total Bill");
        lblTotalBill.setBounds(10,310,150,30);
        lblTotalBill.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblTotalBill);

//        Total bill Field;

        totalBill = new JLabel("");
        totalBill.setBounds(250,315,150,20);
        totalBill.setFont(new Font("Serif",Font.BOLD,15));
        totalBill.setBorder(new LineBorder(Color.pink,1));
        totalBill.setBackground(Color.WHITE);
        totalBill.setForeground(Color.BLACK);
        panel.add(totalBill);

        JLabel lblStatus = new JLabel("Status Bill");
        lblStatus.setBounds(10,360,150,30);
        lblStatus.setFont(new Font("MonoSpace",Font.BOLD,15));
        panel.add(lblStatus);

//        Total bill Field;

        statusBill = new JLabel("");
        statusBill.setBounds(250,365,150,20);
        statusBill.setFont(new Font("Serif",Font.BOLD,15));
        statusBill.setBorder(new LineBorder(Color.pink,1));
        statusBill.setBackground(Color.WHITE);
        statusBill.setForeground(Color.RED);
        panel.add(statusBill);

//        Data Base use

        try {
            Connect c = new Connect();
            ResultSet resultSet = c.s.executeQuery("select * from customer where meter ='"+meterNumber+"'");
            while (resultSet.next()){
                meter.setText(meterNumber);
                name.setText(resultSet.getString("name"));
            }
            resultSet = c.s.executeQuery("select * from bill where meter_no ='"+meterNumber+"'and bill_month='Jan'");
            while (resultSet.next()){
                units.setText(resultSet.getString("units"));
                totalBill.setText(resultSet.getString("total_bill"));
                statusBill.setText(resultSet.getString("status_bill"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
//        Image

        getContentPane().setBackground(Color.WHITE);

        ImageIcon billImage = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image image = billImage.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon newImage = new ImageIcon(image);
        JLabel imageLbl = new JLabel(newImage);
        imageLbl.setBounds(350,120,600,300);
        getContentPane().setBackground(new Color(173,216,230));
        panel.add(imageLbl,"South");


        ImageIcon imageTemp = new ImageIcon(ClassLoader.getSystemResource("icon/Back.png"));
        Image imageBack = imageTemp.getImage().getScaledInstance(30,15,Image.SCALE_DEFAULT);
        ImageIcon newimage = new ImageIcon(imageBack);
        back = new JButton("Back",newimage);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Monospace",Font.PLAIN,20));
        back.setBounds(200,450,100,30);
        back.addActionListener(this);
        back.setBorder(new LineBorder(Color.YELLOW,2));
        panel.add(back);

//        Pay Button
        ImageIcon payImage = new ImageIcon(ClassLoader.getSystemResource("icon/payimage.png"));
        Image imagePay = payImage.getImage().getScaledInstance(30,15,Image.SCALE_DEFAULT);
        ImageIcon newPay = new ImageIcon(imagePay);
        pay = new JButton("Pay",newPay);
        pay.setBackground(Color.WHITE);
        pay.setForeground(Color.BLACK);
        pay.setFont(new Font("Monospace",Font.PLAIN,20));
        pay.setBounds(350,450,100,30);
        pay.addActionListener(this);
        pay.setBorder(new LineBorder(Color.YELLOW,2));
        panel.add(pay);

//       Month Selection Change

        choiceMonth.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                try {

                    Connect c = new Connect();
                    ResultSet resultSet = c.s.executeQuery("select * from bill where meter_no ='"+ meterNumber+"'and bill_month='"+choiceMonth.getSelectedItem()+"'");
                    while (resultSet.next()){
                        units.setText(resultSet.getString("units"));
                        totalBill.setText(resultSet.getString("total_bill"));
                        statusBill.setText(resultSet.getString("status_bill"));
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==pay){
            try {
                Connect c=  new Connect();
                c.s.executeUpdate("update bill set status_bill='Paid' where meter_no ='"+meterNumber+"' and bill_month='"+choiceMonth.getSelectedItem()+"'");
            }catch (Exception exception){
                exception.printStackTrace();
            }
            setVisible(false);
            new Paytm(meterNumber);

        }else {
            setVisible(false);
        }


    }
    public static void main(String[] args) {
        new PayBill("");

    }



}
