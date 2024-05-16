package br.maua.virustd;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends Game {
    private final int SCREEN_WIDTH;
	private final int SCREEN_HEIGHT;
	private final int SPRITE_SIZE;

    public SpriteBatch batch;
    public BitmapFont font;

    public Drop(int screenWidth, int screenHeight, int spriteSize) {
        SCREEN_WIDTH = screenWidth;
        SCREEN_HEIGHT = screenHeight;
        SPRITE_SIZE = spriteSize;
    }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(); // default libGDX font (Arial)
        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public int getSpriteSize() {
        return SPRITE_SIZE;
    }
    
}
