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
	protected int id; 
	
	protected int width;
	protected int height;
	
	protected Texture tex;
	
	public CoreObject(int x, int y, int id, Texture tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		width = 32;
		height = 32;
	}
	
	public CoreObject(int x, int y, int width, int height, int id, Texture tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		this.width = width;
		this.height = height;
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
