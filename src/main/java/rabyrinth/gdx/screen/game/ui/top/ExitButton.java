package rabyrinth.gdx.screen.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.event.ConfirmedExit;

/** @author Sino */
public final class ExitButton extends TextButton {
	public ExitButton(Skin skin, EventBus eventBus) {
		super("Exit", skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				eventBus.post(new ConfirmedExit());
			}
		});
	}
}