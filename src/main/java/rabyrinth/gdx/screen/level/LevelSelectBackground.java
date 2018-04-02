package rabyrinth.gdx.screen.level;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.GdxGame;

/** @author Sino */
public final class LevelSelectBackground extends Table {
	/** Creates a new {@link LevelSelectBackground}. */
	public LevelSelectBackground(Skin skin, EventBus eventBus) {
		super(skin);

		setDebug(GdxGame.DEBUG_MODE);
		setBackground("default-background");
		setFillParent(true);

		for (int levelId = 1; levelId <= 1; levelId++) { // TODO
			add(new LevelSelectButton(skin, levelId, eventBus));
		}
	}
}
