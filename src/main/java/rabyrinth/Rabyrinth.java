package rabyrinth;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.Scene;
import rabyrinth.scene.event.ConfirmedExitListener;
import rabyrinth.scene.event.LevelSelectedListener;
import rabyrinth.scene.event.StartButtonClickedListener;
import rabyrinth.scene.main.MainMenuScene;

/** @author Sino */
public final class Rabyrinth implements ApplicationListener {
	/** An event bus to publish user interface events onto. */
	private EventBus eventBus;

	/** The multiplexer of input processors. */
	private InputMultiplexer multiplexer;

	/** The stage to place actors and components onto. */
	private Stage stage;

	/** The currently active {@link Scene}. */
	private Scene scene;

	@Override
	public void create() {
		// configures a multiplexer where we can add input processors to that should
		// all listen for user input events (keyboard, mouse etc).
		multiplexer = new InputMultiplexer();

		stage = new Stage(new ScreenViewport());

		// add the stage as an input processor for the user interface it will be carrying
		multiplexer.addProcessor(stage);

		// and finally tell gdx that it should make use of our multiplexer
		Gdx.input.setInputProcessor(multiplexer);

		// the event bus that we'll publish an events to, to decouple interface components from the scene
		eventBus = new EventBus();

		// subscribe our listeners that react to events
		subscribeEventListeners();

		// and instantiate the first scene
		switchTo(new MainMenuScene(stage, eventBus));
	}

	private void subscribeEventListeners() {
		eventBus.register(new StartButtonClickedListener(this, stage, eventBus));
		eventBus.register(new ConfirmedExitListener(stage));

		eventBus.register(new LevelSelectedListener(this, multiplexer, stage, eventBus));
	}

	/** Switches to the specified {@link Scene}. */
	public void switchTo(Scene scene) {
		if (this.scene != null) {
			this.scene.hide();
		}

		this.scene = scene;

		if (this.scene != null) {
			this.scene.show();
		}
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		scene.resize(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		scene.update();
		scene.render();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void pause() {
		Gdx.graphics.setContinuousRendering(false);
	}

	@Override
	public void resume() {
		Gdx.graphics.setContinuousRendering(true);
	}

	@Override
	public void dispose() {
		scene.dispose();
	}
}
