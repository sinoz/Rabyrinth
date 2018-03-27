package rabyrinth.scene.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

/** @author Sino */
public final class World implements Disposable {
	private TiledMap tiledMap;

	private final OrthographicCamera camera;
	private final BatchTiledMapRenderer renderer;
	private final Avatar avatar;

	/** Creates a new {@link World}. */
	public World(InputMultiplexer multiplexer) {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();

		tiledMap = new TmxMapLoader().load("resources/maps/tmx/orthogonal.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap);

		avatar = new Avatar(this);

		multiplexer.addProcessor(new WorldInputProcessor(this));
	}

	/** Updates the world and its subordinates. */
	public void update() {
		camera.update();
	}

	/** Draws the world and its subordinates. */
	public void render() {
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// renders the map using the camera coordinate system
		renderer.setView(camera);
		renderer.render();

		// draws the avatar's knuckles sprite onto the sprite batch of the map renderer
		renderer.getBatch().begin();
		avatar.draw(renderer.getBatch());
		renderer.getBatch().end();
	}

	/** Enables rendering of the game world. */
	public void show() {
		// TODO
	}

	/** Disables rendering of the game world. */
	public void hide() {
		// TODO
	}

	/** Reacts to a resize event, properly scaling the world. */
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void dispose() {
		tiledMap.dispose();
		renderer.dispose();
		avatar.dispose();
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public BatchTiledMapRenderer getRenderer() {
		return renderer;
	}

	public Avatar getAvatar() {
		return avatar;
	}
}
