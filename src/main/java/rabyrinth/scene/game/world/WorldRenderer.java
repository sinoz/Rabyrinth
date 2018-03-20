package rabyrinth.scene.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

/** @author I.A */
public final class WorldRenderer implements Disposable {
	/** The renderer implementation used to render the tiled map of the game world. */
	private final BatchTiledMapRenderer renderer;

	/** The camera. */
	private final OrthographicCamera camera;

	/** Creates a new {@link WorldRenderer}. */
	public WorldRenderer(BatchTiledMapRenderer renderer, OrthographicCamera camera) {
		this.renderer = renderer;
		this.camera = camera;
	}

	/** Switches to the specified {@link TiledMap} for rendering. */
	public void setRenderTargetMap(TiledMap map) {
		this.renderer.setMap(map);
	}

	public void render(float deltaTime) {
		renderer.setView(camera);
		renderer.render();
	}

	@Override
	public void dispose() {
		renderer.dispose();
	}
}
