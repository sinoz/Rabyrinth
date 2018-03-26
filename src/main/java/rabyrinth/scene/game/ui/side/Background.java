package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public final class Background extends Table {
	public Background(Skin skin) {
		super(skin);

		setBackground("default-background");

		Instructions instructions = new Instructions(skin);
		Journal journal = new Journal(skin);

		SplitPane pane = new SplitPane(instructions, journal, false, skin);
		add(pane).expandY().fillY();
	}
}
