package rabyrinth.gdx.screen.level;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.asset.Skins;

/** @author Sino */
public final class LevelSelectScreen implements Screen {
	/** The background for the level select menu. */
	private final LevelSelectBackground background;

	/** Creates a new {@link LevelSelectScreen}. */
	public LevelSelectScreen(Stage stage, AssetManager assets, EventBus eventBus) {
		this.background = new LevelSelectBackground(assets.get(Skins.DEFAULT), eventBus);

		stage.addActor(background);
	}

	@Override
	public void hide() {
		background.setVisible(false);
	}

	@Override
	public void show() {
		background.setVisible(true);
	}

	@Override
	public void render(float v) {
		// TODO
	}

	@Override
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		// TODO
	}
}
