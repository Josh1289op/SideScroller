/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Player
 */
package com.joshuakegley.sidescroller.entity;

import java.awt.Graphics;

import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.gfx.Texture;

/**
 * @Class Player
 */
public class Player extends CoreObject {

	
	
	public Player(int x, int y, int id, Texture tex) {
		super(x, y, id, tex);
	}


	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
	}


	@Override
	public void render(Graphics g) {
		g.drawImage(tex.blockMetal, x, y, null);
	}


	/**
	 * @return
	 */


	
}
