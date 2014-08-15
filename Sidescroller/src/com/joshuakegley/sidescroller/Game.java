/**
 *@Author: "Joshua Kegley"
 * 
 *@Project: Sidescroller
 *
 *@Class: Game
 *
 *This game is just a tester game to figure out things, it isn't anything amazing
 *or revolutionary!   
 */
package com.joshuakegley.sidescroller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.enums.GameState;
import com.joshuakegley.sidescroller.gfx.Renderer;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.input.KeyInput;
import com.joshuakegley.sidescroller.input.MouseInput;
import com.joshuakegley.sidescroller.libs.Audio;
import com.joshuakegley.sidescroller.libs.Identities;
import com.joshuakegley.sidescroller.objects.Block;
import com.joshuakegley.sidescroller.screens.Menu;
import com.joshuakegley.sidescroller.utils.AudioPlayer;
import com.joshuakegley.sidescroller.utils.ResourceLoader;

/**
 * @Class Game   
 */
@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "Sidescroller";
	private static Game game = new Game();
	public static GameState state = GameState.MENU;
	
	
	
	private boolean running = false; // by default, I need this to be false so we do not exit our start method right away.
	private Thread thread; //Thread that controls game loop
	private Renderer gfx; // Render Object
	private Menu menu; //Menu Object
	private Controller controller = new Controller(); //Control all game objects
	private Textures tex;
	
	
	public static Game getInstance(){
		return game;  
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public Controller getController(){
		return controller;
	}
	
	public void init() {
		ResourceLoader.loadImages(); //Loads our images and sprites
		ResourceLoader.loadFonts(); //Loads our fonts
		ResourceLoader.loadSounds(); //Loads Sounds
		tex = new Textures();
		menu = new Menu();
		gfx = new Renderer();
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		int x = 0;
		for(int i = 1; i <= 20; i++){
			controller.addObject(new Block(x, HEIGHT - 64, Identities.BLOCK_STONE, tex.blockStone));
//			Controller.addObject(new Block(x, HEIGHT - 250, Identities.BLOCK_METAL, tex, tex.blockMetal));
			x += 32;
		}
		controller.addObject(new Block(400, HEIGHT - 128, Identities.BLOCK_METAL, tex.blockMetal));
		controller.addObject(new Block(400, HEIGHT - (128+32), Identities.BLOCK_METAL, tex.blockMetal));
		controller.addObject(new Block(300, HEIGHT - 300, Identities.BLOCK_METAL, tex.blockMetal));

		//PLAYER OBJECT!
		controller.addObject(new Player(100, HEIGHT - 220, Identities.PLAYER, tex));
		this.addKeyListener(new KeyInput());
		
		AudioPlayer.playMusic(Audio.MUSIC_THEME);//plays theme
		
	}
	
	public void tick() {
		if(state == GameState.GAME){
			controller.tick();
		}
	}	
	
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
	
		g.setColor(new Color(4, 45, 90));
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		//////////////////////////////////////////////////////////////
							   //Draw Here
		//////////////////////////////////////////////////////////////
		
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		
		//////////////////////////////////////////////////////////////
		g.dispose();//Disposes our graphics context(if we did not do this, animations would not properly work, it would also eat up memory)
		bs.show(); //Shows graphics were just disposed of
	}
	
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				//FPS in Title Bar
				Window.setTitle(TITLE + "    FPS: " + frames);
				ticks = 0;
				frames = 0;
				
			}
		}
		
		stop();
	}

	public static void main(String args[]){
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.createWindow();
		game.start();

	}
	
	private synchronized void start(){
		if(running) {
			return;
		}else {
			running = true;
		}
		
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if(!running){
			return;
		}else {
			running = false;
		}
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
		
	}
}
