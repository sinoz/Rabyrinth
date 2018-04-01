package rabyrinth.gdx.event;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.asset.Sounds;
import rabyrinth.gdx.screen.game.GameScreen;

/** @author Sino */
public final class LevelSelectedListener {
	private final Game game;
	private final AssetManager assets;
	private final Stage stage;
	private final EventBus eventBus;

	public LevelSelectedListener(Game game, AssetManager assets, Stage stage, EventBus eventBus) {
		this.game = game;
		this.assets = assets;
		this.stage = stage;
		this.eventBus = eventBus;
	}

	@Subscribe
	public void levelSelected(LevelSelected levelSelected) {
		assets.get(Sounds.MUSIC_THE_WAE).stop();
		assets.get(Sounds.MUST_PRAY).play();

		game.setScreen(new GameScreen(stage, assets, eventBus));
	}
}
