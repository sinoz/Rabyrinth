package rabyrinth.scene.main.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;

/** @author Sino */
public final class ExitButton extends TextButton {
	ExitButton(Skin skin, Background background, EventBus eventBus) {
		super("Exit", skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				background.row();
				background.add(new ConfirmDialog(skin, eventBus));
			}
		});
	}
}
