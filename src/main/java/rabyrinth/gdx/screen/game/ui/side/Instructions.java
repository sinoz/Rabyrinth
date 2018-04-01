package rabyrinth.gdx.screen.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.GdxApplication;
import rabyrinth.gdx.screen.game.InstructionType;
import rabyrinth.gdx.screen.game.ui.side.instructions.*;

/** @author Sino */
public final class Instructions extends Table {
	public Instructions(Skin skin, EventBus eventBus) {
		super(skin);

		setDebug(GdxApplication.DEBUG_MODE);

		for (InstructionType type : InstructionType.values()) {
			add(new InstructionButton(skin, type, eventBus)).padTop(20F).row();
		}

		add(new ActivateButton(skin, eventBus)).padTop(50F).row();
	}
}
