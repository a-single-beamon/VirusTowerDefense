package br.maua.virustd;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {
	private final Drop game;

	private final int SPAWN_DELAY_SECONDS = 1;

	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;
	private OrthographicCamera camera;
	private Rectangle bucket;
	private Vector3 mousePos;
	private boolean moveBucket;
	private Array<Rectangle> raindrops;
	private long lastDropTime;

	public GameScreen(Drop game) {
		this.game = game;

		// load the sprites used in game
		dropImage = new Texture(Gdx.files.internal("droplet-export.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		// load the music and sound effects
		dropSound = Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("undertreeinrain.mp3"));

		// start music playback
		rainMusic.setLooping(true);
		rainMusic.play();

		// camera and sprite batch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.getScreenWidth(), game.getScreenHeight());

		// creating batch
		game.batch = new SpriteBatch();

		// mouse tracker
		mousePos = new Vector3();
		moveBucket = true;

		raindrops = new Array<Rectangle>();
		spawnRaindrop();

		bucket = new Rectangle();
		bucket.x = game.getScreenHeight() / 2 - game.getSpriteSize() / 2;
		bucket.y = 20;
		bucket.width = game.getSpriteSize();
		bucket.height = game.getSpriteSize();
	}

	private void spawnRaindrop() {

		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, game.getScreenWidth() - game.getSpriteSize());
		raindrop.y = game.getScreenHeight();
		raindrop.width = game.getSpriteSize() / 2;
		raindrop.height = game.getSpriteSize() / 2;

		raindrops.add(raindrop);

		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(bucketImage, bucket.x, bucket.y);
		for (Rectangle raindrop : raindrops) {
			game.batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		game.batch.end();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
			moveBucket = !moveBucket;

		if (moveBucket) {
			mousePos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(mousePos);
			bucket.x = MathUtils.clamp(mousePos.x - game.getSpriteSize() / 2, 0, game.getScreenWidth() - game.getSpriteSize());
		}

		if (TimeUtils.nanoTime() - lastDropTime > SPAWN_DELAY_SECONDS * 1000000000)
			spawnRaindrop();

		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext();) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if (raindrop.overlaps(bucket)) {
				dropSound.play();
				iter.remove();
			} else if (raindrop.y < 0)
				iter.remove();
		}
	}

	@Override
	public void dispose() {
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
	}

	@Override
	public void show() {
		rainMusic.play();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}
}
