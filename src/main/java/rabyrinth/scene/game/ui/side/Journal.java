package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Journal extends Table {
	public Journal(Skin skin) {
		super(skin);

		setDebug(true);

		add(new TextButton("Empty", skin));
	}
}
