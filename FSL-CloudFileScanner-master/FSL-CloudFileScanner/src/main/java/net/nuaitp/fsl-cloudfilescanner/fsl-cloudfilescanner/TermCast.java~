/*
 * Copyright (C) 2013 Jeremiah ONeal <joneal@nuaitp.net>
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
package net.nuaitp.we6jboisfreesl.we6jboisfreesl;

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
        Properties properties = new Properties();
        try
        {
            properties.load(new FileInputStream("We6jboisFreeSL.ini"));
        }
        catch(IOException e)
        {
            say.Say.debug("----", e.toString());
        }
        new filemanager.Filemanager("termcast");
        new data.Data("termcast");
        new controller.Controller("---", "we6jbo.synchro.net", 25);
        new shutdown.Shutdown();
        try
        {
            ircservice.Ircservice ircserv = new ircservice.Ircservice();
            ircserv.setVerbose(false);
            ircserv.connect("irc.starlink-irc.org");
            ircserv.joinChannel("#family_tree");
            ircserv.SendMessage("Test.");
            new receiver.Receiver("----");
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