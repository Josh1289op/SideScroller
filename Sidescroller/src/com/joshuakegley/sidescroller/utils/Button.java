/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Button
 */
package com.joshuakegley.sidescroller.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.joshuakegley.sidescroller.input.MouseInput;
import com.joshuakegley.sidescroller.libs.Reference;

/**
 * @Class Button
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {

	private String text;
	
	/**
	 * Creates a default button/rectangle
	 */
	public Button() {
		super();
	
	}

	//Creates a rectangle/button using data from a rect object
	//@param r A rectangle object
	public Button(Rectangle r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a rectangle from a point
	 * @param p A point Object
	 */

	public Button(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Creates a rectangle/button using a dimension
	 * 
	 * @param d a dimension object
	 */

	public Button(Dimension d) {
		super(d);
		// TODO Auto-generated constructor stub
	}


	public Button(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public Button(Point p, Dimension d) {
		super(p, d);
		// TODO Auto-generated constructor stub
	}


	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	
	public Button setText(String text) {
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset){
			int xx = x + offset;
			int yy = y + 38;
			
			if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
				g.setColor(Color.BLACK);
				
			}else {
				g.setColor(Color.WHITE);	
			}
			
			if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this)){
				g.drawRect(x, y, width, height);
			}else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this)){
				g.fillRect(x, y, width, height);
			}else{
				g.drawRect(x, y, width, height);
			}
			
			//Base button, not selected
			g.setColor(Reference.menuFontNotSelected);
			g.drawString(text, xx, yy);
	}
}
