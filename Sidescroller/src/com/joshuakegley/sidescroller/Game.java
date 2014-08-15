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
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.joshuakegley.sidescroller.entity.Player;
import com.joshuakegley.sidescroller.enums.GameState;
import com.joshuakegley.sidescroller.gfx.Renderer;
import com.joshuakegley.sidescroller.gfx.Texture;
import com.joshuakegley.sidescroller.input.KeyInput;
import com.joshuakegley.sidescroller.input.MouseInput;
import com.joshuakegley.sidescroller.libs.Audio;
import com.joshuakegley.sidescroller.libs.Identities;
import com.joshuakegley.sidescroller.libs.Reference;
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
	private static JFrame frame = new JFrame();
	
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
	private Texture tex;
	
	
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
		tex = new Texture();
		menu = new Menu();
		gfx = new Renderer();
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		int x = 0;
		for(int i = 1; i <= 20; i++){
			Controller.addObject(new Block(x, HEIGHT - 64, Identities.BLOCK_STONE, tex, tex.blockStone));
			x += 32;
		}
		
		//PLAYER OBJECT!
		Controller.addObject(new Player(100,100,30, 70, Identities.PLAYER, tex));
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
				//frame.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: " + frames);
				ticks = 0;
				frames = 0;
				
			}
		}
		
		stop();
	}

	public static void main(String args[]){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Setting image icon to image of 32x32.png
		Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "img/32x32.png");
		//Setting image cursor to image of cursor
		Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "img/cursor.gif");
		frame.add(game);
		frame.setTitle(TITLE);
		frame.setIconImage(icon);
		/**
		 * Replacing Cursor with new Frame Cursor
		 */
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
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
