package electricity.billing.system;
/**
 *
 * @author Saurabh.dixit
 */
import javax.swing.*;
import java.awt.*;

public class SplashWin extends JFrame implements Runnable {
    Thread t;
    SplashWin(){
         
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image image2 =image1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        add(image);
        setVisible(true);
        
        int x =1;
        for(int imageShow=2;imageShow<450;imageShow+=4, x+=1){
             setSize(imageShow+x,imageShow);
             setLocation(700-((imageShow+x)/2),400-(imageShow/2));
             try{
                Thread.sleep(8);
            }
             catch (Exception e){
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start();
        setVisible(true);
    }
        public void run(){
            try{
                Thread.sleep(7000);
                setVisible(false);
                new Login();
                new Signup();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    public static void main(String[] args){
        new SplashWin();
    }
}
