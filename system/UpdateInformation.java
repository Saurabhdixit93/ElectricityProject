
package electricity.billing.system;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
    String meterNumber;
    JLabel name,meter;
    JTextField address,state,city,email,phone;
    JButton update,back;

    UpdateInformation(String meterNumber){

        super("Update Customer Information");
        this.meterNumber= meterNumber;
        setVisible(true);
        setBounds(300,150,800,500);
        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.BLACK,2));
        add(panel);


        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(120,10,400,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setForeground(Color.BLACK);
        panel.add(heading);

//        All Fields
//        For Name

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(15,70,50,17);
        nameLabel.setFont(new Font("serif",Font.PLAIN,17));
        nameLabel.setForeground(Color.BLACK);
        panel.add(nameLabel);

        name = new JLabel("");
        name.setBounds(160,70,150,20);
        name.setFont(new Font("serif",Font.PLAIN,17));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        name.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(name);

//        For Meter

        JLabel meterLabel = new JLabel("Meter Number");
        meterLabel.setBounds(15,110,130,17);
        meterLabel.setFont(new Font("serif",Font.PLAIN,17));
        meterLabel.setForeground(Color.BLACK);
        panel.add(meterLabel);

        meter = new JLabel("");
        meter.setBounds(160,110,150,20);
        meter.setFont(new Font("serif",Font.PLAIN,17));
        meter.setForeground(Color.BLACK);
        meter.setBorder(new LineBorder(Color.BLACK,2));
        meter.setBackground(Color.WHITE);
        panel.add(meter);

//        For Address

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(15,150,130,17);
        addressLabel.setFont(new Font("serif",Font.PLAIN,17));
        addressLabel.setForeground(Color.BLACK);
        panel.add(addressLabel);

//        address field

        address = new JTextField();
        address.setBackground(Color.WHITE);
        address.setBounds(160,150,150,20);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Monospaced",Color.HSBtoRGB(14,14,14),17));
        address.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(address);

//        For city

        JLabel cityLabel = new JLabel("City");
        cityLabel.setBounds(15,190,130,23);
        cityLabel.setFont(new Font("serif",Font.PLAIN,17));
        cityLabel.setForeground(Color.BLACK);
        panel.add(cityLabel);

//        city field

        city = new JTextField();
        city.setBackground(Color.WHITE);
        city.setBounds(160,190,150,20);
        city.setFont(new Font("Monospaced",Color.HSBtoRGB(14,14,14),17));
        city.setForeground(Color.BLACK);
        city.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(city);


//        For State

        JLabel stateLabel = new JLabel("State");
        stateLabel.setBounds(15,230,130,17);
        stateLabel.setFont(new Font("serif",Font.PLAIN,17));
        stateLabel.setForeground(Color.BLACK);
        panel.add(stateLabel);

//        state field

        state = new JTextField();
        state.setBackground(Color.WHITE);
        state.setBounds(160,230,150,20);
        state.setForeground(Color.BLACK);
        state.setFont(new Font("Monospaced",Color.HSBtoRGB(14,14,14),17));
        state.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(state);

//        Email Update

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(15,270,130,17);
        emailLabel.setFont(new Font("serif",Font.PLAIN,17));
        emailLabel.setForeground(Color.BLACK);
        panel.add(emailLabel);

//        email field

        email = new JTextField();
        email.setBackground(Color.WHITE);
        email.setBounds(160,270,150,20);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Monospaced",Color.HSBtoRGB(14,14,14),17));
        email.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(email);

//        Phone Update

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(15,310,130,17);
        phoneLabel.setFont(new Font("serif",Font.PLAIN,17));
        phoneLabel.setForeground(Color.BLACK);
        panel.add(phoneLabel);

//        phone field

        phone = new JTextField();
        phone.setBackground(Color.WHITE);
        phone.setBounds(160,310,150,20);
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("Monospaced",Color.HSBtoRGB(14,14,14),17));
        phone.setBorder(new LineBorder(Color.BLACK,2));
        panel.add(phone);

//        For DataBase
        try {
            Connect c =new Connect();
            ResultSet result = c.s.executeQuery("select * from customer where meter = '"+meterNumber+"'");
            while (result.next()){
                name.setText(result.getString("name"));
                meter.setText(result.getString("meter"));
                address.setText(result.getString("address"));
                city.setText(result.getString("city"));
                state.setText(result.getString("state"));
                email.setText(result.getString("email"));
                phone.setText(result.getString("phone"));
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

//        Buttons For Action
        ImageIcon imageUpdate=  new ImageIcon(ClassLoader.getSystemResource("icon/updatenewlogo.png"));
        Image updatedImage = imageUpdate.getImage().getScaledInstance(30,15,Image.SCALE_DEFAULT);
        ImageIcon imageFinal = new ImageIcon(updatedImage);
        update = new JButton("Update",imageFinal);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.setBounds(50,370,100,30);
        update.addActionListener(this);
        update.setBorder(new LineBorder(Color.YELLOW,2));
        panel.add(update);

//        Back Button
        ImageIcon imageTemp = new ImageIcon(ClassLoader.getSystemResource("icon/Back.png"));
        Image image = imageTemp.getImage().getScaledInstance(30,15,Image.SCALE_DEFAULT);
        ImageIcon newimage = new ImageIcon(image);
        back = new JButton("Back",newimage);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(220,370,100,30);
        back.addActionListener(this);
        back.setBorder(new LineBorder(Color.YELLOW,2));
        panel.add(back);

        ImageIcon tempImage = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image newImage = tempImage.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(newImage);
        JLabel setImage = new JLabel(image1);
        setImage.setBounds(390,60,300,250);
        panel.add(setImage,"East");





        
        

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==update){
            String adr = address.getText();
            String cty = city.getText();
            String stat = state.getText();
            String eml = email.getText();
            String phn = phone.getText();

            try {
                Connect c = new Connect();
                c.s.executeUpdate("update customer set address='"+adr+"',state='"+stat+"', city='"+cty+"',email='"+eml+"',phone ='"+phn+"' where meter='"+meter+"'");

                JOptionPane.showMessageDialog(null,"User Information Updated Successfully !!");
                setVisible(false);

            }catch (Exception exe){
                exe.printStackTrace();
            }

        }else {
            setVisible(false);
        }


    }
    
    public static void main(String[] args){

        new UpdateInformation("");
    }
}
