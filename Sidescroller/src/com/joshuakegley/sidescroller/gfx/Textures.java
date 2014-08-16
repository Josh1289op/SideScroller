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
public class Textures {

	
	//blocksheet
	private SpriteSheet sheetTest;
	//playersheet
	private SpriteSheet playerSheet;
	
	//bosssheet
	
	
	
	public BufferedImage playerStandingRight;
	public BufferedImage playerStandingLeft;
	public BufferedImage playerRight[] = new BufferedImage[8];
	public BufferedImage playerLeft[] = new BufferedImage[8];
	
	
	/*
	 *Game Object Images 
	 */
	public BufferedImage blockMetal;
	public BufferedImage blockStone;
	
	public Textures(){
		sheetTest = new SpriteSheet(Images.spritesheetTest, 32);
		playerSheet = new SpriteSheet(Images.spritesheetPlayer, 50);
	
		initTextures();
	}
	
	private void initTextures(){
		blockStone = sheetTest.getSprite(1, 1);
		blockMetal = sheetTest.getSprite(6, 1);
		
		playerStandingRight = playerSheet.getSprite(1, 1);
		playerStandingLeft = playerSheet.getSprite(2, 1);

		playerRight[0] = playerSheet.getSprite(1, 2);
		playerRight[1] = playerSheet.getSprite(2, 2);
		playerRight[2] = playerSheet.getSprite(3, 2);
		playerRight[3] = playerSheet.getSprite(4, 2);
		playerRight[4] = playerSheet.getSprite(5, 2);
		playerRight[5] = playerSheet.getSprite(1, 3);
		playerRight[6] = playerSheet.getSprite(2, 3);
		playerRight[7] = playerSheet.getSprite(3, 3);
		
		playerLeft[0] = playerSheet.getSprite(1, 4);
		playerLeft[1] = playerSheet.getSprite(2, 4);
		playerLeft[2] = playerSheet.getSprite(3, 4);
		playerLeft[3] = playerSheet.getSprite(4, 4);
		playerLeft[4] = playerSheet.getSprite(5, 4);
		playerLeft[5] = playerSheet.getSprite(1, 5);
		playerLeft[6] = playerSheet.getSprite(2, 5);
		playerLeft[7] = playerSheet.getSprite(3, 5);
		
	}
	
}
