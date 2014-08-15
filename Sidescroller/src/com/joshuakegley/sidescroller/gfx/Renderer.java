/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Renderer
 */
package com.joshuakegley.sidescroller.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.joshuakegley.sidescroller.Game;


/**
 * @Class Renderer
 */
public class Renderer {


	
	public void renderBackground(Graphics g) {
		//Stuff that doesn't effect gameplay
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTION:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAME STATE", 150, 150);
			break;
		
		}
		
	}
	
	public void renderForeground(Graphics g){
		//Stuff that effects gameplay
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTION:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}
}
