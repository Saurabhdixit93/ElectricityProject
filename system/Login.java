package electricity.billing.system;

/**
 *
 * @author gaurav.dixit
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton RegisterBut,CancelBut,loginBut;
    JTextField username,passWord;
    Choice logIn;
    
    
    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        LoginAs Choos With Name;

        JLabel Loginasnew = new JLabel("Login As");
        Loginasnew.setBounds(300, 20, 100, 20);
        add(Loginasnew);
        logIn=  new Choice();
        logIn.add("Admin");
        logIn.add("Customer");
        logIn.setBounds(400,20,150,20);
        add(logIn);

//        For Username Input And Box;

        JLabel userName = new JLabel("Username");
        userName.setBounds(300,60,100,20);
        add(userName);
        username = new JTextField();
        username.setBounds(400,60,150,20);
        add(username);

//        For PasswordInput And Box

        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);
        passWord = new JTextField();
        passWord.setBounds(400,100,150,20);
        add(passWord);

//        Buttons for Login with image

        ImageIcon imageLog  = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image imageNew = imageLog.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon imageLogin = new ImageIcon(imageNew);
        loginBut = new JButton("Login",imageLogin);
        loginBut.setBounds(330,160,100,20);
        loginBut.addActionListener(this);
        add(loginBut);

//        Buttons for Cancel

        ImageIcon imageCan  = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image imageCanNew = imageCan.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon imageCancel = new ImageIcon(imageCanNew);
        CancelBut = new JButton("Cancel",imageCancel);
        CancelBut.setBounds(450,160,100,20);
        CancelBut.addActionListener(this);
        add(CancelBut);

//        Buttons for Register

        ImageIcon imageReg  = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image imageRegNew = imageReg.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon imageRegister = new ImageIcon(imageRegNew);
        RegisterBut = new JButton("Signup",imageRegister);
        RegisterBut.setBounds(360,220,100,20);
        RegisterBut.addActionListener(this);
        add(RegisterBut);

//        image Of Label 

        ImageIcon LabelImg  = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image LableimageRegNew = LabelImg.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon ImageLableFinal = new ImageIcon(LableimageRegNew);
        JLabel finalImage = new JLabel(ImageLableFinal);
        finalImage.setBounds(0,0,250,250);
        add(finalImage);


        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==loginBut){
            String sUsername = username.getText();
            String pPassword = passWord.getText();
            String selectChoice = logIn.getSelectedItem();
            
            try{
                 Connect c =new Connect();
                 String query ="Select * from login where username='"+sUsername+"' and password= '"+pPassword+"' and user='"+selectChoice+"'";
                 
                ResultSet rSet = c.s.executeQuery(query);
                if(rSet.next()){
                    String meterUse = rSet.getString("meter_no");
                    setVisible(false);
                    new NewFrame(selectChoice,meterUse);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login ! Please Check Your Details");
                    username.setText("");
                    passWord.setText("");
                   
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()==CancelBut){
            setVisible(false);

        }else if (ae.getSource()==RegisterBut){
            setVisible(false);
            new Signup();

        }

    }


    public static void main(String[] args) {

        new Login();
    }
}


