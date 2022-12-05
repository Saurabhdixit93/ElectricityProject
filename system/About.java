package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){

        setVisible(true);
        setBackground(Color.WHITE);
        setTitle("About NotePad");
        setBounds(270,150,500,500);
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        setIconImage(imageIcon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel icon  = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/notepad.jpg")));
        icon.setBounds(180,50,100,100);
        add(icon);
        JLabel text = new JLabel("<html> &nbsp &nbsp &nbsp <u>Welcome To NotePad</u><br><hr> NotePad Is Simple Text Editor App<br> Launch By Microsoft <br> Contact me - smartds2550@gmail.com <br>All Rights Reserved 2022</html>");
        text.setBounds(80,100,500,400);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("SERIF",Font.ITALIC,18));
        add(text);





    }


    public static void main(String[] args) {
        new About();
    }
}
