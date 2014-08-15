package com.joshuakegley.sidescroller;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.joshuakegley.sidescroller.libs.Reference;

public class Window {
	
	private static JFrame frame;

	
	public static void initWindow(String title){
		frame = new JFrame(title);
		
	}
	
	public static void addGame(Game game){
		frame.add(game);
	}

	
	public static void createWindow(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Setting image icon to image of 32x32.png
		Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "img/32x32.png");
		//Setting image cursor to image of cursor
		Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "img/cursor.gif");
		frame.setIconImage(icon);
		/**
		 * Replacing Cursor with new Frame Cursor
		 */
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
			
	}
	
	public static void setTitle(String title){
		frame.setTitle(title);
	}
}
