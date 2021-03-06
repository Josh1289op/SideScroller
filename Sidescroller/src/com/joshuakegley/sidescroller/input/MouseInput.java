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
import com.joshuakegley.sidescroller.libs.Audio;
import com.joshuakegley.sidescroller.screens.Menu;
import com.joshuakegley.sidescroller.utils.AudioPlayer;

/**
 * @Class MouseInput
 */
public class MouseInput extends MouseAdapter {
	
	/**
	 * true if mouse button is down/pressed
	 */
	public static boolean pressed = false;
	
	/**
	 * The x and y coords of the mouse
	 */
	public static int MOUSE_X, MOUSE_Y;
	
	/**
	 * Used to check for intersection in other classes. Set to a 1x1 at location (1,1) by defaultm to avoid NullPointerException
	 */
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	
	
	private Menu menu = Game.getInstance().getMenu();
	
	
	@Override
	/**
	 * This method is called whenever a mouse button is clicked
	 */
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 100, 100);
		
		if(mouse == MouseEvent.BUTTON1){
			switch(Game.state){
			case GAME:
				break;
			case MENU:
				if(rect.intersects(menu.play)){
					AudioPlayer.playSound(Audio.SOUND_BUTTONCLICK);
					Game.getInstance().levelOne.loadLevel();
					Game.state = GameState.GAME;
				}else if(rect.intersects(menu.options)){
					AudioPlayer.playSound(Audio.SOUND_BUTTONCLICK);
					Game.state = GameState.GAME;
				}else if(rect.intersects(menu.quit)){
					AudioPlayer.playSound(Audio.SOUND_BUTTONCLICK);
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
	
	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
		MOUSE = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if(Game.state == GameState.MENU){
			if(MOUSE.intersects(menu.quit)){
				Game.exit();
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);

		
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			if((MOUSE.intersects(menu.play) || MOUSE.intersects(menu.options) || MOUSE.intersects(menu.quit)) && !AudioPlayer.hasPlayedAudio){
				AudioPlayer.hasPlayedAudio = true;
				AudioPlayer.playSound(Audio.SOUND_BUTTONCLICK);
			}else if(!(MOUSE.intersects(menu.play) || MOUSE.intersects(menu.options) || MOUSE.intersects(menu.quit)) && AudioPlayer.hasPlayedAudio){
				AudioPlayer.hasPlayedAudio = false;
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
