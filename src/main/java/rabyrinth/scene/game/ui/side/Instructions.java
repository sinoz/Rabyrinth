package rabyrinth.scene.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.game.InstructionType;
import rabyrinth.scene.game.ui.side.instructions.*;

/** @author Sino */
public final class Instructions extends Table {
	public Instructions(Skin skin, EventBus eventBus) {
		super(skin);

		setDebug(true);

		for (InstructionType type : InstructionType.values()) {
			add(new InstructionButton(skin, type, eventBus)).padTop(20F).row();
		}

		add(new ActivateButton(skin, eventBus)).padTop(50F).row();
	}
}
