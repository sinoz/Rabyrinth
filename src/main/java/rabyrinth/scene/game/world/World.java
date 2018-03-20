package rabyrinth.scene.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import rabyrinth.RabyrinthComponent;
import rabyrinth.scene.game.world.map.MapController;
import rabyrinth.scene.game.world.map.MapType;

/** @author I.A */
public final class World implements RabyrinthComponent {
	/** The renderer to use for this game world. */
	private final WorldRenderer renderer;

	/** Controls which map to draw. */
	private final MapController mapController;

	/** The camera. */
	private final OrthographicCamera camera;

	/** Creates a new {@link World}. */
	public World() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.mapController = new MapController();
		this.renderer = new WorldRenderer(new IsometricTiledMapRenderer(mapController.getActiveMap()), camera);
	}

	public void switchTo(MapType type) {
		mapController.switchTo(type);
		renderer.setRenderTargetMap(mapController.getActiveMap());
	}

	@Override
	public void update(float deltaTime) {
		// TODO
	}

	@Override
	public void render(float deltaTime) {
		renderer.render(deltaTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		// TODO
	}

	@Override
	public void resume() {
		// TODO
	}

	@Override
	public void dispose() {
		renderer.dispose();
	}
}
