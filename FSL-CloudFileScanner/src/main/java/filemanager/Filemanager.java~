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
package filemanager;

import java.io.*;
import java.net.*;
/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
public class Filemanager implements Runnable{
    Thread FileManagerThread;
    public static String[] fileArray = new String[10];
    public Filemanager(String platform)
    {
        StartFilemanager("----");
    }
    public void StartFilemanager(String platform)
    {
        FileManagerThread = new Thread(this, "File Manager Thread");
        FileManagerThread.start();   
    }
    public void run()
    {
        BufferedReader in;
        try
        {
            Thread.sleep(1500);
            in = new BufferedReader(new FileReader("database.txt"));
            String str;
            for(int i = 0; i <= data.Data.fileLines - 1; i++)
            {
                if ((str = in.readLine()) != null)
                {
                    filemanager.Filemanager.fileArray[i] = str.toString();
                }
                else
                {
                   filemanager.Filemanager.fileArray[i] = "";
                }
            }
            in.close();
        }
        catch (InterruptedException e)
        {
            say.Say.error("----", e.toString());
        }
        catch (IOException e)
        {
            say.Say.error("----", e.toString());
        }
    }
    public static void save()
    {
        BufferedWriter out;
        try
        {
            out = new BufferedWriter(new FileWriter("database.txt", true));
            out.close();
        }
        catch (IOException e)
        {
            say.Say.error("----", e.toString());
        }
    }
}
