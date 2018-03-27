package rabyrinth.scene.main.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;

/** @author Sino */
public final class Background extends Table {
	/** Creates a new {@link Background}. */
	public Background(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");
		setFillParent(true);
		setVisible(true);

		add(new Menu(super.getSkin(), this, eventBus))
				.width(150F)
				.height(200F)
				.center();
	}
}
