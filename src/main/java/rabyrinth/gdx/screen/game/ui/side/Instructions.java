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

		defaults().prefWidth(100F);
		add(new InstructionButton(skin, InstructionType.TURN_LEFT, eventBus));
		add(new InstructionButton(skin, InstructionType.TURN_RIGHT, eventBus)).row();

		add(new InstructionButton(skin, InstructionType.WALK, eventBus));
		add(new ActivateButton(skin, eventBus)).row();
	}
}
