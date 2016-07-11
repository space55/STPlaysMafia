/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

import game.Player;

public class Interpret
{
	public static void run(String msg)
	{
		String args = msg.substring(msg.indexOf(" ") + 1);
		if (msg.startsWith("MESSAGE"))
		{
			Client.messages.add(args);
		}
		else if (msg.startsWith("WHOACTION"))
		{

		}
		else if (msg.equals("KILLED"))
		{
			Player.kill();
		}
	}
}
