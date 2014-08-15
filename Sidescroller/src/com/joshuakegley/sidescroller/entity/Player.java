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
import java.awt.Rectangle;
import java.util.ArrayList;

import com.joshuakegley.sidescroller.Controller;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.gfx.Texture;
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
	
	
	public Player(int x, int y, int width, int height, int id, Texture tex) {
		super(x, y, width, height, id, tex);
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
		g.fillRect(x, y, 30, 70);
	}

	private void checkCollision(){
		
		for(CoreObject obj : blocks){
			if(obj.getId() == Identities.BLOCK_STONE){
				block = (Block) obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					velY = 0;
					y = block.getY() - height;
				}
			}
		}
		
	}
	
	public void fall(){
		if(falling){
			velY += gravity;
		}
	}
	
	
	public Rectangle getBottomBounds(){
		return new Rectangle(x, y + (height/2), 30, height/2);
	}
	
}
