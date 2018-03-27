package rabyrinth.scene.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.Scene;
import rabyrinth.scene.main.ui.Background;

/** @author Sino */
public final class MainMenuScene implements Scene {
	/** The user interface background for this main menu. */
	private final Background background;

	/** Creates a new {@link MainMenuScene}. */
	public MainMenuScene(Stage stage, EventBus eventBus) {
		this.background = new Background(new Skin(Gdx.files.internal("resources/ui/uiskin.json")), eventBus);

		stage.addActor(background);
	}

	@Override
	public void update() {
		// TODO
	}

	@Override
	public void render() {
		// TODO
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
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void dispose() {
		// nothing
	}
}
