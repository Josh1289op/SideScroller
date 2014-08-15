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
import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.gfx.Textures;

/**
 * @Class CoreObject
 */
public abstract class CoreObject {
	
	protected float x, y, velX, velY;
	protected int id; 
	
	protected int width;

	protected int height;
	
	protected Textures tex;
	
	protected BufferedImage image;
	
	public CoreObject(float x, float y, int id, Textures tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}		
	
	public CoreObject(float x, float y, int id, BufferedImage image){
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}	
	
	public abstract void tick();
	public abstract void render(Graphics g);

	
	public Rectangle getTopBounds(){	
		return new Rectangle((int) x, (int) y, width, 12);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle((int) x, (int) y + (height - 6), width, 12);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int) x + (width -6), (int) y, 6, height);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int) x,(int) y, 6, height);
	}
	
	
	
	
	/**
	 * Gets the x value
	 * @return the x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * gets the y coord
	 * @return the y coord
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setSize(int width, int height){
		this.width = width;
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

	public float getVelX() {
		return velX;
	}
	/**
	 * @param velY the velY to set
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public float getVelY() {
		return velY;
	}	
	

}
