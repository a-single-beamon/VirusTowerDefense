package br.maua.virustd;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// import br.maua.virustd.MyGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	public void runGame() {
		final int SCREEN_WIDTH = 800;
		final int SCREEN_HEIGHT = 480;
		final int SPRITE_SIZE = 64;
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Drop");
		config.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
		config.useVsync(true);
		config.setForegroundFPS(60);
		// new Lwjgl3Application(new MyGame(SCREEN_WIDTH, SCREEN_HEIGHT, SPRITE_SIZE), config);
		new Lwjgl3Application(new Drop(SCREEN_WIDTH, SCREEN_HEIGHT, SPRITE_SIZE), config);
	}
	public static void main (String[] arg) {
		DesktopLauncher dl = new DesktopLauncher();
		dl.runGame();
	}
}
