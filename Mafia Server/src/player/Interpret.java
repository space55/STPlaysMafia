/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package player;

import game.MessageManager;

public class Interpret
{
	public static void run(String s, Player parent)
	{
		String args = s.substring(s.indexOf(" ") + 1);
		if (s.startsWith("MESSAGE"))
		{
			MessageManager.add(parent.getUsername() + ": " + args);
		}
		else if (s.startsWith("USERNAME"))
		{
			parent.setUsername(args);
		}
		else if (s.startsWith("ACTIONON"))
		{
			PlayerManager.get(args).performAction(parent.getRole(), parent);
			parent.confirm();
		}
	}
}
