package rabyrinth.scene.main;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;
import rabyrinth.scene.main.ui.Background;

/** @author Sino */
public final class MainMenuInterface implements Disposable {
	/** The required skin of assets to use for this interface. */
	private final Skin skin;

	/** The scene. */
	private final MainMenuScene scene;

	/** The stage to place main menu components onto. */
	private final Stage stage;

	/** The background. */
	private final Background background;

	/** Creates a new {@link MainMenuInterface}. */
	public MainMenuInterface(Skin skin, MainMenuScene scene, Stage stage) {
		this.skin = skin;
		this.scene = scene;
		this.stage = stage;

		this.background = new Background(skin, scene);
		stage.addActor(background);
	}

	public void hide() {
		background.setVisible(false);
	}

	public void show() {
		background.setVisible(true);
	}

	@Override
	public void dispose() {
		// TODO
	}
}
