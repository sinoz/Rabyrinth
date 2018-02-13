package treffik.scene;

import treffik.TreffikComponent;

/** @author I.A */
public final class SceneRoot implements TreffikComponent {
	/** The currently active {@link Scene}. */
	private Scene scene;

	/** Creates a new {@link SceneRoot}. */
	public SceneRoot(Scene initialScene) {
		switchTo(initialScene);
	}

	/** Switches to the specified {@link Scene}. */
	public void switchTo(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void update(float deltaTime) {
		scene.update(deltaTime);
	}

	@Override
	public void render(float deltaTime) {
		scene.render(deltaTime);
	}

	@Override
	public void resize(int width, int height) {
		scene.resize(width, height);
	}

	@Override
	public void pause() {
		scene.pause();
	}

	@Override
	public void resume() {
		scene.resume();
	}

	@Override
	public void dispose() {
		scene.dispose();
	}
}
