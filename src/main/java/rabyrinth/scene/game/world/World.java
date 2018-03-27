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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** @author Sino */
public final class World implements Disposable {
	private TiledMap tiledMap;

	private final Viewport viewport;

	private final OrthographicCamera camera;
	private final BatchTiledMapRenderer renderer;
	private final Avatar avatar;

	/** Simple flag to decide whether this world should be rendered or not. */
	private boolean mayRender;

	/** Creates a new {@link World}. */
	public World(InputMultiplexer multiplexer) {
		float appWidth = Gdx.graphics.getWidth();
		float appHeight = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, appWidth, appHeight);

		viewport = new ScreenViewport(camera);

		tiledMap = new TmxMapLoader().load("resources/maps/tmx/orthogonal.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap);

		avatar = new Avatar(this);

		multiplexer.addProcessor(new WorldInput(this));
	}

	/** Updates the world and its subordinates. */
	public void update() {
		camera.update();
	}

	/** Draws the world and its subordinates. */
	public void render() {
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (mayRender) {
			// renders the map using the camera coordinate system
			renderer.setView(camera);
			renderer.render();

			// draws the avatar's knuckles sprite onto the sprite batch of the map renderer
			renderer.getBatch().begin();
			avatar.draw(renderer.getBatch());
			renderer.getBatch().end();
		}
	}

	/** Enables rendering of the game world. */
	public void show() {
		mayRender = true;
	}

	/** Disables rendering of the game world. */
	public void hide() {
		mayRender = false;
	}

	/** Reacts to a resize event, properly scaling the world. */
	public void resize(int width, int height) {
		viewport.update(width, height, false);
	}

	@Override
	public void dispose() {
		tiledMap.dispose();
		renderer.dispose();
		avatar.dispose();
	}

	public int getTileWidth() {
		return tiledMap.getTileSets().getTileSet(0).getProperties().get("tilewidth", Integer.class);
	}

	public int getTileHeight() {
		return tiledMap.getTileSets().getTileSet(0).getProperties().get("tileheight", Integer.class);
	}

	public int getMapWidth() {
		return tiledMap.getProperties().get("width", Integer.class);
	}

	public int getMapHeight() {
		return tiledMap.getProperties().get("height", Integer.class);
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
