/*
 * Copyright (C) 2014 Jeremiah ONeal <joneal@nuaitp.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.nuaitp.fslcloudfilescanner.fslcloudfilescanner;

import java.io.*;
import java.util.*;

/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
public class TermCast {
    public void main(String args[])
    {
        new gpl20.GPL20("----");  
        
        // Check to see if the properties file exists. If not, create it.
        File chkfpropfle = new File("FSL-CloudFileScanner.ini");
        if (chkfpropfle.exists() && !chkfpropfle.isDirectory())
        {}else
        {}
        Properties properties = new Properties();
        try
        {
            InputStream file = ClassLoader.getSystemResourceAsStream("FSL-CloudFileScanner.ini");
            properties.load(file);
        }
        catch(IOException e)
        {
            say.Say.debug("----", e.toString());
        }
         String tst;
        tst = properties.getProperty("name","Durr");
        say.Say.debug("----",tst);
//        new filemanager.Filemanager("termcast");
//        new data.Data("termcast");
//        new controller.Controller("---", "online.fanciful.org", 25);
        new conn.Conn();
//        new shutdown.Shutdown();
        try
        {
          	//new GUI.GUI("----");
          say.Say.debug("----","Starting the GUI");	
//          GUI.GUI gui = new GUI.GUI("----");
          say.Say.debug("----","Done with the GUI");
//            new receiver.Receiver("----");
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //ircserv.SendMessage(br.readLine().toString());
        }
        catch(Exception e)
        {
            say.Say.debug("----", e.toString());
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            say.Say.debug("----", e.toString());
        } 
    }
}
