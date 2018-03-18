package rabyrinth.scene.main.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import rabyrinth.scene.main.MainMenuScene;

/** @author Sino */
public final class StartButton extends TextButton {
	/** The label to put inside of the button. */
	private static final String TEXT_CONTENT = "Start Game";

	/** Creates a new {@link StartButton}. */
	StartButton(Skin skin, MainMenuScene scene) {
		super(TEXT_CONTENT, skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				scene.switchToGameScene();
			}
		});
	}
}
