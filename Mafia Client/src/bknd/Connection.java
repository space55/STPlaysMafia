/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class Connection
{
	public static Socket s;

	private static PrintWriter out;
	private static BufferedReader in;

	public static MessageListener ml;

	public static void init()
	{
		try
		{
			s = new Socket("localhost", 9001);
			out = new PrintWriter(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
		catch (ConnectException e)
		{
			System.exit(1);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ml = new MessageListener();
	}

	public static void send(String msg)
	{
		out.print(msg);
		out.flush();
	}

	public static String read()
	{
		try
		{
			return in.readLine();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
