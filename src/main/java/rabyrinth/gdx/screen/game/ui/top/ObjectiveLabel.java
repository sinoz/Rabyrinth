package rabyrinth.gdx.screen.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** @author Sino */
public final class ObjectiveLabel extends Label {
	public ObjectiveLabel(Skin skin) {
		super("Objective: None", skin);
	}

	public void set(String objective) {
		setText("Objective: " + objective);
	}
}
