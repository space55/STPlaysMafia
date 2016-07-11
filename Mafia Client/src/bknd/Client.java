/*******************************************************************************
 * Copyright (C) Eamonn Nugent - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Eamonn Nugent <elg.nugent@gmail.com>, 2016
 *******************************************************************************/

package bknd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.OPlayer;
import game.Server;

public class Client extends JFrame implements ActionListener, Runnable
{
	public static String username = "undefined";
	public static ArrayList<String> messages = new ArrayList<String>();
	public static String deathMessage = "";
	public static JButton[][] buttons = {};

	public void run()
	{
		init();
		JPanel panel = panelSetup();
		add(panel);
		setVisible(true);
	}

	/**
	 * Sets up a client GUI.
	 * 
	 */
	public static void init()
	{
		username = JOptionPane.showInputDialog("What is your username?");

		int columns = (int) Math.sqrt(Server.players.size());
		for (int i = 0; i < Server.players.size(); i++)
		{
			for (int a = 0; a < columns; a++)
			{
				if (i < Server.players.size())
				{
					JButton temp = new JButton(Server.get(i).getUsername());
					temp.setVisible(true);
					buttons[i][a] = temp;
					i++;
				}
			}
		}
	}

	/**
	 * Finishes setting up the JPanel of buttons.
	 * 
	 * @return The JPanel of JButtons.
	 */
	public JPanel panelSetup()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(buttons.length, buttons[0].length));
		for (int i = 0; i < buttons.length; i++)
		{
			for (int j = 0; j < buttons[0].length; j++)
			{
				panel.add(buttons[i][j]);
			}
		}
		panel.setVisible(true);
		return panel;
	}

	/**
	 * Returns the vote of a player.
	 * 
	 * @return The player that was voted for.
	 */
	public static OPlayer getVote()
	{
		return null;
	}

	/**
	 * Adds the username of the dead player to a string.
	 * 
	 * @param p
	 *            The player that was killed.
	 */
	public static void wasKilled(OPlayer p)
	{
		deathMessage += p.getUsername() + " was killed. \n";
	}

	/**
	 * Adds an ActionListener to a JButton array.
	 */
	public void addActionListeners(JPanel panel)
	{
		for (int i = 0; i < buttons.length; i++)
		{
			for (int j = 0; j < buttons[0].length; j++)
			{
				buttons[i][j].addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
