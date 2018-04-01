package rabyrinth.gdx.screen.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** @author Sino */
public final class LevelDisplay extends Label {
	public LevelDisplay(int initialLevel, Skin skin) {
		super("Level: " + initialLevel, skin);
	}

	public void setLevel(int level) {
		setText("Level: " + level);
	}
}
