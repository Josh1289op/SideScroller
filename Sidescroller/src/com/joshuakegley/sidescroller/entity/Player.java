/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Player
 */
package com.joshuakegley.sidescroller.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.objects.Block;

/**
 * @Class Player
 */
public class Player extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	//
	//gravity constant
	private float gravity = 0.55f;
	//is the player falling?
	private boolean falling = true;
	//is the player jumping?
	private boolean jumping = false;
	
	


	public Player(float x, float y, int id, Textures tex) {
		super(x, y, id, tex);
		this.setSize(32, 70);
	}


	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
		//makes fall
		fall();
		checkCollision();
		
	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
	}

	private void checkCollision(){
		
		for(CoreObject obj : gameObjects){
			if(obj instanceof Block){
				if(getBottomBounds().intersects(obj.getTopBounds())){
					velY = 0;
					y = obj.getY() - height;
					jumping = false;
				}
				if(getTopBounds().intersects(obj.getBottomBounds())){
					fall();
					y = obj.getY() + obj.getHeight();
				}
				if(getBottomBounds().intersects(obj.getTopBounds())){
					
				}
				if(getRightBounds().intersects(obj.getLeftBounds())){
					velX = 0;
					x = obj.getX() - width;
					
				}
				if(getLeftBounds().intersects(obj.getRightBounds())){
					velX = 0;
					x = obj.getX() + obj.getWidth();
				}
			}
		}
		
	}
	
	public void fall(){
		if(falling){
			velY += gravity;
		}
	}
	
	

	
	/**
	 * 
	 * @return true if jumping/false if not
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * 
	 * @param jumping the boolean set the jumping state.
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}
