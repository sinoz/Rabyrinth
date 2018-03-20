package rabyrinth.scene.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import rabyrinth.scene.Scene;
import rabyrinth.scene.SceneController;
import rabyrinth.scene.game.GameScene;

/** @author Sino */
public final class LevelSelectScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(Gdx.files.internal("resources/ui/uiskin.json"));

	/** Controls scenes. */
	private final SceneController controller;

	/** The stage to add components to. */
	private final Stage stage;

	/** The background for the level select menu. */
	private final LevelSelectBackground background;

	/** Creates a new {@link LevelSelectScene}. */
	public LevelSelectScene(SceneController controller, Stage stage) {
		this.controller = controller;
		this.stage = stage;
		this.background = new LevelSelectBackground(skin, this);

		stage.addActor(background);
	}

	/** TODO */
	public void switchToGameScene() {
		controller.switchTo(new GameScene(stage));
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
		// TODO
	}
}
