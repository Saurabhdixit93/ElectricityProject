package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame implements ActionListener {
    JButton print;

    JTable table;
    String meter;

    BillDetails(String meter){
        super("Bill Details");
        this.meter = meter;
        setVisible(true);
        setSize(470,450);
        setLocation(250,70);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,450,400);
        panel.setBorder(new LineBorder(Color.BLACK,2));
        panel.setBackground(Color.WHITE);
        add(panel);

        table = new JTable();
        try {
            Connect c = new Connect();
            String query = "select * from bill where meter_no='"+meter+"'";
            ResultSet resultSet = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,470,450);
        panel.add(scrollPane);



//        ImageIcon printImage = new ImageIcon(ClassLoader.getSystemResource("icon/print.jpg"));
//        Image image = printImage.getImage().getScaledInstance(30,15,Image.SCALE_DEFAULT);
//        ImageIcon newImage = new ImageIcon(image);
//        print = new JButton("Print");
//        print.setBounds(0,580,700,40);
//        print.setFont(new Font("Serif",Font.BOLD,15));
//        print.setBackground(Color.BLACK);
//        print.setForeground(Color.WHITE);
//        print.addActionListener(this);
//        panel.add(print,newImage);

    }

    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == print) {
//            try {
//                table.print();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
    }
    public static void main(String[] args) {
        new BillDetails("");

    }


}
