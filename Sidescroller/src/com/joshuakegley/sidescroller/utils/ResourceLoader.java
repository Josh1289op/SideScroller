/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: ResourceLoader
 */
package com.joshuakegley.sidescroller.utils;

import java.io.IOException;

import com.joshuakegley.sidescroller.libs.Audio;
import com.joshuakegley.sidescroller.libs.Images;
import com.joshuakegley.sidescroller.libs.Reference;

/**
 * @Class ResourceLoader
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages(){
		
		try{
			Images.title = imageLoader.loadImage("logo.png");
			Images.spritesheetTest = imageLoader.loadImage("test_spritesheet.png");
			
			
			//SET HD IMAGE TO HD IMAGE
			Images.rockyBlocksHD = imageLoader.loadImage("rocky_blocks.png");
			//SETUP NON HD LIKE IMAGE, SCALE HD IMAGE
			Images.rocky_blocks = ImageModifer.resizeImage(Images.rockyBlocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, .25);
			
			
			
			Images.spritesheetPlayer = imageLoader.loadImage("player.png");
			Images.levelOne = imageLoader.loadImage("levels/level1.png");
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void loadFonts(){
		Fonts.addFont(new Fonts("Lobster.ttf"));
		
	}
	
	public static void loadSounds(){
		AudioPlayer.addSound(Audio.SOUND_BUTTONCLICK, "button_click.wav");
		
		AudioPlayer.addMusic(Audio.MUSIC_THEME, "theme.ogg");
	}

}
