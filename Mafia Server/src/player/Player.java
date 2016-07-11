package player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

public class Player implements Runnable
{
	private Socket s;
	private Role role;
	private boolean alive = true;
	private String username;
	private boolean invuln = false;
	private boolean toDie = false;
	private boolean confirmed = true;

	public int votes;

	private PrintWriter out;
	private BufferedReader in;

	private Thread t;

	public Player(Socket s)
	{
		this.s = s;
		init();
	}

	public void init()
	{
		t = new Thread(this);
		t.start();
		try
		{
			out = new PrintWriter(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		send("GETUNAME");
	}

	public void send(String s)
	{
		out.println(s);
		out.flush();
	}

	public String read()
	{
		try
		{
			return in.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while (true)
		{
			String temp = read();
			if (temp != null && !temp.equals(""))
			{
				Interpret.run(temp, this);
			}

		}
	}

	public void night()
	{
		if (role != Role.SPECTATOR && role != Role.INNOCENT)
		{
			confirmed = false;
			send("WHOACTION");
		}
	}

	public void day()
	{
		if (toDie)
		{
			if (!invuln)
			{
				kill();
			}
		}
		invuln = false;
		toDie = !alive;
	}

	public void performAction(Role role, Player parent)
	{
		switch (role)
		{
		case MAFIA:
			votes++;
			break;
		case SERIAL_KILLER:
			toDie();
			break;
		case DOCTOR:
			invuln = true;
			break;
		case INVESTIGATOR:
			parent.send("INVESTIGATED " + username + " "
					+ (this.role == Role.MAFIA || this.role == Role.SERIAL_KILLER ? "TRUE" : "FALSE"));
		case OLD_MAN:
			toDie();
			int temp = PlayerManager.indexOf(this);
			int s = PlayerManager.players.size() - 1;
			PlayerManager.get((temp != s) ? temp + 1 : 0).toDie();
			PlayerManager.get((temp != 0) ? temp - 1 : s).toDie();
		default:
			break;

		}
	}

	public void reset()
	{
		alive = true;
		toDie = false;
		role = null;
		invuln = false;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
		send("ROLE " + role.toString());
	}

	public String getUsername()
	{
		return username;
	}

	public boolean alive()
	{
		return alive;
	}

	public void setUsername(String u)
	{
		username = u;
	}

	public void sendRole()
	{
		send("ROLE " + role.toString());
	}

	public void kill()
	{
		send("KILLED");
		alive = false;
	}

	public void toDie(boolean toDie)
	{
		this.toDie = toDie;
	}

	public void toDie()
	{
		toDie(true);
	}

	public void smite()
	{
		kill();
	}

	public void confirm()
	{
		confirmed = true;
	}

	public boolean isConfirmed()
	{
		return confirmed;
	}
}
