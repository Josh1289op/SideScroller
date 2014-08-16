/**
  *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Reference
 */
package com.joshuakegley.sidescroller.libs;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.Game;

/**
 * @Class Reference
 */
public class Reference {


	public static final int CENTER_X = Game.WIDTH /2;
	public static final int CENTER_Y = Game.HEIGHT /2;
	
	public static final String RESOURCE_LOCATION = "./res/";
	
	public static final String SPRITE_LOCATION = RESOURCE_LOCATION + "sprites/";
	
	public static final String FONT_LOCATION = RESOURCE_LOCATION + "fonts/";
	
	/**
	 * Base Location of Sounds Folder
	 */
	public static final String SOUND_LOCATION = RESOURCE_LOCATION + "sound/";
	
	
	public static final int ALPHA_RGB = BufferedImage.TYPE_INT_ARGB;
	
	/**
	 * Style Themes for Entire Game
	 * 
	 */
	public static Color menuBackground = new Color(33, 42, 63);
	public static Color menuFontNotSelected = new Color(138, 184, 57);
	public static Color menuFontHovered = new Color(33, 42, 63);
	public static Color menuFontSelected = new Color(33, 42, 63);
	
	
	/*
	 * 
	 * Level Background Colors
	 * 
	 */
	
	public static Color level1 = new Color(70, 130, 180);
}
