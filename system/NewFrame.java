
package electricity.billing.system;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class NewFrame extends JFrame implements ActionListener {
    
String userType,meterUse;
    NewFrame(String userType,String meterUse){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.meterUse= meterUse;
        this.userType =userType;
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        ImageIcon image =new ImageIcon(ClassLoader.getSystemResource("icon/frame.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon mainImage  = new ImageIcon(scaledImage);
        JLabel finalImage = new JLabel(mainImage);
        add(finalImage);
        
        
//        MenuBar with items
       
         
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBorder(new LineBorder(Color.BLACK,4));
        menuBar.setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        setBounds(30,20,200,30);

        JMenu menu = new JMenu("MASTER");
        menu.setFont(new Font("SERIF",Font.BOLD,18));
        menu.setForeground(Color.BLACK);
        menu.setBorder(new LineBorder(Color.WHITE,2));
        menu.setBounds(40,0,250,40);
      
        
           

//        New Customer

        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("serif",Font.ITALIC,14));
        newCustomer.setBackground(Color.WHITE);
        ImageIcon imageForCreate = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image imageCreate = imageForCreate.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageCreate = new ImageIcon(imageCreate);
        newCustomer.setIcon(finalImageCreate);
        newCustomer.setMnemonic('D');
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);
    
//        Customer details
    
    
        JMenuItem customerDetail = new JMenuItem("Customer Details");
        customerDetail.setFont(new Font("serif",Font.ITALIC,14));
        customerDetail.setBackground(Color.WHITE);
        ImageIcon imageForCustoerDetails = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image imageCreateDetaails = imageForCustoerDetails.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageCustomer = new ImageIcon(imageCreateDetaails);
        customerDetail.setIcon(finalImageCustomer);
        customerDetail.setMnemonic('M');
        customerDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        customerDetail.addActionListener(this);
        menu.add(customerDetail);
        
//        Deposite Details
 
        JMenuItem depositeDetail = new JMenuItem("Deposit Details");
        depositeDetail.setFont(new Font("serif",Font.ITALIC,14));
        depositeDetail.setBackground(Color.WHITE);
        ImageIcon imageForDepositeDetails = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image imageDepositeDetaails = imageForDepositeDetails.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageDeposite = new ImageIcon(imageDepositeDetaails);
        depositeDetail.setIcon(finalImageDeposite);
        depositeDetail.setMnemonic('S');
        depositeDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        depositeDetail.addActionListener(this);
        menu.add(depositeDetail);
        
//       Total Calculate Bill

        JMenuItem calculeBill = new JMenuItem("Calculate-Bill");
        calculeBill.setFont(new Font("serif",Font.ITALIC,14));
        calculeBill.setBackground(Color.WHITE);
        ImageIcon imageForCalBill = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image imageCalculate = imageForCalBill.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageCalculate = new ImageIcon(imageCalculate);
        calculeBill.setIcon(finalImageCalculate);
        calculeBill.setMnemonic('K');
        calculeBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        calculeBill.addActionListener(this);
        menu.add(calculeBill);
        
//       Information menu And Items
    
        JMenu info = new JMenu("INFORMATION");
        info.setFont(new Font("SERIF",Font.BOLD,16));
        info.setForeground(Color.BLUE);
        info.setBorder(new LineBorder(Color.WHITE,2));
        info.setBounds(70,0,250,40);
        
        
        
//       Update Information item 

        JMenuItem updateInfo = new JMenuItem("Update Information");
        updateInfo.setFont(new Font("serif",Font.ITALIC,14));
        updateInfo.setBackground(Color.WHITE);
        ImageIcon imageForInfo = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image imageForInfoNew = imageForInfo.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageInfo = new ImageIcon(imageForInfoNew);
        updateInfo.setIcon(finalImageInfo);
        updateInfo.setMnemonic('A');
        updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        updateInfo.addActionListener(this);
        info.add(updateInfo);
        
        
//       Update Information item 

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("serif",Font.ITALIC,14));
        viewInfo.setBackground(Color.WHITE);
        ImageIcon imageForViewInfo = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image imageForIViewforNew = imageForViewInfo.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageViewInfo = new ImageIcon(imageForIViewforNew);
        viewInfo.setIcon(finalImageViewInfo);
        viewInfo.setMnemonic('B');
        viewInfo.addActionListener(this);
        viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        info.add(viewInfo);
        
        
//        User Info Menu
 
        JMenu user = new JMenu("USER");
        user.setFont(new Font("SERIF",Font.BOLD,16));
        user.setForeground(Color.RED);
        user.setBorder(new LineBorder(Color.WHITE,2));
        user.setBounds(90,0,250,40);
       
        
//       PayBill Item

        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("serif",Font.ITALIC,14));
        payBill.setBackground(Color.WHITE);
        ImageIcon imageForPay = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image imageForPayBill = imageForPay.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageBillPay = new ImageIcon(imageForPayBill);
        payBill.setIcon(finalImageBillPay);
        payBill.setMnemonic('T');
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        payBill.addActionListener(this);
        user.add(payBill);
        
        
//       Bill Details item 

        JMenuItem billDetailes = new JMenuItem("Bill Details");
        billDetailes.setFont(new Font("serif",Font.ITALIC,14));
        billDetailes.setBackground(Color.WHITE);
        ImageIcon imageForBillDet = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image imageForBillDetail = imageForBillDet.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageBillDetails= new ImageIcon(imageForBillDetail);
        billDetailes.setIcon(finalImageBillDetails);
        billDetailes.setMnemonic('P');
        billDetailes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        billDetailes.addActionListener(this);
        user.add(billDetailes);
        
        
//       User Info Menu
 
        JMenu report = new JMenu("REPORT");
        report.setFont(new Font("SERIF",Font.BOLD,16));
        report.setBorder(new LineBorder(Color.WHITE,2));
        report.setForeground(Color.BLACK);
        report.setBounds(110,0,250,40);
        
        
//       PayBill Item

        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("serif",Font.ITALIC,14));
        generateBill.setBackground(Color.WHITE);
        ImageIcon imagegenerate = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image imageForgenerate = imagegenerate.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImagegenerte = new ImageIcon(imageForgenerate);
        generateBill.setIcon(finalImagegenerte);
        generateBill.setMnemonic('G');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        generateBill.addActionListener(this);
        report.add(generateBill);
        
//        Utility menu
        JMenu utility = new JMenu("UTILITY");
        utility.setFont(new Font("SERIF",Font.BOLD,16));
        utility.setForeground(Color.BLUE);
        utility.setBorder(new LineBorder(Color.WHITE,2));
        utility.setBounds(130,0,250,40);
       
        
//       NotePad Item 

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("serif",Font.ITALIC,14));
        notepad.setBackground(Color.WHITE);
        ImageIcon imageForNotepad = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image imageForNote = imageForNotepad.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImageNotePad= new ImageIcon(imageForNote);
        notepad.setIcon(finalImageNotePad);
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        notepad.addActionListener(this);
        utility.add(notepad);
        
                       
//       Calcultor Items

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("serif",Font.ITALIC,14));
        calculator.setBackground(Color.WHITE);
        ImageIcon imageForcalculator = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image imageForCalculator = imageForcalculator.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalImagecalculator= new ImageIcon(imageForCalculator);
        calculator.setIcon(finalImagecalculator);
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        calculator.addActionListener(this);
        utility.add(calculator);
        
//          Exit Menu

        JMenu exit = new JMenu("EXIT");
        exit.setFont(new Font("SERIF",Font.BOLD,16));
        exit.setForeground(Color.RED);
        exit.setBorder(new LineBorder(Color.WHITE,2));
        exit.setBounds(150,0,250,40);
       
        
//       Exit Item 

        JMenuItem Exit = new JMenuItem("Close");
        Exit.setFont(new Font("serif",Font.ITALIC,14));
        Exit.setBackground(Color.WHITE);
        ImageIcon imageForExit = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image imageExit = imageForExit.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finalimageExit= new ImageIcon(imageExit);
        Exit.setIcon(finalimageExit);
        Exit.setMnemonic('E');
        Exit.addActionListener(this);
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exit.add(Exit);

//        For Contact And Feedback

        JMenu contact = new JMenu("FEEDBACK");
        contact.setFont(new Font("SERIF",Font.BOLD,16));
        contact.setForeground(Color.BLACK);
        contact.setBorder(new LineBorder(Color.WHITE,2));
        //contact.setMenuLocation(100,0);
        contact.addActionListener(this);

        JMenuItem contactForm = new JMenuItem("Client Form");
        contactForm.setFont(new Font("serif",Font.ITALIC,14));
        contactForm.setBackground(Color.WHITE);
        ImageIcon contactImage =  new ImageIcon(ClassLoader.getSystemResource("icon/contact.jpg"));
        Image imageContact = contactImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon imageContactForm = new ImageIcon(imageContact);
        contactForm.setIcon(imageContactForm);
        contactForm.setMnemonic('K');
        contactForm.addActionListener(this);
        contactForm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        contact.add(contactForm);







        
//        Main Menus

        if(userType.equals("Admin")){
             menuBar.add(menu);
        }else{
            menuBar.add(info);
            menuBar.add(user);
            menuBar.add(report);
        }
        menuBar.add(utility);
        menuBar.add(exit);
        menuBar.add(contact);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if(msg.equals("Customer Details")){
             new CustomerDetails();
        }else if(msg.equals("Deposit Details")){
             new DepositDetails();
        }else if(msg.equals("Calculate-Bill")){
            new CalculateBill();
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meterUse) ;
        } else if(msg.equals("Close")){
            setVisible(false);
            new Login();
        }else if(msg.equals("View Information")){
            new ViewInformation(meterUse);
        }else if (msg.equals("Bill Details")){
            new BillDetails(meterUse);
        } else if (msg.equals("Generate Bill")){
            new GenerateReceipt(meterUse);
        } else if (msg.equals("Calculator")) {
            new Calculator();
        } else if (msg.equals("Notepad")) {
            new NotePad();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meterUse);
        }else if (msg.equals("Client Form")){
            new Clientform();
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new NewFrame("","");
    }

   
}
