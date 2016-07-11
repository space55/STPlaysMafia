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
	private static ArrayList<OPlayer> players = new ArrayList<OPlayer>();

	public static void add(OPlayer p)
	{
		players.add(p);
	}

	/**
	 * Get an OPlayer object by username
	 * 
	 * @param username
	 *            Username of player to be found
	 * @return OPlayer object with specified username
	 */
	public static OPlayer get(String username)
	{
		int i = indexOf(username);
		return (i == -1) ? null : players.get(i);
	}

	/**
	 * Gets an OPlayer object by index
	 * 
	 * @param i
	 *            Index of OPlayer
	 * @return OPlayer object at index i
	 */
	public static OPlayer get(int i)
	{
		return players.get(i);
	}

	/**
	 * Gets index of OPlayer by username
	 * 
	 * @param username
	 *            Username of player to be found
	 * @return Index of player
	 */
	public static int indexOf(String username)
	{
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(i).getUsername().equals(username))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Read da fekking method name
	 * 
	 * @param username
	 *            Kills player by username
	 */
	public static void kill(String username)
	{
		get(username).kill();
	}

	/**
	 * Read da fekking method name
	 * 
	 * @param player
	 *            Kills player by OPlayer object
	 */
	public static void kill(OPlayer player)
	{
		player.kill();
	}

	/**
	 * Gets size of all alive players
	 * 
	 * @return Number of all alive players
	 */
	public static int getLiving()
	{
		int s = 0;
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(i).isAlive())
			{
				s++;
			}
		}
		return s;
	}
}
