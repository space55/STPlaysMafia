/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

import game.OPlayer;
import game.Player;
import game.Server;

public class Interpret
{
	public static void run(String msg)
	{
		String args = "";
		if (msg.indexOf(" ") != -1)
		{
			args = msg.substring(msg.indexOf(" ") + 1);
		}
		if (msg.startsWith("MESSAGE"))
		{
			Client.messages.add(args);
		}
		else if (msg.startsWith("WHOACTION"))
		{
			OPlayer actionOn = Main.c.getVote();
			Connection.send("ACTIONON " + actionOn.getUsername());
		}
		else if (msg.equals("KILLED"))
		{
			Player.kill();
		}
		else if (msg.startsWith("PLAYERKILLED"))
		{
			int i = msg.indexOf("U=") + 2;
			String username = msg.substring(i, msg.indexOf(" ", i));
			Server.kill(username);
		}
	}
}
