/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Menu
 */
package com.joshuakegley.sidescroller.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.libs.Images;
import com.joshuakegley.sidescroller.libs.Reference;

/**
 * @Class Menu
 */
public class Menu {

	public Rectangle play, options, quit;
	//private static int centerY = Game.HEIGHT / 2;
	
	
	public Menu(){
		int fillerY = 150;
		
		play = new Rectangle(Reference.CENTER_X - 100, fillerY, 200, 50);
		
		options = new Rectangle(Reference.CENTER_X - 100, fillerY+=60, 200, 50);
		
		quit = new Rectangle(Reference.CENTER_X - 100, fillerY+=60, 200, 50);
		
	}
	
	public void drawButton(Graphics g, Rectangle rect, String text, int offsetX){
		Font Lobster = new Font("Lobster", Font.BOLD, 45); 
		g.setFont(Lobster);
		g.setColor(Color.WHITE);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offsetX, rect.y + 38);
	}
	
	public void render(Graphics g){
		g.setColor(new Color(21, 125, 200));
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 65, 0, null);
		drawButton(g, play, "Play!", 50);
		drawButton(g, options, "Options", 25);
		drawButton(g, quit, "Quit", 50);

	}

}
