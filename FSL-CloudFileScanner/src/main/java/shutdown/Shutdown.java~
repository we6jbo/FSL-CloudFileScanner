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
package shutdown;

/**
 *
 * @author Jeremiah ONeal <joneal@nuaitp.net>
 */
public class Shutdown {
    public Shutdown()
    {
        lfShutdown();
    }
    public void lfShutdown()
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            ircservice.Ircservice ircserv = new ircservice.Ircservice();
            public void run()
            {
                ircserv.SendMessage("Shutdown hook.");
                say.Say.debug("----", "Running add shutdown hook");
            }
        });
        say.Say.debug("----", "Quitting IRC");
    }
}
