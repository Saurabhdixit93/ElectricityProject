package electricity.billing.system;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;

public class Clientform extends JFrame implements ActionListener{

    JButton submit;     //global variables
    JButton reset;
    JTextField tname;
    JTextField tmail;
    JTextField tfeedback;
    Container cp;
    JCheckBox check;
    JComboBox<String> agegrp;
    JFrame f;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    ButtonGroup rating;
    String[] ages= {"Below 18","18-44","45-60","Above 60"};

    public Clientform(){

        this.setTitle("Client Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(660, 650);
        this.setLocation(200,80);
        cp= getContentPane();
        this.setLayout(null);
        this.cp.setBackground(new java.awt.Color(0x64A6E3DF, true));
        ImageIcon lblImage =new ImageIcon(ClassLoader.getSystemResource("icon/images.jpg"));
        Image lblimage = lblImage.getImage().getScaledInstance(650,250,Image.SCALE_DEFAULT);
        ImageIcon newImage = new ImageIcon(lblimage);
        JLabel image = new JLabel(newImage);
        image.setBounds(0,440,650,250);
        this.add(image);
        getContentPane().setBackground(new Color(166, 227, 223, 100));

        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        this.setIconImage(icon.getImage());

        JLabel heading= new JLabel();
        heading.setText("FEEDBACK SURVEY");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setBounds(80,0,440,45);
        this.cp.add(heading);


        JLabel lname= new JLabel();
        lname.setText("Name: ");
        lname.setFont(new Font("Calibri", Font.PLAIN, 18));
        lname.setBounds(50,60,80,28);
        this.cp.add(lname);

        tname = new JTextField();
        tname.setFont(new Font("Calibri", Font.PLAIN, 16));
        tname.setBounds(230, 60, 240, 28);
        this.cp.add(tname);

        JLabel lmail= new JLabel();
        lmail.setText("Email Address: ");
        lmail.setFont(new Font("Calibri", Font.PLAIN, 18));
        lmail.setBounds(50,110, 150, 28);
        this.cp.add(lmail);

        tmail = new JTextField();
        tmail.setFont(new Font("Calibri", Font.PLAIN, 16));
        tmail.setBounds(230, 105, 240, 28);
        this.cp.add(tmail);

        check = new JCheckBox("Receive promotional emails");
        check.setFont(new Font("Calibri", Font.PLAIN, 15));
        check.setBounds(230, 135, 240, 20);
        check.setSelected(true);
        this.cp.add(check);

        JLabel lage= new JLabel();
        lage.setText("Age Group: ");
        lage.setFont(new Font("Calibri", Font.PLAIN, 18));
        lage.setBounds(50,180,150,28);
        this.cp.add(lage);

        agegrp= new JComboBox<>(ages);
        agegrp.setBounds(230,180,120,28);
        this.cp.add(agegrp);


        JLabel lrating= new JLabel();
        lrating.setText("Rating: ");
        lrating.setFont(new Font("Calibri", Font.PLAIN, 18));
        lrating.setBounds(50,230,100,28);
        this.cp.add(lrating);


        one=new JRadioButton("1");
        two=new JRadioButton("2");
        three=new JRadioButton("3");
        four=new JRadioButton("4");
        five=new JRadioButton("5");

        one.setBounds(230, 230, 40, 28);
        two.setBounds(280, 230, 40, 28);
        three.setBounds(330, 230, 40, 28);
        four.setBounds(380, 230, 40, 28);
        five.setBounds(430, 230, 40, 28);
        five.setSelected(true);

        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);

        rating= new ButtonGroup();  //A buttongroup ensures only one of the 5 radio buttons are selected at a time
        rating.add(one);
        rating.add(two);
        rating.add(three);
        rating.add(four);
        rating.add(five);

        JLabel lfeedback= new JLabel();
        lfeedback.setText("Feedback (optional): ");
        lfeedback.setFont(new Font("Calibri", Font.PLAIN, 18));
        lfeedback.setBounds(50,280,170,28);
        this.cp.add(lfeedback);

        tfeedback = new JTextField();
        tfeedback.setFont(new Font("Calibri", Font.PLAIN, 16));
        tfeedback.setBounds(230, 280, 240, 84);
        this.cp.add(tfeedback);

        submit= new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.PLAIN, 18));
        submit.setBounds(165, 390, 100, 28);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        this.cp.add(submit);

        reset= new JButton("Reset");
        reset.setFont(new Font("Calibri", Font.PLAIN, 18));
        reset.setBounds(275, 390, 100, 28);
        reset.addActionListener(this);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        this.cp.add(reset);

        this.setVisible(true);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(emailvalidation);
        Matcher mat = p.matcher(tmail.getText());
        f = new JFrame();

        if (e.getSource() == submit) {
            if ((tname.getText().isEmpty()) || (tname.getText() == null)) {
                JOptionPane.showMessageDialog(f, "Name cannot be empty");
            } else if ((tmail.getText().isEmpty()) || (tmail.getText() == null)) {
                JOptionPane.showMessageDialog(f, "Email cannot be empty");
            } else if (!mat.matches()) {
                JOptionPane.showMessageDialog(f, "Please Enter a valid Email");
            } else
                flag = true;

            if (flag) {
                String r;
                if (one.isSelected())
                    r = "One star";
                else if (two.isSelected())
                    r = "Two stars";
                else if (three.isSelected())
                    r = "Three stars";
                else if (four.isSelected())
                    r = "Four stars";
                else
                    r = "Five stars";
            }
            if (flag) {
                String r;
                if (one.isSelected())
                    r = "One star";
                else if (two.isSelected())
                    r = "Two stars";
                else if (three.isSelected())
                    r = "Three stars";
                else if (four.isSelected())
                    r = "Four stars";
                else
                    r = "Five stars";
                String name = tname.getText();
                String email = tmail.getText();
                String check1 = check.getText();
                String age = (String) agegrp.getSelectedItem();
                String rat = r;
                String feedback = tfeedback.getText();

                String query = "insert into clientFeedback values('" + name + "','"+check1+"','" + email + "','" + age + "','" + rat + "','" + feedback + "')";

                try {
                    Connect c = new Connect();
                    c.s.executeUpdate(query);
                    String s1 = "Thank you for your valuable Feedback!\n\nYour Responses:-\n";
                    String s2 = "Name: " + tname.getText() +"\ncheckBox :"+check.getText() + "\nEmail: " + tmail.getText() + "\nAge group: " + (String) agegrp.getSelectedItem() + "\nRating: " + rating + "\nFeedback: " + tfeedback.getText();
                    String disp = s1 + s2;
                    JOptionPane.showMessageDialog(f, disp);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            } else if (e.getSource() == reset) {
                tname.setText(null);
                tmail.setText(null);
                tfeedback.setText(null);
                agegrp.setSelectedIndex(0);
                one.setSelected(false);
                two.setSelected(false);
                three.setSelected(false);
                four.setSelected(false);
                five.setSelected(true);
            }
        }

    public static void main(String[] args) {
        new Clientform();
    }
}
