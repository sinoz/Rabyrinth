package rabyrinth.scene.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import rabyrinth.scene.Scene;
import rabyrinth.scene.SceneController;
import rabyrinth.scene.game.GameScene;

/** @author Sino */
public final class MainMenuScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(Gdx.files.internal("resources/ui/uiskin.json"));

	/** The user interface for this main menu scene. */
	private final MainMenuInterface mainMenuInterface;

	/** Controls the scenery. */
	private final SceneController sceneController;

	/** The stage. */
	private final Stage stage;

	/** Creates a new {@link MainMenuScene}. */
	public MainMenuScene(SceneController sceneController, Stage stage) {
		this.stage = stage;
		this.mainMenuInterface = new MainMenuInterface(skin, this, stage);
		this.sceneController = sceneController;
	}

	/** Makes the transition from this scene to the {@link GameScene]. */
	public void switchToGameScene() {
		sceneController.switchTo(new GameScene(stage));
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
		mainMenuInterface.hide();
	}

	@Override
	public void show() {
		mainMenuInterface.show();
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
		mainMenuInterface.dispose();
	}
}
