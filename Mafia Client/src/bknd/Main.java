/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

public class Main
{
	public static Client c;

	public static void main(String[] args)
	{
		Connection.init();
		c = new Client();
		c.run();
	}

	public static void run()
	{
		c.startGame();
	}

	public static void startGame()
	{
		// Meh
	}
}
