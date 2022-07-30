package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static void main(String[] args) throws IOException {

     ServerSocket doorsocket = new ServerSocket(6666);
     while(true)
     {
     Socket connectionsocket = doorsocket.accept();
     
     InputStreamReader ISR = new InputStreamReader(connectionsocket.getInputStream());
     BufferedReader infromclient = new BufferedReader(ISR);
     
     String day1 = infromclient.readLine();
     String month = infromclient.readLine();
     
     int day= parseInt(day1);
     
     String sign="";
         
     switch(month)
     {
        case "January":
         if (day < 20)
            sign = "Capricorn";
         else
            sign = "Aquarius";
        break;
        
        case "February":
         if (day < 19)
            sign = "Aquarius";
         else
            sign = "Pisces"; 
         break;
         
        case "March":
         if (day < 21)
            sign = "Pisces";
         else
            sign = "Aries";
        break;
        
        case "April":
         if (day < 20)
            sign = "Aries";
         else
            sign = "Taurus";
        break;
        
         case "May":
         if (day < 21)
            sign = "Taurus";
         else
            sign = "Gemini";
        break;
        
         case "June":
         if (day < 21)
            sign = "Gemini";
         else
            sign = "Cancer";
        break;
        
        case "July":
         if (day < 23)
            sign = "Cancer";
         else
            sign = "Leo";
        break;
        
        case "August":
         if (day < 23)
            sign = "Leo";
         else
            sign = "Virgo";
        break;
        
        case "September":
         if (day < 23)
            sign = "Virgo";
         else
            sign = "Libra";
        break;
        
        case "October":
         if (day < 23)
            sign = "Libra";
         else
            sign = "Scorpio";
        break;
        
        case "November":
         if (day < 22)
            sign = "scorpio";
         else
            sign = "Sagittarius";
        break;
        
        case "December":
         if (day < 22)
            sign = "Sagittarius";
         else
            sign ="Capricorn";
        break;
    }
        
     DataOutputStream OutToClient = new DataOutputStream(connectionsocket.getOutputStream());
     OutToClient.writeBytes(sign+"\n");
     }
   
}
}