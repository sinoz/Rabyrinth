package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import rabyrinth.scene.game.ui.side.instructions.*;

public final class Instructions extends Table {
	public Instructions(Skin skin) {
		super(skin);

		add(new WalkInstruction(skin)).padTop(20F).row();
		add(new TurnInstruction(skin)).padTop(20F).row();
		add(new JumpInstruction(skin)).padTop(20F).row();
		add(new WaitInstruction(skin)).padTop(20F).row();
		add(new LoopInstruction(skin)).padTop(20F).row();
		add(new Activate(skin)).padTop(50F).row();
	}
}
