/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

import java.util.ArrayList;

import player.PlayerManager;

public class MessageManager
{
	public static ArrayList<String> messages = new ArrayList<String>();

	public static void add(String message)
	{
		messages.add(message);
		PlayerManager.sendMessage(message); // I LIKE TO TEST
	}
}
