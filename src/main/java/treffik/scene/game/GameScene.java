package treffik.scene.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import treffik.scene.Scene;
import treffik.scene.game.world.World;

/** @author I.A */
public final class GameScene implements Scene {
	/** The camera. */
	private final OrthographicCamera camera;

	/** The game world. */
	private final World world;

	/** Creates a new {@link GameScene}. */
	public GameScene() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.world = new World(camera);
	}

	@Override
	public void update(float deltaTime) {
		world.update(deltaTime);
	}

	@Override
	public void render(float deltaTime) {
		world.render(deltaTime);
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
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void dispose() {
		world.dispose();
	}
}
