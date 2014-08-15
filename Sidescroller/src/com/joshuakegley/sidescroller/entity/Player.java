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

import com.joshuakegley.sidescroller.Controller;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.libs.Identities;
import com.joshuakegley.sidescroller.objects.Block;

/**
 * @Class Player
 */
public class Player extends CoreObject {

	private static ArrayList<CoreObject> blocks = Controller.getObjects();
	//
	private Block block;
	//gravity constant
	private int gravity = 1;
	//is the player falling?
	private boolean falling = true;
	//is the player jumping?
	private boolean jumping = false;
	
	


	public Player(int x, int y, int id, Textures tex) {
		super(x, y, id, tex);
		this.width = 32;
		this.height = 70;
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
		g.fillRect(x, y, width, height);
	}

	private void checkCollision(){
		
		for(CoreObject obj : blocks){
			if(obj.getId() == Identities.BLOCK_STONE){
				block = (Block) obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					velY = 0;
					y = block.getY() - height;
					jumping = false;
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
