/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

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
		else if (msg.equals("WHOACTION"))
		{
			Main.c.enableVote();
		}
		else if (msg.startsWith("VOTEDON"))
		{
			Server.voted(args);
		}
		else if (msg.equals("STOPVOTE"))
		{
			Main.c.stopVote();
		}
		else if (msg.equals("KILLED"))
		{
			Player.kill();
		}
		else if (msg.startsWith("GETUNAME"))
		{
			Connection.send("USERNAME " + Client.username);
		}
		else if (msg.startsWith("PLAYERKILLED"))
		{
			int i = msg.indexOf("U=") + 2;
			String username = msg.substring(i, msg.indexOf(" ", i));
			Server.kill(username);
		}
		else if (msg.equals("GAMESTART"))
		{
			Main.startGame();
		}
		else if (msg.equals("STARTDAY"))
		{
			Player.day();
		}
		else if (msg.equals("STARTNIGHT"))
		{
			Player.night();
		}
	}
}
