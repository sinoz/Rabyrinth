package rabyrinth.gdx.screen.level;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.asset.Skins;

/** @author Sino */
public final class LevelSelectScreen implements Screen {
	/** The {@link Stage}. */
	private final Stage stage;

	/** The background for the level select menu. */
	private final LevelSelectBackground background;

	/** Creates a new {@link LevelSelectScreen}. */
	public LevelSelectScreen(Stage stage, AssetManager assets, EventBus eventBus) {
		this.stage = stage;
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
	public void render(float deltaTime) {
		stage.act(deltaTime);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// nothing
	}

	@Override
	public void resume() {
		// nothing
	}

	@Override
	public void dispose() {
		// TODO
	}
}
