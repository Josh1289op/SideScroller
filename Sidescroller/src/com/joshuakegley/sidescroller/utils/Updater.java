package com.joshuakegley.sidescroller.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.utils.files.TextFile;

public class Updater {
	
	private static String currentVersion, newVersion;
	public static int update = 0;

	
	public static void checkForUpdate(boolean isAuto){
		currentVersion = TextFile.readFile("./version.txt");
		
		try{
			URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/f1dc65d1d8b036de5e26c5e4709f8949f1208ca5/Sidescroller/version.txt");
			ReadableByteChannel rbc = Channels.newChannel(site.openStream());
			FileOutputStream fos = new FileOutputStream("./version.txt");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		newVersion = TextFile.readFile("./version.txt");
		
		if(currentVersion.equals(newVersion)){
			if(!isAuto){
				doNotUpdate();
				return;
			}
		}else{
			Object[] options = 
				{
					"Update",
					"Do Not Update"
				};
			int temp = JOptionPane.showOptionDialog(null, "Update Found for SideScroller \nCurrent Version: " + currentVersion + "\n New Version: " + newVersion + 
					"\n Update may take several minutes! \nDo not close the game while updating!\nA window will popup when the update is complete!", "Updater", JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			if(temp == 1){
				return;
			}else{
				//////////////////////////////////////////////////////////////
				//DOWNLOAD FILES
				///////////////////////////////////////////////////////////////
				TextFile.writeFile("./version.txt", newVersion);
				//Player Sprite
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/sprites/player.png");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "player.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
				//Rocky_blocks
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/sprites/rocky_blocks.png");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "rocky_blocks.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				//test_spritesheet
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/sprites/test_spritesheet.png");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "test_spritesheet.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}				
				//logo
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/sprites/logo.png");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "logo.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				//////////////////////////////////
				//MUSIC
				//////////////////////////////////
				//button_click.wav
				try{
					URL site = new URL("https://github.com/Josh1289op/SideScroller/raw/master/Sidescroller/res/sound/button_click.wav");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SOUND_LOCATION + "button_click.wav");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}				
				//Theme Music
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/sound/theme.ogg");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SOUND_LOCATION + "theme.ogg");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				///////////////////////////////////
				//IMGS
				//32x32.png
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/img/32x32.png");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.RESOURCE_LOCATION + "img/32x32.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				//Cursor
				try{
					URL site = new URL("https://raw.githubusercontent.com/Josh1289op/SideScroller/master/Sidescroller/res/img/cursor.gif");
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.RESOURCE_LOCATION + "img/cursor.gif");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}

				//////////////////////////////////////////////////////////////
				//DOWNLOAD FILES END
				///////////////////////////////////////////////////////////////
				finishUpdate();
				return;
			}
		}	
	}
	
	private static void finishUpdate(){
		JOptionPane.showMessageDialog(null, "Game as been updated\nVersion: " +  newVersion, "Update Completed", JOptionPane.INFORMATION_MESSAGE);
		Game.exit();
	}
	
	private static void doNotUpdate(){
		JOptionPane.showMessageDialog(null, "No Update Found", "Updater", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
}
