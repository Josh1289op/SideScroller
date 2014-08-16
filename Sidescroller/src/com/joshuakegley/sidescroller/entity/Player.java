/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Player
 */
package com.joshuakegley.sidescroller.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import com.joshuakegley.sidescroller.Game;
import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.enums.Direction;
import com.joshuakegley.sidescroller.gfx.Animation;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.objects.Block;

/**
 * @Class Player
 */
public class Player extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	//
	//gravity constant
	private float gravity = 0.55f;
	//is the player falling?
	private boolean falling = true;
	//is the player jumping?
	private boolean jumping = false;
	
	private boolean moving = false;
	
	private Animation animeRight;
	private Animation animeLeft;
	
	private Direction direction = Direction.RIGHT;
	
	


	public Player(float x, float y, int id, Textures tex) {
		super(x, y, id, tex);
		this.setSize(50, 50);
		animeRight = new Animation(3, tex.playerRight);
		animeLeft = new Animation(3, tex.playerLeft);
	}


	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
		//makes fall
		fall();
		checkCollision();
		if(moving){
			if(direction == Direction.RIGHT){
				animeRight.runAnimation();
			}else if(direction == Direction.LEFT){
				animeLeft.runAnimation();
			}
		}
	}


	@Override
	public void render(Graphics g) {
		if(!moving){
			if(direction == Direction.RIGHT){
				g.drawImage(tex.playerStandingRight,(int) x,(int) y, null);
			}else if(direction == Direction.LEFT){
				g.drawImage(tex.playerStandingLeft,(int) x,(int) y, null);
			}
		}else{
			if(direction == Direction.RIGHT){
				animeRight.drawAnimation(g, x, y);
			}else if(direction == Direction.LEFT){
				animeLeft.drawAnimation(g, x, y);

			}
		}
	}

	private void checkCollision(){
		
		for(CoreObject obj : gameObjects){
			if(obj instanceof Block){
				if(getBottomBounds().intersects(obj.getTopBounds())){
					velY = 0;
					y = obj.getY() - height;
					jumping = false;
				}
				if(getTopBounds().intersects(obj.getBottomBounds())){
					fall();
					y = obj.getY() + obj.getHeight();
				}
				if(getBottomBounds().intersects(obj.getTopBounds())){
					
				}
				if(getRightBounds().intersects(obj.getLeftBounds())){
					velX = 0;
					x = obj.getX() - width;
					
				}
				if(getLeftBounds().intersects(obj.getRightBounds())){
					velX = 0;
					x = obj.getX() + obj.getWidth();
				}
			}
		}
		
	}
	
	public void fall(){
		if(falling){
			velY += gravity;
		}
	}
	
	

	
	/**
	 * 
	 * @return true if jumping/false if not
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * 
	 * @param jumping the boolean set the jumping state.
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}


	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void setDirection(Direction direction){
		this.direction = direction;	
	}

	public Direction getDirection(){
		return direction;
	}
}
