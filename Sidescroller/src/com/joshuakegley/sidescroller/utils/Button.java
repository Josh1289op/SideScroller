/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Button
 */
package com.joshuakegley.sidescroller.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.joshuakegley.sidescroller.input.MouseInput;
import com.joshuakegley.sidescroller.libs.Reference;

/**
 * @Class Button
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {

	private String text;
	

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
