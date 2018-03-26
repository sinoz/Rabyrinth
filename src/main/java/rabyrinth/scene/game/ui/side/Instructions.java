package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Instructions extends Table {
	public Instructions(Skin skin) {
		super(skin);

		add(new TextButton("Walk", skin)).padTop(20F).row();
		add(new TextButton("Turn", skin)).padTop(20F).row();
		add(new TextButton("Jump", skin)).padTop(20F).row();
		add(new TextButton("Loop", skin)).padTop(20F).row();
	}
}
