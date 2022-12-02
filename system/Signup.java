
package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
    JButton Back,create;
    Choice accountType;
     JTextField meterField,usernameFLbl ,nameFLbl,passwordFLbl;

    Signup(){
        super("Sign Up");
        setVisible(true);
        setBounds(400,150,660,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(10,20,620,300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(153,153,153)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(49,40,140,20);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Monospaced",Font.BOLD,12));
        panel.add(heading);
//       For choice
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(200,40,140,20);
        accountType.setForeground(Color.LIGHT_GRAY);
        accountType.setForeground(Color.BLACK);
        accountType.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,10));
      //  accountType.addFocusListener(l);
        panel.add(accountType);

        
        
        
//        For meter information

        JLabel meterLbl = new JLabel("Meter Number");
        meterLbl.setBounds(50,70,140,20);
        meterLbl.setForeground(Color.BLACK);
        meterLbl.setFont(new Font("Monospaced",Font.BOLD,12));
        meterLbl.setVisible(false);
        panel.add(meterLbl);
        meterField = new JTextField();
        meterField.setBounds(200,70,140,20);
        meterField.setBorder(new LineBorder(Color.BLACK,1));
        meterField.setBackground(Color.WHITE);
        meterField.setVisible(false);
        panel.add(meterField);
        
     
//        For username

        JLabel username = new JLabel("User Name");
        username.setBounds(50,100,120,20);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Monospaced",Font.BOLD,12));
        panel.add(username);

        usernameFLbl = new JTextField();
        usernameFLbl.setBounds(200,100,140,20);
        usernameFLbl.setBorder(new LineBorder(Color.BLACK,1));
        usernameFLbl.setBackground(Color.WHITE);
        panel.add(usernameFLbl);

//        For Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,130,120,20);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Monospaced",Font.BOLD,12));
        panel.add(name);

        nameFLbl = new JTextField();
        nameFLbl.setBounds(200,130,140,20);
        nameFLbl.setBorder(new LineBorder(Color.BLACK,1));
        nameFLbl.setForeground(Color.BLACK);
        panel.add(nameFLbl);

//        For Auto Data Fetch

        meterField.addFocusListener(new FocusListener(){
            
            @Override        
            public void focusGained(FocusEvent fG) {
                
            }

            @Override
            public void focusLost(FocusEvent fL){
                try{
                    Connect c = new Connect();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no='"+meterField.getText()+"'");
                    
                    while(rs.next()){
                        nameFLbl.setText(rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            
        });

        accountType.addItemListener(new ItemListener() {
            
           @Override
           public void itemStateChanged(ItemEvent e) {
               
               String user = accountType.getSelectedItem();
               if(user.equals("Customer")){
                   meterLbl.setVisible(true);
                   meterField.setVisible(true);
                   nameFLbl.setEditable(false);
                   nameFLbl.setBackground(Color.LIGHT_GRAY);
               }else{
                   meterLbl.setVisible(false);
                   meterField.setVisible(false);
                   nameFLbl.setEditable(true);
                   nameFLbl.setBackground(Color.WHITE);
               }
           }
       });
        
        
//        Password
        JLabel password = new JLabel("Password");
        password.setBounds(50,160,120,20);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Monospaced",Font.BOLD,12));
        panel.add(password);

        passwordFLbl = new JTextField();
        passwordFLbl.setBounds(200,160,140,20);
        passwordFLbl.setBorder(new LineBorder(Color.BLACK,1));
        passwordFLbl.setBackground(Color.WHITE);
        panel.add(passwordFLbl);

//        For Create Buttons
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setFont(new Font("DIALOG",Font.BOLD,13));
        create.setForeground(Color.WHITE);
        create.setBounds(80,210,100,20);
        create.addActionListener(this);
        panel.add(create);

//        For Back Buttons
        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("DIALOG",Font.BOLD,13));
        Back.setBounds(210,210,100,20);
        Back.addActionListener(this);
        panel.add(Back);

//        For Images In Buttons;
        ImageIcon imageSign = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image image = imageSign.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image2 =new ImageIcon(image);
        JLabel image3=  new JLabel(image2);
        image3.setBounds(400,20,200,200);
        panel.add(image3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==create){
            String aType = accountType.getSelectedItem();
            String sUsername =usernameFLbl .getText();
            String srname =nameFLbl .getText();
            String smeter =  meterField .getText();
            String spss =  passwordFLbl .getText();
            
            try{
                Connect c =new Connect();
                  String query =null;
                  if(aType.equals("Admin")){
                      
                     query ="insert into login values('"+smeter+"','"+sUsername+"','"+srname+"','"+spss+"', '"+aType+"')";
                 }else{
                      query ="update login set username='"+ sUsername+"',password='"+spss+"',user='"+aType+"' where meter_no='"+smeter+"'";
                  }
                  
                  
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Succeccfully");
                setVisible(false);
                new Login();
                
            }catch(Exception e){
                e.printStackTrace();
            }
          }else if(ae.getSource()==Back){
            setVisible(false);
            new Login();
            
        }

    }



    public static void main(String[] args) {
        new Signup();
    }
}
