package rabyrinth.gdx.screen.level;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.screen.event.LevelSelected;

/** @author Sino */
public final class LevelSelectButton extends TextButton {
	public LevelSelectButton(Skin skin, final int levelId, final EventBus eventBus) {
		super("Level " + levelId, skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				eventBus.post(new LevelSelected(levelId, changeEvent, actor));
			}
		});
	}
}
