package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bAdd,bSub,bMulti,bDivide,bEq,bDel,bDec,bClear;
    static double a=0,b=0,result=0;
    static int operator;

    Calculator(){

        setTitle("My Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image image =imageIcon.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        this.setIconImage(image);
        setVisible(true);
        setSize(420,480);
        setLocation(300,100);
        setLayout(null);
        setResizable(false);
        this.setBackground(Color.RED);
        textField = new JTextField();
        textField.setFont(new Font("SANS SERIF",Font.BOLD,20));
        textField.setBackground(Color.YELLOW);
        textField.setForeground(Color.BLACK);
        textField.setBorder(new LineBorder(Color.BLUE,2));
        textField.setBounds(50,60,310,60);
        textField.setEditable(false);
        add(textField);

//        Buttons

        b1 = new JButton("1");
        b1.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,150,80,30);
        b1.addActionListener(this);

        b2 = new JButton("2");
        b2.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(120,150,80,30);
        b2.addActionListener(this);

        b3 = new JButton("3");
        b3.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(210,150,80,30);
        b3.addActionListener(this);

        bClear = new JButton("AC");
        bClear.setFont(new Font("SERIF",Font.PLAIN,20));
        bClear.setBackground(Color.WHITE);
        bClear.setForeground(Color.BLACK);
        bClear.setBounds(300,150,70,90);
        bClear.addActionListener(this);

        b4 = new JButton("4");
        b4.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(30,210,80,30);
        b4.addActionListener(this);

        b5 = new JButton("5");
        b5.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(120,210,80,30);
        b5.addActionListener(this);

        b6 = new JButton("6");
        b6.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        b6.setBounds(210,210,80,30);


        b7 = new JButton("7");
        b7.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        b7.setBounds(30,270,80,30);

        b8 = new JButton("8");
        b8.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        b8.setBounds(120,270,80,30);

        b9 = new JButton("9");
        b9.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        b9.setBounds(210,270,80,30);

        bAdd = new JButton("+");
        bAdd.setFont(new Font("SERIF",Font.PLAIN,50));
        bAdd.setBackground(Color.WHITE);
        bAdd.setForeground(Color.BLACK);
        bAdd.addActionListener(this);
        bAdd.setBounds(300,250,70,100);

        b0 = new JButton("0");
        b0.setFont(new Font("MONOSPACE",Font.BOLD,20));
        b0.setBackground(Color.BLACK);
        b0.setForeground(Color.WHITE);
        b0.addActionListener(this);
        b0.setBounds(30,320,100,40);


        bDel = new JButton("Delete");
        bDel.setBackground(Color.BLACK);
        bDel.setForeground(Color.WHITE);
        bDel.addActionListener(this);
        bDel.setBounds(140,320,70,40);

        bSub = new JButton("-");
        bSub.setFont(new Font("MONOSPACE",Font.ROMAN_BASELINE,20));
        bSub.setBackground(Color.BLACK);
        bSub.setForeground(Color.WHITE);
        bSub.addActionListener(this);
        bSub.setBounds(220,320,70,40);

        bMulti = new JButton("*");
        bMulti.setFont(new Font("MONOSPACE",Font.BOLD,20));
        bMulti.setBackground(Color.BLACK);
        bMulti.setForeground(Color.WHITE);
        bMulti.addActionListener(this);
        bMulti.setBounds(30,370,100,40);

        bDivide = new JButton("/");
        bDivide.setFont(new Font("MONOSPACE",Font.BOLD,20));
        bDivide.setBackground(Color.BLACK);
        bDivide.setForeground(Color.WHITE);
        bDivide.addActionListener(this);
        bDivide.setBounds(220,370,70,40);



        bDec = new JButton(".");
        bDec.setFont(new Font("MONOSPACE",Font.BOLD,20));
        bDec.setBackground(Color.BLACK);
        bDec.setForeground(Color.WHITE);
        bDec.addActionListener(this);
        bDec.setBounds(140,370,70,40);


        bEq = new JButton("=");
        bEq.setFont(new Font("MONOSPACE",Font.BOLD,20));
        bEq.setBackground(Color.WHITE);
        bEq.setForeground(Color.BLACK);
        bEq.addActionListener(this);
        bEq.setBounds(300,350,70,80);


//        Add In Buttons
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b0);
        add(bAdd);
        add(bSub);
        add(bMulti);
        add(bDivide);
        add(bDec);
        add(bDel);
        add(bClear);
        add(bEq);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            textField.setText(textField.getText().concat("1"));
        }else if (e.getSource()==b2){
            textField.setText(textField.getText().concat("2"));
        }else if (e.getSource()==b3){
            textField.setText(textField.getText().concat("3"));
        }else if (e.getSource()==b4){
            textField.setText(textField.getText().concat("4"));
        }else if (e.getSource()==b5){
            textField.setText(textField.getText().concat("5"));
        }else if (e.getSource()==b6){
            textField.setText(textField.getText().concat("6"));
        }else if (e.getSource()==b7){
            textField.setText(textField.getText().concat("7"));
        }else if (e.getSource()==b8){
            textField.setText(textField.getText().concat("8"));
        }else if (e.getSource()==b9){
            textField.setText(textField.getText().concat("9"));
        }else if (e.getSource()==b0){
            textField.setText(textField.getText().concat("0"));
        }else if (e.getSource()==bDec){
            textField.setText(textField.getText().concat("."));
        }
        else if (e.getSource()==bAdd){
            a = Double.parseDouble(textField.getText());
            operator=1;
            textField.setText("");
        }else if (e.getSource()==bSub){
            a = Double.parseDouble(textField.getText());
            operator=2;
            textField.setText("");
        }else if (e.getSource()==bMulti){
            a = Double.parseDouble(textField.getText());
            operator=3;
            textField.setText("");
        }else if (e.getSource()==bDivide){
            a = Double.parseDouble(textField.getText());
            operator=4;
            textField.setText("");
        }else if (e.getSource()==bEq){
            b = Double.parseDouble(textField.getText());
            switch (operator){
                case 1: result= a+b;
                    break;
                case 2: result= a-b;
                    break;
                case 3: result= a*b;
                    break;
                case 4: result= a/b;
                   break;
            }
            textField.setText(""+result);
        }else if (e.getSource()==bClear){
            textField.setText("");
        }else if (e.getSource()==bDel){
           String s = textField.getText();
           textField.setText("");
           for (int i=0;i<s.length()-1;i++){
               textField.setText(textField.getText()+s.charAt(i));
           }
        }

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Calculator().setVisible(true);
    }
}
