package rabyrinth.scene.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import rabyrinth.scene.Scene;
import rabyrinth.scene.SceneController;
import rabyrinth.scene.level.LevelSelectScene;
import rabyrinth.scene.main.ui.Background;

/** @author Sino */
public final class MainMenuScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(Gdx.files.internal("resources/ui/uiskin.json"));

	/** Controls the scenery. */
	private final SceneController sceneController;

	/** The user interface background for this main menu. */
	private final Background background;

	/** The stage. */
	private final Stage stage;

	private InputMultiplexer multiplexer;

	/** Creates a new {@link MainMenuScene}. */
	public MainMenuScene(SceneController sceneController, Stage stage, InputMultiplexer multiplexer) {
		this.stage = stage;
		this.sceneController = sceneController;
		this.background = new Background(skin, this);
		this.multiplexer = multiplexer;

		stage.addActor(background);
	}

	/** Makes the transition from this scene to the {@link LevelSelectScene]. */
	public void switchToLevelSelectScene() {
		sceneController.switchTo(new LevelSelectScene(sceneController, stage, multiplexer));
	}

	@Override
	public void update(float deltaTime) {
		// TODO
	}

	@Override
	public void render(float deltaTime) {
		// TODO
	}

	@Override
	public void pause() {
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
	public void resume() {
		// TODO
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
