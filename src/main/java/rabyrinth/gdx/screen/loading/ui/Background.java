package rabyrinth.gdx.screen.loading.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import rabyrinth.gdx.GdxApplication;

/** @author Sino */
public final class Background extends Table {
	public final ProgressText progressText;

	public Background(Skin skin) {
		super(skin);

		setDebug(GdxApplication.DEBUG_MODE);
		setBackground("default-background");
		setFillParent(true);

		progressText = new ProgressText(skin);
		add(progressText);
	}
}
