package conn;

import java.io.*;
import java.net.*;

public class Conn {

  String line;
  String channel;
  BufferedWriter writer;
  BufferedReader reader;
  public Conn()
  {
    try
      {
     System.out.println("This actually does run.");

      //GUI gui = new GUI();
      GUI.GUI gui = new GUI.GUI("----");
      
      String server = "irc.mibbit.net";
     String nick = "we6jbo-9";
     String login = "we6jbo-9";
    
     channel = "#we6jbo";
     
     Socket socket = new Socket(server, 6667);
     writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
     reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
    writer.write("NICK " + nick + "\r\n");
    writer.write("USER " + login + " 8 * : Java IRC client\r\n");
    writer.flush();
      System.out.println("And it does get down to here");
    
    line = null;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
      if (line.toLowerCase().startsWith("ping ")) {
        System.out.println("POOOOONG!!!! IT G.");
        writer.write("PONG " + line.substring(5) + "\r\n");
        writer.flush();
      }
      if (line.indexOf("004") >= 0) {
        //were logged in
        break;
      }
      else if (line.indexOf("433") >= 0) {
        System.out.println("Errr");
        return;
      }
    }
    //joining
    writer.write("JOIN " + channel + "\r\n");
    writer.flush();
    
    while ((line = reader.readLine()) != null) {
      if (line.toLowerCase().startsWith("ping ")) {
        writer.write("PONG " + line.substring(5) + "\r\n");
        writer.write("PRIVMSG #we6jbo :pinged!\r\n");
        writer.flush();
      }
      else if ((line.toLowerCase().endsWith("upgrade")))
        {
        gui.UpgradeMe();
      }
      else {
        System.out.println(line);
      }
    }
    }
    catch(Exception e)
      {
      System.out.println("Cras");
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