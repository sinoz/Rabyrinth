package rabyrinth.scene.game.world;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import rabyrinth.RabyrinthComponent;
import rabyrinth.scene.game.world.map.MapController;
import rabyrinth.scene.game.world.map.MapType;

/** @author I.A */
public final class World implements RabyrinthComponent {
	/** The tile unit scale. */
	private static final float TILE_UNIT_SCALE = 1 / 16F;

	private final BatchTiledMapRenderer renderer;
	private final OrthographicCamera camera;

	/** Controls which map to draw. */
	private final MapController mapController;

	/** Creates a new {@link World}. */
	public World(InputMultiplexer multiplexer) {
		multiplexer.addProcessor(new WorldInputProcessor(this));

		mapController = new MapController();
		mapController.switchTo(MapType.ORTHOGONAL);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 32, 32);

		renderer = new OrthogonalTiledMapRenderer(mapController.getActiveMap(), TILE_UNIT_SCALE);
	}

	public void switchTo(MapType type) {
		mapController.switchTo(type);
//		renderer.setRenderTargetMap(mapController.getActiveMap());
	}

	public void zoom(boolean zoomIn) {
		if (zoomIn) {
			camera.zoom += 0.02;
		} else {
			camera.zoom -= 0.02;
		}

		camera.update();
	}

	@Override
	public void update(float deltaTime) {

	}

	@Override
	public void render(float deltaTime) {
		renderer.setView(camera);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
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
