package com.joshuakegley.sidescroller;


import com.joshuakegley.sidescroller.core.CoreObject;
import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.libs.Identities;

public class Camera {

	private float x, y;
	private Player player;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
		for(CoreObject obj : Game.getInstance().getController().getObjects()){
			if(obj.getId() == Identities.PLAYER){
				player = (Player) obj;
			}
		}
	}

	/** Tweening Algorithm 
	 * 		x += (target - value) * constant;
	 */
	public void tick(){
		x += ((-player.getX() + Game.WIDTH / 2) - x) * 0.0275f;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
	
}
