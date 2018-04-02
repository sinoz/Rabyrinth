package rabyrinth.gdx.screen.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.GdxGame;

/** @author Sino */
public final class Background extends Table {
	private final Journal journal;

	public Background(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");
		setDebug(GdxGame.DEBUG_MODE);

		Instructions instructions = new Instructions(skin, eventBus);
		journal = new Journal(skin);

		ScrollPane scrollPane = new ScrollPane(journal, skin);

		scrollPane.setFadeScrollBars(false);
		scrollPane.setScrollbarsOnTop(true);

		SplitPane pane = new SplitPane(instructions, scrollPane, true, skin);
		add(pane).expandY().fillY();
	}

	public Journal getJournal() {
		return journal;
	}
}
