package rabyrinth.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.event.AssetsLoadedListener;
import rabyrinth.gdx.event.ConfirmedExitListener;
import rabyrinth.gdx.event.LevelSelectedListener;
import rabyrinth.gdx.event.StartButtonClickedListener;
import rabyrinth.gdx.screen.loading.LoadingScreen;

/** @author Sino */
public final class GdxGame extends Game {
	/** An event bus to publish user interface events onto. */
	private EventBus eventBus;

	/** The multiplexer of input processors. */
	private InputMultiplexer multiplexer;

	/** Manages all of the required assets. */
	private AssetManager assets;

	/** The stage to place actors and components onto. */
	private Stage stage;

	@Override
	public void create() {
		// configures a multiplexer where we can add input processors to that should
		// all listen for user input events (keyboard, mouse etc).
		multiplexer = new InputMultiplexer();

		assets = new AssetManager();
		stage = new Stage(new ScreenViewport());

		// add the stage as an input processor for the user interface it will be carrying
		multiplexer.addProcessor(stage);

		// and finally tell gdx that it should make use of our multiplexer
		Gdx.input.setInputProcessor(multiplexer);

		// the event bus that we'll publish an events to, to decouple interface components from the screens
		eventBus = new EventBus();

		// subscribe our listeners that react to events
		subscribeEventListeners();

		// and instantiate the loading screen
		setScreen(new LoadingScreen(stage, assets, eventBus));
	}

	private void subscribeEventListeners() {
		eventBus.register(new AssetsLoadedListener(this, stage, eventBus, assets));
		eventBus.register(new LevelSelectedListener(this, assets, multiplexer, stage, eventBus));
		eventBus.register(new StartButtonClickedListener(this, assets, stage, eventBus));
		eventBus.register(new ConfirmedExitListener(stage, assets));
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render() {
		clearScreen();
		super.render();
	}

	private void clearScreen() {
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		assets.dispose();
		super.dispose();
	}
}
