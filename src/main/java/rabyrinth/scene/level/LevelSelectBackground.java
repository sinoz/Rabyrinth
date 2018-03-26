package rabyrinth.scene.level;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/** @author Sino */
public final class LevelSelectBackground extends Table {
	/** Creates a new {@link LevelSelectBackground}. */
	public LevelSelectBackground(Skin skin, LevelSelectScene scene) {
		super(skin);

		setBackground("default-background");
		setFillParent(true);

		for (int levelId = 1; levelId <= 1; levelId++) { // TODO
			add(new LevelSelectButton(skin, levelId, scene));
		}
	}
}
