package rabyrinth.scene.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.Scene;

/** @author Sino */
public final class LevelSelectScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(Gdx.files.internal("resources/ui/uiskin.json"));

	/** The stage to add components to. */
	private final Stage stage;

	/** The background for the level select menu. */
	private final LevelSelectBackground background;

	/** Creates a new {@link LevelSelectScene}. */
	public LevelSelectScene(Stage stage, EventBus eventBus) {
		this.stage = stage;
		this.background = new LevelSelectBackground(skin, eventBus);

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
		// TODO
	}
}
