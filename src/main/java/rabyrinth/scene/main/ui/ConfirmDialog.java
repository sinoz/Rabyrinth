package rabyrinth.scene.main.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** @author Sino */
public final class ConfirmDialog extends Dialog {
	/** Creates a new {@link ConfirmDialog}. */
	ConfirmDialog(Skin skin) {
		super("Warning", skin);

		setWidth(250F);
		setHeight(250F);

		setResizable(false);
		setMovable(true);

		text("Are you sure you would like to quit?");

		button("Yes", true);
		button("No", false);
	}

	@Override
	protected void result(Object object) {
		if (object == Boolean.TRUE) {
			Gdx.app.exit();
		}
	}
}
