package com.joshuakegley.sidescroller.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.joshuakegley.sidescroller.Game;

public class LoadScreen {
	
	private static int width = 540;
	private static int numResources = 8;
	
	private static int loadAdd = width / numResources;
	private static int loadStatus = 0;
	
	private static String msg = "Loading Resources";
	
	public static void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawRect(49, 300, width, 51);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString(msg, 51, 295);
		g.setColor(Color.GRAY);
		g.fillRect(50, 301, loadStatus, 50);
		
	}

	public static void loadMore(){
		loadStatus += loadAdd;
	}
	
	public static void setMessage(String msg){
		LoadScreen.msg = msg;
	}

}


