package GUI;

import org.schwering.irc.lib.*;
import org.schwering.irc.lib.ssl.*;

import org.schwering.irc.lib.IRCEventListener;

import java.util.EventListener;

import java.net.*;
import javax.swing.*;

import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import java.awt.FlowLayout;

// Sample source code: http://moepii.sourceforge.net/irclib/Client.java

public class GUI extends Thread implements Runnable{
	Thread theGUI;
  	Socket socket;
   
   IRCConnection conn;
   JFrame frame;// = new JFrame("FSL - Cloud File Scanner");	
   JButton button;
   JProgressBar progressBar;
  
  
  	public GUI(String platform)
   {
     frame = new JFrame("FSL - Cloud File Scanner");
     button = new JButton();
     progressBar = new JProgressBar();
    // StartIRCcmd("----"); 
   //}
  	//public StartIRCcmd(String platform)
   //{
	  
                            //     Host         Port  Pass Nick User Name
     try
     {
     conn = new IRCConnection("irc.mibbit.net",6667,6669,null,"we6jbo-9","Jeremiah ONeal","we6jbo@gmail.com");
     say.Say.debug("----","Doing the listening thing");
     conn.addIRCEventListener(new Listener());
       say.Say.debug("----","ok...");
       conn.setEncoding("UTF-8");
       conn.setDaemon(true);
       conn.setColors(false);
       conn.setPong(true);
      say.Say.debug("----","Ready for the connect");
      conn.connect();
       say.Say.debug("----","Past it");
     }catch (IOException e)
       {
       say.Say.debug("----", e.toString());
     }
     
     say.Say.debug("----","And then...on");
     //StartIRCcmds("----");
     StartIRCcmd("----");
     say.Say.debug("----","umm humm...");
   }
  public void StartIRCcmd(String platform)
    {
     say.Say.debug("----", "In IRC section.");
     //try
     //{
       //conn.connect();
       conn.send("/join #we6jbo");
     //}
     //catch (IOException e)
     //{
       //say.Say.debug("----", e.toString());
     //}
     try
     {
       Thread.sleep(5000);
       theGUI = new Thread(this, "GUI for this program");
       theGUI.start();
     }
     catch (InterruptedException e)
     {
     }
   }
  public void run()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    
    //JButton button = new JButton();
    button.setText("Upgrade");
    
    //JProgressBar progressBar = new JProgressBar();
    progressBar.setValue(5);
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Downloading.");
    progressBar.setBorder(border);
    panel.add(progressBar);
    panel.add(button);
    button.setEnabled(false);
    frame.add(panel);
    //frame.add(progressBar);
    frame.setSize(300,100);
    frame.setVisible(true);
  }

   public class Listener implements IRCEventListener {  
     public void onRegistered(){say.Say.debug("----","Connected");}
     public void onDisconnected(){say.Say.debug("----","Disconnected");}
     public void onError(String msg){say.Say.debug("----",msg);}
     public void onError(int num, String msg){say.Say.debug("----",num + ": " + msg);}
     public void onInvite(String chan, IRCUser u, String nickPass){say.Say.debug("----",chan + u.getNick() + nickPass);}
     public void onJoin(String chan, IRCUser u){say.Say.debug("----",chan + u.getNick());}
     public void onKick(String chan, IRCUser u, String nickPass, String msg){say.Say.debug("----",chan + u.getNick() + nickPass);}
     public void onMode(IRCUser u, String nickPass, String mode){say.Say.debug("----",u.getNick() + mode + nickPass);}
     public void onMode(String chan, IRCUser u, IRCModeParser mp){say.Say.debug("----",chan + u.getNick() + mp.getLine());}
     public void onNick(IRCUser u, String nickNew){say.Say.debug("----",u.getNick() + nickNew);}
     public void onNotice(String target, IRCUser u, String msg){
       //say.Say.debug("----",target + u.getNick() + msg);
       }
     public void onPart(String chan, IRCUser u, String msg){say.Say.debug("----",chan + u.getNick());}
       
     public void onPrivmsg(String chan, IRCUser user, String message) {
         //say.Say.debug("----",message);
         if (message.equals("Upgrade"))
           {
say.Say.debug("---","Upgrading...");
                      frame.setVisible(true);
           button.setEnabled(false);
           for (int i = 10; i < 100; i = i + 15)
             {
             try
               {
               Thread.sleep(5000);
               progressBar.setValue(i);
             }
             catch (InterruptedException e)
               {
             }
             progressBar.setValue(100);
             button.setEnabled(true);
            say.Say.debug("----","Done with that");
             
           }
         }
       }
     public void onQuit(IRCUser u, String msg){say.Say.debug("----",u.getNick());}
     public void onReply(int num, String value, String msg){
       //say.Say.debug("----",num + value + msg);
       }
     public void onTopic(String chan, IRCUser u, String topic){say.Say.debug("----",chan + u.getNick() + topic);}
     public void onPing(String p){say.Say.debug("----",p);}
     public void unknown(String a, String b, String c, String d){say.Say.debug("----",a + b + c + d);}
   }
}

