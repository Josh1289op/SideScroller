/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: CoreObject
 */
package com.joshuakegley.sidescroller.core;

import java.awt.Graphics;

import com.joshuakegley.sidescroller.gfx.Texture;

/**
 * @Class CoreObject
 */
public abstract class CoreObject {
	
	protected int x, y, velX, velY;
	protected long id; 
	protected Texture tex;
	
	public CoreObject(int x, int y, long id, Texture tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	/**
	 * Gets the x value
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * gets the y coord
	 * @return the y coord
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelX() {
		return velX;
	}
	/**
	 * @param velY the velY to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelY() {
		return velY;
	}	
	

}
