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
package ircservice;

/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
import org.jibble.pircbot.*;
import java.util.Random;

public class Ircservice extends PircBot {
    public Ircservice ()
    {
		Random random = new Random();
      int rand = random.nextInt((9000 - 1000) +1 ) + 1000;
      this.setName("fslcfs-" + rand);
    }
    public void SendMessage(String message)
    {
        sendMessage("#we6jbo",message);
    }

}
