/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: AudioPlayer
 */
package com.joshuakegley.sidescroller.utils;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.screens.LoadScreen;

/**
 * @Class AudioPlayer
 */
public class AudioPlayer {
	
	public static boolean hasPlayedAudio = false;
	
	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	private static Map<String, Music> musicMap = new HashMap<String, Music>();

	
	public static void addSound(String key, String path){
		LoadScreen.setMessage("Loading Sounds From " + Reference.SOUND_LOCATION);
		try {
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addMusic(String key, String path){
		LoadScreen.setMessage("Loading Music From " + Reference.SOUND_LOCATION);
		try {
			musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}

	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

	
	public static void playSound(String key){
		soundMap.get(key).play();
	}
	
	public static void playMusic(String key){
		musicMap.get(key).loop(0.5f, 1f);
	}
	
	
}
