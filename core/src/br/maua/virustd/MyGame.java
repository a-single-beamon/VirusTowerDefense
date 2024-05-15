package br.maua.virustd;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class MyGame extends ApplicationAdapter {
	private final int SCREEN_WIDTH;
	private final int SCREEN_HEIGHT;
	private final int SPRITE_SIZE;
	private final int SPAWN_DELAY_SECONDS = 1;

	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle bucket;
	private Vector3 touchPos;
	private boolean moveBucket;
	private Array<Rectangle> raindrops;
	private long lastDropTime;

	MyGame(int screen_width, int screen_height, int sprite_size) {
		SCREEN_HEIGHT = screen_height;
		SCREEN_WIDTH = screen_width;
		SPRITE_SIZE = sprite_size;
	}

	private void spawnRaindrop() {

		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, SCREEN_WIDTH - SPRITE_SIZE);
		raindrop.y = SCREEN_WIDTH;
		raindrop.width = SPRITE_SIZE / 2;
		raindrop.height = SPRITE_SIZE / 2;

		raindrops.add(raindrop);

		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void create() {
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
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

		// creating batch
		batch = new SpriteBatch();

		// mouse tracker
		touchPos = new Vector3();
		moveBucket = false;

		raindrops = new Array<Rectangle>();
		spawnRaindrop();

		bucket = new Rectangle();
		bucket.x = SCREEN_HEIGHT / 2 - SPRITE_SIZE / 2;
		bucket.y = 20;
		bucket.width = SPRITE_SIZE;
		bucket.height = SPRITE_SIZE;
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		for (Rectangle raindrop : raindrops) {
			batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		batch.end();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
			moveBucket = !moveBucket;

		if (moveBucket) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			// bucket.x = touchPos.x - 64 / 2;
			bucket.x = MathUtils.clamp(touchPos.x - SPRITE_SIZE, 0, SCREEN_WIDTH - SPRITE_SIZE);
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

		// bucket.x = MathUtils.clamp(bucket.x, 0, 800 - 64);
	}

	@Override
	public void dispose() {
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}
}
