package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;



public class NotePad extends JFrame implements ActionListener {
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem(" Paste");
    JMenuItem selectAll = new JMenuItem("Select All");

    JMenuItem about = new JMenuItem("About");
    JTextArea textArea = new JTextArea();

    NotePad(){

//        Frame Details With Icon

        setTitle("NotePad App");
        setSize(700,600);
        setLocation(200,100);
        setVisible(true);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image image = imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        this.setIconImage(image);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
//        Inside File menu

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);

//        inside Edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
//        Inside help
        help.add(about);
        add(menuBar);
        setJMenuBar(menuBar);
//        Inside Frame Menu Bar
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("MONOSPACE",Font.BOLD,18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

//        For Action
        newFile.addActionListener(this);
        newFile.setMnemonic('N');
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openFile.addActionListener(this);
        openFile.setMnemonic('O');
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFile.addActionListener(this);
        saveFile.setMnemonic('S');
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        print.setMnemonic('P');
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        exit.setMnemonic('E');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        cut.addActionListener(this);
        cut.setMnemonic('X');
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        copy.setMnemonic('C');
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        paste.setMnemonic('V');
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        selectAll.addActionListener(this);
        selectAll.setMnemonic('A');
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        about.addActionListener(this);
        about.setMnemonic('I');
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));



    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);
        }else if (e.getActionCommand().equalsIgnoreCase("Open")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showSaveDialog(null);
            if (action!=JFileChooser.APPROVE_OPTION) {
                return;
            }else {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(bufferedReader,null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }else if (e.getActionCommand().equalsIgnoreCase("Save")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showSaveDialog(null);
            if (action!=JFileChooser.APPROVE_OPTION){
                return;
            }else {
                String fileName =fileChooser.getSelectedFile().getAbsolutePath().toString();

                 if (fileName.contains(".txt")){
                    fileName = fileName+".txt";

                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                        textArea.write(bufferedWriter);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }else if (e.getActionCommand().equalsIgnoreCase("Print")){
            try {
                textArea.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }else if (e.getActionCommand().equalsIgnoreCase("Exit")){
           System.exit(0);
        }else if (e.getActionCommand().equalsIgnoreCase("Cut")){
            textArea.cut();
        }else if (e.getActionCommand().equalsIgnoreCase("Copy")){
            textArea.copy();
        }else if (e.getActionCommand().equalsIgnoreCase("Paste")){
            textArea.paste();
        }else if (e.getActionCommand().equalsIgnoreCase("Select All")){
            textArea.selectAll();
        }else {
            new About().setVisible(true);
        }
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotePad();
    }
}
