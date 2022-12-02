
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel meterNumField,lblDaysAuto,lblNoteAuto;
    Choice meterLocation ,meterType,phaseCodeType,BillType;
    JButton submit;
    String meternumber;

    MeterInfo(String meternumber){
        super("Meter Information");
        this.meternumber =meternumber;
        setVisible(true);
        setSize(700,500);
        setLocation(280,140);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        add(panel);


//        Main heading

        JLabel heading = new JLabel("Meter Information");
        heading.setFont(new Font("Serif",Font.BOLD,24));
        heading.setBounds(200,15,200,25);
        heading.setForeground(Color.BLACK);
        panel.add(heading);

//        Information Headings

        JLabel lblMeterNum = new JLabel("Meter Number");
        lblMeterNum.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblMeterNum.setBounds(90,80,150,40);
        lblMeterNum.setForeground(Color.BLACK);
        panel.add(lblMeterNum);

        meterNumField =  new JLabel(meternumber);
        meterNumField.setBounds(250,88,120,20);
        meterNumField.setForeground(Color.BLACK);
        panel.add(meterNumField);


//        Meter Location

        JLabel lblMeterLoc = new JLabel("Meter Location");
        lblMeterLoc.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblMeterLoc.setBounds(90,120,150,40);
        lblMeterLoc.setForeground(Color.BLACK);
        panel.add(lblMeterLoc);

//        Meter Location Choice

        meterLocation = new Choice();
        meterLocation.add("Inside");
        meterLocation.add("Outside");
        meterLocation.setBounds(250,125,150,20);
        meterLocation.setBackground(Color.WHITE);
        meterLocation.setForeground(Color.BLACK);
        meterLocation.setFont(new Font("Serif",Font.ITALIC,16));
        panel.add(meterLocation);

//        Meter Type With Choices

        JLabel lblMeterType= new JLabel("Meter Type");
        lblMeterType.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblMeterType.setBounds(90,160,150,40);
        lblMeterType.setForeground(Color.BLACK);
        panel.add(lblMeterType);

//        Meter Type Choice

        meterType = new Choice();
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        meterType.setBounds(250,165,150,20);
        meterType.setBackground(Color.WHITE);
        meterType.setForeground(Color.BLACK);
        meterType.setFont(new Font("Serif",Font.ITALIC,16));
        panel.add(meterType);

//        Phase Code

        JLabel lblPhaseCode= new JLabel("Phase Code");
        lblPhaseCode.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblPhaseCode.setBounds(90,200,150,40);
        lblPhaseCode.setForeground(Color.BLACK);
        panel.add(lblPhaseCode);

//        Phase Type Choice

        phaseCodeType = new Choice();
        phaseCodeType.add("011");
        phaseCodeType.add("022");
        phaseCodeType.add("033");
        phaseCodeType.add("044");
        phaseCodeType.add("055");
        phaseCodeType.add("066");
        phaseCodeType.add("077");
        phaseCodeType.add("088");
        phaseCodeType.add("099");
        phaseCodeType.setBounds(250,205,150,20);
        phaseCodeType.setBackground(Color.WHITE);
        phaseCodeType.setForeground(Color.BLACK);
        phaseCodeType.setFont(new Font("Serif",Font.ITALIC,16));
        panel.add(phaseCodeType);


//        Bill Type

        JLabel lblBillType= new JLabel("Bill Type");
        lblBillType.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblBillType.setBounds(90,240,150,40);
        lblBillType.setForeground(Color.BLACK);
        panel.add(lblBillType);

//        Phase Type Choice

        BillType = new Choice();
        BillType.add("Normal Meter");
        BillType.add("Industrial Meter");
        BillType.setBounds(250,245,150,20);
        BillType.setBackground(Color.WHITE);
        BillType.setForeground(Color.BLACK);
        BillType.setFont(new Font("Serif",Font.ITALIC,16));
        panel.add(BillType);

//        Days

        JLabel lblDays= new JLabel("Days");
        lblDays.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblDays.setBounds(90,280,150,40);
        lblDays.setForeground(Color.BLACK);
        panel.add(lblDays);

//        Days Auto Label

        lblDaysAuto= new JLabel("30 Days");
        lblDaysAuto.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblDaysAuto.setBounds(250,285,150,40);
        lblDaysAuto.setForeground(Color.BLACK);
        panel.add(lblDaysAuto);

//        Note
        JLabel lblNote= new JLabel("Note*");
        lblNote.setFont(new Font("Monospaced",Font.ITALIC,16));
        lblNote.setBounds(90,320,150,40);
        lblNote.setForeground(Color.BLACK);
        panel.add(lblNote);

//        Note Description

        lblNoteAuto= new JLabel("By Default Bill is Calculate For 30 Days");
        lblNoteAuto.setFont(new Font("Monospaced",Font.ITALIC,12));
        lblNoteAuto.setBounds(250,325,300,40);
        lblNoteAuto.setForeground(Color.BLACK);
        panel.add(lblNoteAuto);

//        Buttons

        submit = new JButton("Submit");
        submit.setBounds(230,380,110,35);
        submit.setFont(new Font("Monospaced",Font.BOLD,15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);
      

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String meterNo = meternumber;
            String meterLoc = meterLocation.getSelectedItem();
            String meterT = meterType.getSelectedItem();
            String codeType = phaseCodeType.getSelectedItem();
            String billT = BillType.getSelectedItem();
            String daysType = "30";
//            For Data Collection in Data Base

            String query = "insert into meterInfo values('" + meterNo + "','" + meterLoc + "','" + meterT + "','" + codeType + "','" + billT + "','" + daysType + "')";

            try {
                Connect c = new Connect();
                c.s.executeUpdate(query);


                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully ");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
        public static void main(String[] args) {
            new MeterInfo("");
        }
    }

