package rabyrinth;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import rabyrinth.scene.SceneController;

/** @author I.A */
public final class Rabyrinth implements ApplicationListener {
	/** The stage to place actors and components onto. */
	private Stage stage;

	/** Keeps track of scenes. */
	private RabyrinthComponent scenes;

	@Override
	public void create() {
		// configures a multiplexer where we can add input processors to that should
		// all listen for user input events (keyboard, mouse etc).
		InputMultiplexer inputMultiplexer = new InputMultiplexer();

		stage = new Stage();
		scenes = new SceneController(stage);

		// add the stage as an input processor for the user interface it will be carrying
		inputMultiplexer.addProcessor(stage);

		// and finally tell gdx that it should make use of our multiplexer
		Gdx.input.setInputProcessor(inputMultiplexer);
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
