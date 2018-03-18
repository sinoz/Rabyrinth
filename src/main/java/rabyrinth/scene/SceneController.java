package rabyrinth.scene;

import com.badlogic.gdx.scenes.scene2d.Stage;
import rabyrinth.RabyrinthComponent;
import rabyrinth.scene.main.MainMenuScene;

/** @author I.A */
public final class SceneController implements RabyrinthComponent {
	/** The stage. */
	private Stage stage;

	/** The currently active {@link Scene}. */
	private Scene scene;

	/** Creates a new {@link SceneController}. */
	public SceneController(Stage stage) {
		this.stage = stage;

		switchTo(new MainMenuScene(this, stage));
	}

	/** Switches to the specified {@link Scene}. */
	public void switchTo(Scene scene) {
		if (this.scene != null) {
			this.scene.hide();
		}

		this.scene = scene;

		if (this.scene != null) {
			this.scene.show();
		}
	}

	@Override
	public void update(float deltaTime) {
		stage.act(deltaTime);
		scene.update(deltaTime);
	}

	@Override
	public void render(float deltaTime) {
		scene.render(deltaTime);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		scene.resize(width, height);
	}

	@Override
	public void show() {
		scene.show();
	}

	@Override
	public void hide() {
		scene.hide();
	}

	@Override
	public void pause() {
		scene.pause();
	}

	@Override
	public void resume() {
		scene.resume();
	}

	@Override
	public void dispose() {
		scene.dispose();
	}
}
