/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: MouseInput
 */
package com.joshuakegley.sidescroller.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.enums.GameState;

/**
 * @Class MouseInput
 */
public class MouseInput extends MouseAdapter {
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 100, 100);
		
		if(mouse == MouseEvent.BUTTON1){
			switch(Game.state){
			case GAME:
				break;
			case MENU:
				if(rect.intersects(Game.getInstance().menu.play)){
					Game.state = GameState.GAME;
				}
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

}
