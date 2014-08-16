package com.joshuakegley.sidescroller.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.joshuakegley.sidescroller.core.CoreObject;

public class Block extends CoreObject {

	public Block(float x, float y, int id, BufferedImage image) {
		super(x, y, id, image);
		this.image = image;
		this.setSize(32, 32);
		
		
		
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,(int) x,(int) y, null);
	}


	
}
