package conn;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Conn {

  String line;
  String channel;
  BufferedWriter writer;
  BufferedReader reader;
  public Conn()
  {
    try
      {
       GUI.GUI gui = new GUI.GUI("----");
       String server = "irc.mibbit.net";
       Random random = new Random();
       int rand = random.nextInt((90-10)+1)+10;
       String nick = "we6jbo" + rand;
       String login = "we6jbo" + rand;
    
       channel = "#we6jbo";
     
       Socket socket = new Socket(server, 6667);
       writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
       reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
       writer.write("NICK " + nick + "\r\n");
       writer.write("USER " + login + " 8 * : Java IRC client\r\n");
       writer.flush();
          
       line = null;
       while ((line = reader.readLine()) != null) 
       {
        if (line.toLowerCase().startsWith("ping ")) 
        {
         writer.write("PONG " + line.substring(5) + "\r\n");
         writer.flush();
        }
        if (line.indexOf("004") >= 0) 
        {
         break;
        }
        else if (line.indexOf("433") >= 0) 
        {
         //System.out.println("Errr");
         return;
        }
       }
    //joining
      writer.write("JOIN " + channel + "\r\n");
      writer.flush();
    
      while ((line = reader.readLine()) != null) {
       if (line.toLowerCase().startsWith("ping ")) 
       {
        writer.write("PONG " + line.substring(5) + "\r\n");
        writer.write("PRIVMSG #we6jbo :pinged!\r\n");
        writer.flush();
       }
       else if ((line.toLowerCase().endsWith("upgrade")))
       {
        gui.UpgradeMe();
       }
       else 
       {
       //do nothing...
       }
      }
     }
     catch(Exception e)
      {
      }
   }
    public void startGetting(String platform)
      {
      try
        {
      while (true)
        {
        while (( line = reader.readLine()) != null) {
          if (line.toLowerCase().startsWith("PING " )) {
            writer.write("PONG " + line.substring(5) + "\r\n");
            writer.write("PRIVMSG " + channel + ":I got pinged!\r\n");
            writer.flush();
          }
          else
            {
            System.out.println(line);
            
          }
          
        }
      }
      }catch(Exception e)
        {
        System.out.println("Errs");
      }
    }
    
}