package GUI;

import org.jibble.pircbot.*;

import java.net.*;
import javax.swing.*;
//import javax.swing.BorderFactory;
//import javax.swing.JFrame;
//import javax.swing.JProgressBar;
import javax.swing.border.Border;
import java.awt.FlowLayout;

public class GUI extends PircBot implements Runnable{
	Thread theGUI;
  	Socket socket;
   JFrame frame;// = new JFrame("FSL - Cloud File Scanner");	
   JButton button;
   JProgressBar progressBar;
  
  
  	public GUI(String platform)
   {
     frame = new JFrame("FSL - Cloud File Scanner");
     button = new JButton();
     progressBar = new JProgressBar();
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
     if (message.equals("Upgrade"))
     {
       sendMessage("#we6jbo", "Upgrading!");
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
       }
       progressBar.setValue(100);
       button.setEnabled(true);
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
    Border border = BorderFactory.createTitledBorder("Downloading");
    progressBar.setBorder(border);
    panel.add(progressBar);
    panel.add(button);
    button.setEnabled(false);
    frame.add(panel);
    //frame.add(progressBar);
    frame.setSize(300,100);
    frame.setVisible(true);
  }
}



