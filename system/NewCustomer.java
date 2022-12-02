
package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField usernameField,addressField,cityField,stateField,emailField,phoneField;
    JButton next,cancel;
    JLabel lblmeter;


    NewCustomer(){
        super("New Customer");
        setVisible(true);
        setSize(700,500);
        setLocation(280,140);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        add(panel);

//        Main heading

        JLabel heading = new JLabel("New Customer");
        heading.setFont(new Font("Serif",Font.BOLD,24));
        heading.setBounds(200,15,200,25);
        heading.setForeground(Color.BLACK);
        panel.add(heading);

//        Information Headings
        JLabel lblUsername = new JLabel("Customer Name");
        lblUsername.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblUsername.setBounds(90,80,150,40);
        lblUsername.setForeground(Color.BLACK);
        panel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBorder(new LineBorder(new Color(0,0,0),1));
        usernameField.setBounds(250,88,150,20);
        usernameField.setBackground(Color.WHITE);
        panel.add(usernameField);

//        Meter No

        JLabel lblmeterno =  new JLabel("Meter No");
        lblmeterno.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblmeterno.setBounds(90,120,150,40);
        lblmeterno.setForeground(Color.BLACK);
        panel.add(lblmeterno);

//        Meter No For auto
        lblmeter =  new JLabel();
        lblmeter.setBounds(250,122,150,40);
        panel.add(lblmeter);

//        For Random meter No values
        Random ran = new Random();
        long number = ran.nextLong() % 1000000000;
        lblmeter.setText(""+ Math.abs(number));

//        For Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblAddress.setBounds(90,160,150,40);
        lblAddress.setForeground(Color.BLACK);
        panel.add(lblAddress);

        addressField = new JTextField();
        addressField.setBorder(new LineBorder(new Color(0,0,0),1));
        addressField.setBounds(250,170,150,20);
        addressField.setBackground(Color.WHITE);
        panel.add(addressField);

//        State Field;
        JLabel lblstate = new JLabel("State");
        lblstate.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblstate.setBounds(90,200,150,40);
        lblstate.setForeground(Color.BLACK);
        panel.add(lblstate);

        stateField = new JTextField();
        stateField.setBorder(new LineBorder(new Color(0,0,0),1));
        stateField.setBounds(250,210,150,20);
        stateField.setBackground(Color.WHITE);
        panel.add(stateField);

//        City Field

        JLabel lblCity = new JLabel("City");
        lblCity.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblCity.setBounds(90,240,150,40);
        lblCity.setForeground(Color.BLACK);
        panel.add(lblCity);

        cityField = new JTextField();
        cityField.setBorder(new LineBorder(new Color(0,0,0),1));
        cityField.setBounds(250,250,150,20);
        cityField.setBackground(Color.WHITE);
        panel.add(cityField);

//        User Phone and Email Information
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblEmail.setBounds(90,280,150,40);
        lblEmail.setForeground(Color.BLACK);
        panel.add(lblEmail);

        emailField = new JTextField();
        emailField.setBorder(new LineBorder(new Color(0,0,0),1));
        emailField.setBounds(250,290,150,20);
        emailField.setBackground(Color.WHITE);
        panel.add(emailField);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblPhone.setBounds(90,320,150,40);
        lblPhone.setForeground(Color.BLACK);
        panel.add(lblPhone);

        phoneField = new JTextField();
        phoneField.setBorder(new LineBorder(new Color(0,0,0),1));
        phoneField.setBounds(250,330,150,20);
        phoneField.setBackground(Color.WHITE);
        panel.add(phoneField);

//        Buttons
        next = new JButton("Next");
        next.setBounds(130,380,80,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Serif",Font.BOLD,15));
        next.addActionListener(this);
        panel.add(next);


        cancel = new JButton("Cancel");
        cancel.setBounds(250,380,85,27);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.addActionListener(this);
        panel.add(cancel);
        setLayout(new BorderLayout());
        add(panel,"Center");

//        Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image newImage = image.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon FinalImage = new ImageIcon(newImage);
        JLabel iconImage = new JLabel(FinalImage);
        add(iconImage,"East");
        getContentPane().setBackground(Color.WHITE);


    }
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==next){
            String name = usernameField.getText();
            String meter = lblmeter.getText();
            String address = addressField.getText();
            String state = stateField.getText();
            String city= cityField.getText();
            String email = emailField.getText();
            String phoneNo= phoneField.getText();

            String query1 ="insert into customer values('"+name+"','"+meter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phoneNo+"')";
            String query2 = "insert into login values('"+meter+"','','"+name+"','','')";

            try {
                Connect c = new Connect();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully ");
                setVisible(false);
                
                
                new MeterInfo(meter);


            } 
            catch (Exception ex){
                ex.printStackTrace();
            }

        }else {
            setVisible(false);

        }

    }
    public static void main(String[] args) {
        new NewCustomer();

    }
}
