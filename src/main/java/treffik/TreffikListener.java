package treffik;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import treffik.scene.SceneRoot;
import treffik.scene.game.GameScene;

/** @author I.A */
public final class TreffikListener implements ApplicationListener {
	/** Keeps track of scenes. */
	private SceneRoot scenes;

	@Override
	public void create() {
		scenes = new SceneRoot(new GameScene());
	}

	@Override
	public void resize(int width, int height) {
		scenes.resize(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		scenes.update(Gdx.graphics.getDeltaTime());
		scenes.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() {
		scenes.pause();
	}

	@Override
	public void resume() {
		scenes.resume();
	}

	@Override
	public void dispose() {
		scenes.dispose();
	}
}
