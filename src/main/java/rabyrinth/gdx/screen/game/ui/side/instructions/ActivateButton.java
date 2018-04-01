package rabyrinth.gdx.screen.game.ui.side.instructions;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.screen.game.event.ActivateButtonClicked;

/** @author Sino */
public final class ActivateButton extends TextButton {
	public ActivateButton(Skin skin, EventBus eventBus) {
		super("Activate", skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				eventBus.post(new ActivateButtonClicked(changeEvent, actor));
			}
		});
	}
}
