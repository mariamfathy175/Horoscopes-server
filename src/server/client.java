package server;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class client extends JFrame {
    
    public client(){
    JPanel pane1;
    JLabel l;
    
    pane1 = new JPanel();
    ImageIcon image = new ImageIcon("this pc\\Documents\\NetBeansProjects\\Server\\src\\icons\\Horoscopes.jpg");
    Image i = image.getImage();
    Image modified =i.getScaledInstance(2500, 1000, java.awt.Image.SCALE_SMOOTH);
    image= new ImageIcon(modified);
    l = new JLabel(image);
    
    l.add(pane1);
    this.add(l);
}
   public static void main(String[] args) throws IOException {
       
   Socket connectionsocket = new Socket("localhost",6666);
   
   InputStreamReader ISR = new InputStreamReader(System.in);
   BufferedReader infromuser = new BufferedReader(ISR);
   String day = infromuser.readLine();
   
   InputStreamReader ISR3 = new InputStreamReader(System.in);
   BufferedReader infromuser2 = new BufferedReader(ISR3);
   String month = infromuser2.readLine();

   DataOutputStream OutToServer = new DataOutputStream(connectionsocket.getOutputStream());
   OutToServer.writeBytes(day + '\n'); 
   
   DataOutputStream OutToServer2 = new DataOutputStream(connectionsocket.getOutputStream());
   OutToServer2.writeBytes(month + '\n');
   
   InputStreamReader ISR2 = new InputStreamReader(connectionsocket.getInputStream());
   BufferedReader infromserver = new BufferedReader(ISR2);
   String sign = infromserver.readLine(); 
   
   System.out.println("From srver:" + sign);
    
}
}
