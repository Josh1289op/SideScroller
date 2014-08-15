/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: CoreObject
 */
package com.joshuakegley.sidescroller.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.joshuakegley.sidescroller.gfx.Textures;

/**
 * @Class CoreObject
 */
public abstract class CoreObject {
	
	protected int x, y, velX, velY;
	protected int id; 
	
	protected int width = 32;
	protected int height = 32;
	
	protected Textures tex;
	
	public CoreObject(int x, int y, int id, Textures tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}	
	
	public abstract void tick();
	public abstract void render(Graphics g);

	
	public Rectangle getTopBounds(){	
		return new Rectangle(x, y, width, 6);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle(x, y + (height - 6), width, 6);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle(x + (width -6), y, 6, height);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle(x, y, 6, height);
	}
	
	
	
	
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
