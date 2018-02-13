package treffik.scene.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import treffik.TreffikComponent;

/** @author I.A */
public final class World implements TreffikComponent {
	/** Used to load {@link TiledMap}s from TMX files. */
	private final TmxMapLoader mapLoader = new TmxMapLoader();

	/** The renderer to use for this game world. */
	private final WorldRenderer renderer;

	/** The camera. */
	private final OrthographicCamera camera;

	/** The currently active {@link TiledMap}. */
	private TiledMap activeMap;

	/** Creates a new {@link World}. */
	public World(OrthographicCamera camera) {
		this.camera = camera;
		this.renderer = new WorldRenderer(new IsometricTiledMapRenderer(getCurrentlyActiveMap()), camera);
	}

	private TiledMap getCurrentlyActiveMap() {
		if (activeMap == null) {
			activeMap = mapLoader.load("resources/maps/tmx/IsometricDemo.tmx");
		}

		return activeMap;
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
