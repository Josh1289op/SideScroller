package com.joshuakegley.sidescroller.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.gfx.Texture;

public class Block extends CoreObject {

	private BufferedImage image;
	
	public Block(int x, int y, int id, Texture tex, BufferedImage image) {
		super(x, y, id, tex);
		this.image = image;
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	public Rectangle getTopBounds(){
		
		return new Rectangle(x, y, 32, 6);
	}
	
}
