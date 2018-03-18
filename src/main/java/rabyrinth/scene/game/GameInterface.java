package rabyrinth.scene.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

/** @author Sino */
public final class GameInterface implements Disposable {
	/** The required skin of assets to use for this interface. */
	private final Skin skin;

	/** The stage to place game components onto. */
	private final Stage stage;

	/** Creates a new {@link GameInterface}. */
	public GameInterface(Skin skin, Stage stage) {
		this.skin = skin;
		this.stage = stage;
	}

	public void hide() {
		// TODO
	}

	public void show() {
		// TODO
	}

	@Override
	public void dispose() {
		// TODO
	}
}
