/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: BufferedImageLoader
 */
package com.joshuakegley.sidescroller.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.screens.LoadScreen;

/**
 * @Class BufferedImageLoader
 */
public class BufferedImageLoader {

	private BufferedImage image;
	
	public BufferedImage loadImage(String imagePath) throws IOException{
		LoadScreen.setMessage("Loading Textures From " + Reference.SPRITE_LOCATION);
		image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
		
		return image;
			
	}

}
