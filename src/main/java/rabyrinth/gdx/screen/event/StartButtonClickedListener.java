package rabyrinth.gdx.screen.event;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.screen.level.LevelSelectScreen;

/** @author Sino */
public final class StartButtonClickedListener {
	private final Game gdxGame;
	private final Stage stage;
	private final EventBus eventBus;
	private final AssetManager assets;

	public StartButtonClickedListener(Game game, AssetManager assets, Stage stage, EventBus eventBus) {
		this.gdxGame = game;
		this.stage = stage;
		this.eventBus = eventBus;
		this.assets = assets;
	}

	@Subscribe
	public void startButtonClicked(StartButtonClicked startButtonClicked) {
		gdxGame.setScreen(new LevelSelectScreen(stage, assets, eventBus));
	}
}
