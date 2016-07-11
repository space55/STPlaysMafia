/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

import java.io.IOException;
import java.net.ServerSocket;

import player.PlayerManager;

public class ServerListener implements Runnable
{
	private ServerSocket s;
	private Thread t;

	public void init()
	{
		try
		{
			s = new ServerSocket(9001);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		while (true)
		{
			try
			{
				PlayerManager.add(s.accept());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
