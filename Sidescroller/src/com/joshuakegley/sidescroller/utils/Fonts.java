/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Fonts
 */
package com.joshuakegley.sidescroller.utils;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.screens.LoadScreen;

/**
 * @Class Fonts
 */
public class Fonts {

	private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
	
	private static String fontPath;
	
	public Fonts(String filePath){
		LoadScreen.setMessage("Loading Fonts From " + Reference.FONT_LOCATION);
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
	}
	
	private void registerFont(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void addFont(Fonts font) {
		fontList.add(font);
	}
}
