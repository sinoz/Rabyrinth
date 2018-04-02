package rabyrinth.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.screen.event.AssetsLoadedListener;
import rabyrinth.gdx.screen.event.ConfirmedExitListener;
import rabyrinth.gdx.screen.event.LevelSelectedListener;
import rabyrinth.gdx.screen.event.StartButtonClickedListener;
import rabyrinth.gdx.screen.loading.LoadingScreen;

/** @author Sino */
public final class GdxGame extends Game {
	/** Whether this game is to be ran in debug mode. */
	public static final boolean DEBUG_MODE = false;

	/** An event bus to publish user interface events onto. */
	private EventBus eventBus;

	/** Manages all of the required assets. */
	private AssetManager assets;

	/** The stage to place actors and components onto. */
	private Stage stage;

	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());

		assets = new AssetManager();
		eventBus = new EventBus();

		Gdx.input.setInputProcessor(stage);

		subscribeEventListeners();
		setScreen(new LoadingScreen(stage, assets, eventBus));
	}

	private void subscribeEventListeners() {
		eventBus.register(new AssetsLoadedListener(this, stage, eventBus, assets));
		eventBus.register(new LevelSelectedListener(this, assets, stage, eventBus));
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
