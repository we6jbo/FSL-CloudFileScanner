package GUI;

import org.jibble.pircbot.*;

import java.net.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class GUI extends PircBot implements Runnable{
	Thread theGUI;
  	Socket socket;
   JFrame frame;// = new JFrame("FSL - Cloud File Scanner");	
  
  
  	public GUI(String platform)
   {
     frame = new JFrame("FSL - Cloud File Scanner");
     StartIRCcmd("----"); 
   }
  	public void StartIRCcmd(String platform)
   {
	  try
     {
		 this.setName("sfsfqwe");
       setVerbose(false);
       connect("irc.mibbit.com");
       joinChannel("#we6jbo");
     }
     catch (Exception e)
     {
       say.Say.debug("----", e.toString());
     }
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
   public void onMessage(String channel, String sender, String login, String hostname, String message)
   {
     sendMessage("#we6jbo",message);
     System.out.println(message);
     say.Say.debug("----", message);
     if (message.equals("Vanish"))
     {
       sendMessage("#we6jbo", "Boo!");
       frame.setVisible(false);
     }
   }
  public void run()
    {
    //JFrame frame = new JFrame("FSL - Cloud File Scanner");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JProgressBar progressBar = new JProgressBar();
    progressBar.setValue(5);
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Updating");
    progressBar.setBorder(border);
    frame.add(progressBar);
    frame.setSize(300,100);
    frame.setVisible(true);
  }
}



