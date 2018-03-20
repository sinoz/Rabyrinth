package rabyrinth.scene.level;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/** @author Sino */
public final class LevelSelectBackground extends Window {
	private static final String NO_TITLE = "";

	/** Creates a new {@link LevelSelectBackground}. */
	public LevelSelectBackground(Skin skin, LevelSelectScene scene) {
		super(NO_TITLE, skin);

		setFillParent(true);

		for (int levelId = 1; levelId <= 1; levelId++) { // TODO
			add(new LevelSelectButton(skin, levelId, scene));
		}
	}
}
