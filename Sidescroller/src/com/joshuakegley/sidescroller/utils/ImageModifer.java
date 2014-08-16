package com.joshuakegley.sidescroller.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageModifer {
		
	public static BufferedImage resizeImage(BufferedImage originalImage, int type, float x, float y, int inititalWidth, int initialHeight, double scale){
		inititalWidth *= scale;
		initialHeight *= scale;
		BufferedImage resizedImage = new BufferedImage(inititalWidth, initialHeight, type);
		Graphics2D g2d = resizedImage.createGraphics();
		g2d.drawImage(originalImage, (int)x, (int)y, inititalWidth, initialHeight, null);
		g2d.dispose();
		return resizedImage;
	}
	
}
