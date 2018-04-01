package rabyrinth.gdx.screen.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import rabyrinth.gdx.GdxApplication;
import rabyrinth.gdx.screen.game.InstructionType;

/** @author Sino */
public final class Journal extends Tree {
	private boolean placeholderOnly = true;

	private final Skin skin;

	public Journal(Skin skin) {
		super(skin);

		this.skin = skin;

		setDebug(GdxApplication.DEBUG_MODE);

		add(new Node(new TextButton("Empty", skin)));
	}

	public void add(InstructionType type) {
		if (placeholderOnly) {
			clearChildren();
			placeholderOnly = false;
		}

		add(new Node(new TextButton(type.getLabel(), skin)));
	}
}
