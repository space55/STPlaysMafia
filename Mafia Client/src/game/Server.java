/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

import java.util.ArrayList;

public class Server
{
	public static ArrayList<OPlayer> players = new ArrayList<OPlayer>();

	public static void add(OPlayer p)
	{
		players.add(p);
	}

	public static OPlayer get(String username)
	{
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(i).getUsername().equals(username))
			{
				return players.get(i);
			}
		}
		return null;
	}

	public static OPlayer get(int i)
	{
		return players.get(i);
	}

	public static void kill(String username)
	{
		get(username).kill();
	}
}
