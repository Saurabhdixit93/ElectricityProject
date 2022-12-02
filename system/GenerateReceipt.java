package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GenerateReceipt extends JFrame implements ActionListener {
    String meterNumber;
    Choice choiceMonth;
    JButton bill;
    JTextArea textArea;
    GenerateReceipt(String meterNumber){
        super("GenerateReceipt");
        this.meterNumber =meterNumber;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,650);
        setLocation(500,40);
        setLayout(new BorderLayout());
        setVisible(true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Generate Receipt");
        JLabel meter = new JLabel(meterNumber);
        choiceMonth = new Choice();
        choiceMonth.setBounds(150,10,150,20);
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
        textArea = new JTextArea(50,15);
        textArea.setText("\n\n\t --------Click on the -------- \n\t Generate Bill Button to get \n\t the Bill of the Selected Month ");
        textArea.setFont(new Font("Serif",Font.ITALIC,20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        panel.add(label);
        panel.add(meter);
        add(panel,"North");
        add(scrollPane,"Center");
        add(bill,"South");


    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connect c = new Connect();
            String month = choiceMonth.getSelectedItem();
            textArea.setText("\tReliance Private Limited:\nELECTRICITY BILL GENERATED FOR THE MONTH\n\tOF "+month+",2022\n");

            ResultSet rs = c.s.executeQuery("select * from customer where meter='"+meterNumber+"'");

            if (rs.next()){
                textArea.append("\n     Customer Name   : "+rs.getString("name"));
                textArea.append("\n     Meter Number    : "+rs.getString("meter"));
                textArea.append("\n     Address         : "+rs.getString("address"));
                textArea.append("\n     State           : "+rs.getString("state"));
                textArea.append("\n     City            : "+rs.getString("city"));
                textArea.append("\n     Email           : "+rs.getString("email"));
                textArea.append("\n     Phone           : "+rs.getString("phone"));
                textArea.append("\n --------------------------------------------------------    ");
                textArea.append("\n");
            }
            rs = c.s.executeQuery("select * from meterInfo where meter_no='"+meterNumber+"'");

            if (rs.next()){
                textArea.append("\n     Meter Location  : "+rs.getString("meter_loc"));
                textArea.append("\n     Meter Type      : "+rs.getString("meter_type"));
                textArea.append("\n     Code Type       : "+rs.getString("code_type"));
                textArea.append("\n     Bill Type       : "+rs.getString("bill_type"));
                textArea.append("\n     Days            : "+rs.getString("days_type"));
                textArea.append("\n --------------------------------------------------------    ");

            }
            rs = c.s.executeQuery("select * from tax");

            if (rs.next()){
                textArea.append("\n");
                textArea.append("\n     Cost Per Unit   : "+rs.getString("cost_per_unit"));
                textArea.append("\n     Meter Rent      : "+rs.getString("meter_rent"));
                textArea.append("\n     Service Charge  : "+rs.getString("service_charge"));
                textArea.append("\n     Service Tax     : "+rs.getString("service_tax"));
                textArea.append("\n     Swachh Bharat Cess     : "+rs.getString("swach_bharar_cess"));
                textArea.append("\n     Fixed Tax       : "+rs.getString("fixed_tax"));
                textArea.append("\n --------------------------------------------------------    ");

            }

            rs = c.s.executeQuery("select * from bill where meter_no='"+meterNumber+"' and bill_month='"+choiceMonth+"'");

            if (rs.next()){
                textArea.append("\n");
                textArea.append("\n     Current Month   : "+rs.getString("bill_month"));
                textArea.append("\n     Units        : "+rs.getString("units"));
                textArea.append("\n     Total Charges   : "+rs.getString("total_bill"));
                textArea.append("\n --------------------------------------------------------    ");
                textArea.append("\n     Total PayAble Bill     : "+rs.getString("total_bill"));


            }


        }catch (Exception exception){
            exception.printStackTrace();

        }

    }


    public static void main(String[] args) {
        new GenerateReceipt("");

    }


}
