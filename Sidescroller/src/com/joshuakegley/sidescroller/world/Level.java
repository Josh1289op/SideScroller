package com.joshuakegley.sidescroller.world;

import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.Controller;
import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.libs.Identities;
import com.joshuakegley.sidescroller.libs.Images;
import com.joshuakegley.sidescroller.objects.Block;

public class Level {

	
		private BufferedImage image;
		private Controller controller = Game.getInstance().getController();
		private Textures tex = Game.getInstance().getTextureHandler();
		
		public Level(int levelNumber){
			switch(levelNumber){
				case 1:
					image = Images.levelOne;
					break;
				default:
					image = Images.levelOne;
					break;
			}
		}
		
		public void loadLevel(){
			int w = image.getWidth();
			int h = image.getHeight();
			
			for(int x = 0; x < w; x++){
				for(int y = 0; y < h; y++){
					int pixel = image.getRGB(x,y);
					int red = (pixel >> 16) & 0xff;
					int green = (pixel >> 8) & 0xff;
					int blue = (pixel) & 0xff;
				
					//Yellow for PLAYER START POSITION
					if(red == 255 && green == 255 && blue == 0){
						addPlayer((float)x, (float)y, red, green, blue);
					}
					//white
					if(red == 255 && green == 255 && blue == 255){
						addBlock(x, y, Identities.BLOCK_STONE, tex.blockStone);
					}
					//red
					if(red == 255 && green == 0 && blue == 0){
						addBlock(x, y, Identities.BLOCK_METAL, tex.blockMetal);
					}
					//GREEN
					if(red == 0 && green == 255 && blue == 0){
						addBlock(x, y, Identities.ROCKY_BLOCK, tex.rockyBlock);
					}					
					if(red == 0 && green == 250 && blue == 0){
						addBlock(x, y, Identities.ROCKY_BLOCK_TOP, tex.rockyBlockTop);
					}
					if(red == 0 && green == 245 && blue == 0){
						addBlock(x, y, Identities.ROCKY_BLOCK_TOP_LEFT, tex.rockyBlockTopLeft);
					}
					if(red == 0 && green == 240 && blue == 50){
						addBlock(x, y, Identities.ROCKY_BLOCK_TOP_RIGHT, tex.rockyBlockTopRight);
					}
					if(red == 0 && green == 235 && blue == 0){
						addBlock(x, y, Identities.ROCKY_BLOCK_TOP_RIGHT_LEFT, tex.rockyBlockTopRightLeft);
					}
					
				}
				
			}
		}
		
		
		private void addBlock(int x, int y, int id, BufferedImage texture){
			controller.addObject(new Block(x * 32, y * 32, id, texture));
			
		}
		
		private void addPlayer(float x, float y, int red, int green, int blue){
			Player player = null;
			for(CoreObject obj : controller.getObjects())
			if(obj.getId() == Identities.PLAYER)
			player = (Player) obj;
			player.setX(x * 32);
		}
	
}
