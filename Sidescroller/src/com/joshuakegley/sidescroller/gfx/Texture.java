/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Texture
 */
package com.joshuakegley.sidescroller.gfx;

import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.libs.Images;
import com.joshuakegley.sidescroller.utils.SpriteSheet;

/**
 * @Class Texture
 */
public class Texture {

	private SpriteSheet sheetTest;
	
	/*
	 *Game Object Images 
	 */
	public BufferedImage blockMetal;
	public BufferedImage blockStone;
	
	public Texture(){
		sheetTest = new SpriteSheet(Images.spritesheetTest, 32);
	
		initTextures();
	}
	
	private void initTextures(){
		blockStone = sheetTest.getSprite(1, 1);
		blockMetal = sheetTest.getSprite(2, 1);
		
	}
	
}
