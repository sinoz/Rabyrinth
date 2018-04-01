package rabyrinth.gdx.screen.loading.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** @author Sino */
public final class ProgressText extends Label {
	public ProgressText(Skin skin) {
		super("Loading... 0%", skin);
	}

	public void setPercentage(float percentage) {
		setText("Loading... " + percentage + "%");
	}
}
