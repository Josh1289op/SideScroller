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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.enums.GameState;
import com.joshuakegley.sidescroller.gfx.Renderer;
import com.joshuakegley.sidescroller.gfx.Textures;
import com.joshuakegley.sidescroller.input.KeyInput;
import com.joshuakegley.sidescroller.input.MouseInput;
import com.joshuakegley.sidescroller.libs.Audio;
import com.joshuakegley.sidescroller.libs.Identities;
import com.joshuakegley.sidescroller.libs.Reference;
import com.joshuakegley.sidescroller.screens.LoadScreen;
import com.joshuakegley.sidescroller.screens.Menu;
import com.joshuakegley.sidescroller.utils.AudioPlayer;
import com.joshuakegley.sidescroller.utils.ResourceLoader;
import com.joshuakegley.sidescroller.utils.files.TextFile;
import com.joshuakegley.sidescroller.world.Level;

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
	public static GameState state = GameState.LOADING;
	
	
	
	private boolean running = false; // by default, I need this to be false so we do not exit our start method right away.
	private Thread thread; //Thread that controls game loop
	private Renderer gfx; // Render Object
	private Camera camera;//Our Camera
	private Menu menu; //Menu Object
	private Controller controller = new Controller(); //Control all game objects
	private Textures tex;

	public Level levelOne;
	
	private int time = 100;
	private int counter = 0;
	
	
	
	public static Game getInstance(){
		return game;  
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public Controller getController(){
		return controller;
	}
	
	public Textures getTextureHandler(){
		return tex;
	}
	
	public void init() {
		//add preload image here later
		
		TextFile.writeFile("./text.txt", "test 344343");
		System.out.println(TextFile.readFile("./text.txt"));
	}
	
	private void load(){
		switch(counter){
		case 0:
			ResourceLoader.loadImages(); //Loads our images and sprites
			counter++;
			LoadScreen.loadMore();
			return;
		case 1:
			ResourceLoader.loadFonts(); //Loads our fonts
			counter++;
			LoadScreen.loadMore();
			return;
		case 2:
			ResourceLoader.loadSounds(); //Loads Sounds
			counter++;
			LoadScreen.loadMore();
			return;
		case 3:
			tex = new Textures();
			counter++;
			LoadScreen.loadMore();
			return;
		case 4:
			menu = new Menu();
			counter++;
			LoadScreen.loadMore();
			return;
		case 5:
			gfx = new Renderer();
			counter++;
			LoadScreen.loadMore();
			return;
		case 6:
			MouseInput mouse = new MouseInput();
			this.addMouseListener(mouse);
			this.addMouseMotionListener(mouse);
			levelOne = new Level(1);
			counter++;
			LoadScreen.loadMore();
			return;
		case 7:
			//PLAYER OBJECT!
			controller.addObject(new Player(100, HEIGHT - 220, Identities.PLAYER, tex));
			camera = new Camera(0, 0);
			this.addKeyListener(new KeyInput());
			counter++;
			LoadScreen.loadMore();
			return;
		case 8:
			counter++;
			LoadScreen.loadMore();
			state = GameState.MENU;
			AudioPlayer.playMusic(Audio.MUSIC_THEME);//plays theme

			return;
			
		}
		
	}
	
	
	
//	public void initCamera(){
//		camera = new Camera(0, 0);
//	}
//	
//	public void addKeys(){
//		this.addKeyListener(new KeyInput());
//	}
//	
	
	
	public void tick() {
		if(state == GameState.LOADING){
			time--;
			if(time <= 0){
				load();
				time = 50;
			}
		}
		if(state == GameState.GAME){
			controller.tick();
			camera.tick();
		}
	}	
	
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Reference.level1);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		//////////////////////////////////////////////////////////////
							   //Draw Here
		//////////////////////////////////////////////////////////////
		if(state == GameState.LOADING){
			LoadScreen.render(g);
		}else{
			
			gfx.renderBackground(g);
			if(camera != null){
				g2d.translate(camera.getX(), camera.getY()); //do this before the foreground and after the background
			}
			gfx.renderForeground(g);
			if(camera != null){
				g2d.translate(-camera.getX(), -camera.getY());  //do this after the foreground
			}

		}			
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
		
		
		cleanUp();
		
		System.exit(1);
		
	}
	
	private void cleanUp(){
		AL.destroy();
	}
	
	public static void exit(){
		game.stop();
	}
	
}
