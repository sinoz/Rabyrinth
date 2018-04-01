package rabyrinth.gdx.event;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.asset.Sounds;
import rabyrinth.gdx.screen.main.MainMenuScreen;

/** @author Sino */
public final class AssetsLoadedListener {
	private final Stage stage;
	private final Game game;
	private final EventBus eventBus;
	private final AssetManager assetManager;

	public AssetsLoadedListener(Game game, Stage stage, EventBus eventBus, AssetManager assets) {
		this.stage = stage;
		this.game = game;
		this.eventBus = eventBus;
		this.assetManager = assets;
	}

	@Subscribe
	public void assetsLoaded(AssetsLoaded event) {
		assetManager.get(Sounds.MUSIC_THE_WAE).play();
		game.setScreen(new MainMenuScreen(stage, assetManager, eventBus));
	}
}
