package rabyrinth.gdx.screen.event;

import com.badlogic.gdx.assets.AssetManager;
import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.asset.Sounds;
import rabyrinth.gdx.screen.game.GameScreen;

/** @author Sino */
public final class QueenReachedListener {
	private final AssetManager assets;
	private final GameScreen screen;

	public QueenReachedListener(GameScreen screen, AssetManager assets) {
		this.screen = screen;
		this.assets = assets;
	}

	@Subscribe
	public void queenReached(QueenReached event) {
		assets.get(Sounds.MUSIC_THE_WAE).stop();
		assets.get(Sounds.MY_BROS).play();

		event.getAvatar().pending.clear();
		event.getQueen().hidden = true;

		screen.getTopBackground().getObjective().setText("Objective completed!");
	}
}
