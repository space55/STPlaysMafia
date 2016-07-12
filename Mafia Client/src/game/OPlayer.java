/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package game;

import java.awt.Color;

import javax.swing.JButton;

import bknd.Main;

public class OPlayer
{
	private String username;
	private Role role;
	private boolean alive;
	private JButton button;
	private boolean voted;

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
		Main.c.wasKilled(this);
		disableButton();
	}

	/**
	 * Sets the user's role
	 * 
	 * @param role
	 *            Role of the player to be set
	 */
	public void setRole(Role role)
	{
		this.role = role;
	}

	/**
	 * Resets the OPlayer at the beginning of a new game
	 */
	public void reset()
	{
		role = Role.INNOCENT;
		alive = true;
		enableButton();
	}

	/**
	 * Pauses game, disabling button
	 */
	public void pauseGame()
	{
		disableButton();
	}

	/**
	 * Restarting a game after it has been paused
	 */
	public void restartGame()
	{
		if (alive)
		{
			enableButton();
		}
	}

	/**
	 * Alias for Reset
	 */
	public void startGame()
	{
		reset();
	}

	/**
	 * Vote for this player
	 */
	public void vote()
	{
		button.setBackground(Color.GREEN);
	}

	/**
	 * Devote a player
	 */
	public void deVote()
	{
		button.setBackground(Color.WHITE);
	}

	/**
	 * Sets button contained in OPlayer to argument
	 * 
	 * @param button
	 *            Button to be set in player class
	 */
	public void setButton(JButton button)
	{
		this.button = button;
	}

	/**
	 * Disables button
	 */
	public void disableButton()
	{
		button.setEnabled(false);
		button.setBackground(Color.BLACK);
	}

	/**
	 * Enable button
	 */
	public void enableButton()
	{
		button.setEnabled(true);
		button.setBackground(Color.WHITE);
	}

	/**
	 * Sets boolean of button
	 * 
	 * @param b
	 *            Boolean to set button to
	 */
	@Deprecated
	public void setButton(boolean b)
	{
		button.setEnabled(b);
	}

	/**
	 * Gets boolean for if button is enabled
	 * 
	 * @return Boolean of whether or not the button is enabled
	 */
	public boolean getButtonEnabled()
	{
		return button.isEnabled();
	}

	/**
	 * Gets button object from OPlayer
	 * 
	 * @return Button object from OPlayer
	 */
	public JButton getButton()
	{
		return button;
	}
}
