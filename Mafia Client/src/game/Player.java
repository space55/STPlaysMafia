/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

import bknd.Client;

public class Player
{
	private static int score = 0;
	private static Role role;
	private static boolean alive;

	public static void day()
	{
		Client.showDeathMessage();
		Client.setButtonBackground(0);
	}

	public static void night()
	{
		Client.setButtonBackground(1);
	}

	public static void pick()
	{
		if (alive)
		{
			switch (role)
			{
			case INNOCENT:
				break;
			case MAFIA:
				break;
			case DOCTOR:
				break;
			case INVESTIGATOR:
				break;
			case SERIAL_KILLER:
				break;
			case OLD_MAN:
				break;
			case SPECTATOR:
				break;
			default:
				break;
			}

		}
		// Picking stuff goes here
	}

	public static void win(Role role)
	{
		if (Player.role == role)
		{
			score++;
		}
	}

	public static int getScore()
	{
		return score;
	}

	public static boolean alive()
	{
		return alive;
	}

	public static void kill()
	{
		alive = false;
	}
}
