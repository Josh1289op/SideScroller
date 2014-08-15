/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Menu
 */
package com.joshuakegley.sidescroller.screens;

import java.awt.Font;
import java.awt.Graphics;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.libs.Images;
import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.utils.Button;

/**
 * @Class Menu
 */
public class Menu {

	public Button play, options, quit;
	//private static int centerY = Game.HEIGHT / 2;
	
	
	public Menu(){
		int fillerY = 150;
		
		play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play!");
		
		options = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Options");
		
		quit = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Quit");
		
	}
	

	
	public void render(Graphics g){
		g.setColor(Reference.menuBackground);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 65, 0, null);
		
		Font Lobster = new Font("Lobster", Font.BOLD, 45); 
		g.setFont(Lobster);
		

		play.drawButton(g, 50);
		options.drawButton(g, 25);
		quit.drawButton(g, 50);


	}

}
