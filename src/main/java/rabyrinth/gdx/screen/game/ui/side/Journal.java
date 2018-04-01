package rabyrinth.gdx.screen.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import rabyrinth.gdx.GdxApplication;
import rabyrinth.gdx.screen.game.InstructionType;

import java.util.ArrayList;
import java.util.List;

/** @author Sino */
public final class Journal extends Table {
	private final TextButton placeholder;

	private final List<TextButton> instructions = new ArrayList<>();

	private final Skin skin;

	public Journal(Skin skin) {
		super(skin);

		this.skin = skin;
		this.placeholder = new TextButton("Empty", skin);

		setDebug(GdxApplication.DEBUG_MODE);

		addPlaceholder();
	}

	public void add(InstructionType type) {
		if (instructions.isEmpty()) {
			placeholder.remove();
		}

		TextButton button = new TextButton(type.getLabel(), skin);

		add(button).padTop(20F).row();

		instructions.add(button);
	}

	public void clear() {
		for (TextButton button : instructions) {
			button.remove();
		}

		instructions.clear();

		addPlaceholder();
	}

	private void addPlaceholder() {
		add(placeholder).row();
	}
}
