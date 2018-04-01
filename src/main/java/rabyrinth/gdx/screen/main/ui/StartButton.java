package rabyrinth.gdx.screen.main.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.event.StartButtonClicked;

/** @author Sino */
public final class StartButton extends TextButton {
	/** The label to put inside of the button. */
	private static final String TEXT_CONTENT = "Start Game";

	/** Creates a new {@link StartButton}. */
	StartButton(Skin skin, EventBus eventBus) {
		super(TEXT_CONTENT, skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				eventBus.post(new StartButtonClicked(changeEvent, actor));
			}
		});
	}
}
