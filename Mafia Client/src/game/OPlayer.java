/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

public class OPlayer
{
	private String username;
	private Role role;
	private boolean alive;

	public OPlayer(String username, Role role, boolean alive)
	{
		this.username = username;
		this.role = role;
		this.alive = alive;
	}

	public boolean isAlive()
	{
		return alive;
	}

	public Role getRole()
	{
		return role;
	}

	public String getUsername()
	{
		return username;
	}

	public void kill()
	{
		alive = false;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public void reset()
	{
		role = Role.INNOCENT;
		alive = true;
	}
}
