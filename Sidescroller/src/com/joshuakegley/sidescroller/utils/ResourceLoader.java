/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: ResourceLoader
 */
package com.joshuakegley.sidescroller.utils;

import java.io.IOException;

import com.joshuakegley.sidescroller.libs.Fonts;
import com.joshuakegley.sidescroller.libs.Images;

/**
 * @Class ResourceLoader
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages(){
		
		try{
			Images.title = imageLoader.loadImage("logo.png");
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void loadFonts(){
		Fonts.addFont(new Fonts("Lobster.ttf"));
		
	}

}
