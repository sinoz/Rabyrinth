package rabyrinth.scene.main.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import rabyrinth.scene.main.MainMenuScene;

/** @author Sino */
public final class Background extends Table {
	/** Creates a new {@link Background}. */
	public Background(Skin skin, MainMenuScene scene) {
		super(skin);

		setFillParent(true);
		setVisible(true);

		add(new Menu(super.getSkin(), this, scene))
				.width(150F)
				.height(200F)
				.center();
	}
}
