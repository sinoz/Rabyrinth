package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;

/** @author Sino */
public final class Background extends Table {
	public Background(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");
		setDebug(true);

		Instructions instructions = new Instructions(skin, eventBus);
		Journal journal = new Journal(skin);

		SplitPane pane = new SplitPane(instructions, journal, false, skin);
		add(pane).expandY().fillY();
	}
}
