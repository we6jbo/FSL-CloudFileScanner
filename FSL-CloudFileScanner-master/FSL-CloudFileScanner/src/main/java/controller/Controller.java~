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
package controller;

import java.net.*;
import java.io.*;
/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
public class Controller implements Runnable{
    Thread connecting;
    Socket sock;
    String saddr;
    int port;
    public Controller(String platform, String baddr, int bport)
    {
        saddr = baddr;
        port = bport;
        StartController("----");
    }
    public void StartController(String platform)
    {
        connecting = new Thread(this, "Makes outgoing connections");
        connecting.start();
    }
    public void run()
    {
        try
        {
            InetAddress addr = InetAddress.getByName(saddr);
            String str;
            Socket sock = new Socket(addr, port);
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            sock.setSoTimeout(5000);
            while(true)
            {
                wr.write("Ok" + "\n");
                wr.flush();
                str = rd.readLine();
                say.Say.info("----", str.toString());
            }
        }
        catch(IOException e)
        {
            say.Say.error("----", e.toString());
        }
    }
}
