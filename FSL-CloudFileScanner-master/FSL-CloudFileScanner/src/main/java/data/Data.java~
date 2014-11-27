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
package data;

/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
public class Data {
    public static String name = "";
    public static String[] compareLocal = new String[10];
    public static int fileLines = 10;
    public static String connectionport = "2481";
    
    public Data(String platform)
    {
        for (int i = 0; i <= (data.Data.compareLocal.length - 1); i++)
        {
            compareLocal[i] = "";
        }
    }    
    public static int compareLocaltoRemote(String platform, int x, int y)
    {       
        if (x<=0 || x >= data.Data.fileLines || y <= 0 || y >= data.Data.fileLines)
        {
            return 0;
        }
        try
        {
            if(compareLocal[x].equals(filemanager.Filemanager.fileArray[y]))
            {
                return 0;
            }
        }
        catch(NullPointerException e)
        {
            say.Say.error("----", e.toString());
        }
        return 1;
    }
    public static void save()
    {
        filemanager.Filemanager.save();
    }
}

