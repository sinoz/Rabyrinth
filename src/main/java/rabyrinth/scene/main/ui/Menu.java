package rabyrinth.scene.main.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.main.MainMenuScene;

/** @author Sino */
public final class Menu extends Window {
	/** The title of this menu. */
	private static final String TITLE = "Select an Option";

	/** Creates a new {@link Menu}. */
	Menu(Skin skin, Background background, EventBus eventBus) {
		super(TITLE, skin);

		setModal(true);

		setMovable(false);
		setResizable(false);

		defaults().width(125F);

		add(new StartButton(getSkin(), eventBus)).center().row();
		add(new ExitButton(getSkin(), background, eventBus)).center().row();
	}
}
