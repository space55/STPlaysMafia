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

public class Client extends JFrame implements ActionListener
{
	public static String username = "undefined";
	public static ArrayList<String> messages = new ArrayList<String>();
	public static String deathMessage = "";
	public static JButton[][] buttons = {};
	public JPanel panel;
	public boolean voteEnabled;

	public void run()
	{
		init();
	}

	/**
	 * Initializes client.
	 * 
	 */
	public void init()
	{
		username = JOptionPane.showInputDialog("What is your username?");
	}

	/**
	 * Displays client GUI.
	 */
	public void startGame()
	{
		int columns = (int) Math.round(Math.sqrt(Server.players.size()));
		for (int i = 0; i < Server.players.size(); i++)
		{
			for (int a = 0; a < columns; a++)
			{
				if (i < Server.players.size())
				{
					Server.players.get(i).setButton(new JButton(Server.get(i).getUsername()));
					Server.players.get(i).getButton.setVisible(true);
					buttons[i][a] = Server.players.get(i).getButton();
					i++;
				}
			}
		}
		panel = new JPanel();
		panel.setLayout(new GridLayout(buttons.length, buttons[0].length));
		for (int i = 0; i < buttons.length; i++)
		{
			for (int j = 0; j < buttons[i].length; j++)
			{
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		panel.setVisible(true);
		add(panel);
		setVisible(true);
	}

	/**
	 * Activates voting.
	 * 
	 */
	public void enableVote()
	{

	}

	/**
	 * Disables voting.
	 */
	public void disableVote()
	{

	}

	/**
	 * Adds the username of the dead player to a string.
	 * 
	 * @param p
	 *            The player that was killed.
	 */
	public void wasKilled(OPlayer p)
	{
		deathMessage += p.getUsername() + " was killed. \n";
	}

	public void day()
	{
		JOptionPane.showMessageDialog(null, deathMessage);
		deathMessage = "";
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
