/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: KeyInput
 */
package com.joshuakegley.sidescroller.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.joshuakegley.sidescroller.Controller;
import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.libs.Identities;

/**
 * @Class KeyInput
 */
public class KeyInput extends KeyAdapter {

	private Player player;
	
	private boolean[] keyDown = new boolean[2];
	
	public KeyInput(){
		for(CoreObject obj : Controller.getObjects()){    //Runs through the entire array list (for each CoreObject in the array list, do this)
			if(obj.getId() == Identities.PLAYER)          //If the objects ID is equal to Identities.PLAYER (1) then do this
				player = (Player) obj;                    //Sets our player attribute(above) to the object in our Controller
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W){
				player.setVelY(-5);
			}
			//if(key == KeyEvent.VK_S){
			//	player.setVelY(5);
			//}
			if(key == KeyEvent.VK_A){
				player.setVelX(-5);
				keyDown[0] = true;
			}
			if(key == KeyEvent.VK_D){
				player.setVelX(5);
				keyDown[1] = true;
			}
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
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W){
				player.setVelY(0);
			}
			//DOWN MOVEMENT REMOVED, NO DOWN NEEDED2
			//if(key == KeyEvent.VK_S){
			//	player.setVelY(0);
			//}
			if(key == KeyEvent.VK_A){
				keyDown[0] = false;
			}
			if(key == KeyEvent.VK_D){
				keyDown[1] = false;
			}
			if(keyDown[0] && !keyDown[1]){
				player.setVelX(-5);
			}
			if(!keyDown[0] && keyDown[1]){
				player.setVelX(5);
			}
			if(!keyDown[0] && !keyDown[1]){
				player.setVelX(0);
			}
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
