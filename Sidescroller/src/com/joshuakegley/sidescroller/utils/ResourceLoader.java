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

/**
 * @Class ResourceLoader
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages(){
		
		try{
			Images.title = imageLoader.loadImage("logo.png");
			Images.spritesheetTest = imageLoader.loadImage("test_spritesheet.png");
			Images.spritesheetPlayer = imageLoader.loadImage("player.png");
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
