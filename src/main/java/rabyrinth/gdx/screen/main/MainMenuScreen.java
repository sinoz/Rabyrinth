package rabyrinth.gdx.screen.main;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.asset.Skins;
import rabyrinth.gdx.screen.main.ui.Background;

/** @author Sino */
public final class MainMenuScreen implements Screen {
	/** The user interface background for this main menu. */
	private final Background background;

	/** Creates a new {@link MainMenuScreen}. */
	public MainMenuScreen(Stage stage, AssetManager assets, EventBus eventBus) {
		this.background = new Background(assets.get(Skins.DEFAULT), eventBus);

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
		// nothing
	}
}
