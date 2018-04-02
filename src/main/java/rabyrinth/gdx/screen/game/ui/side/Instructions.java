package rabyrinth.gdx.screen.game.ui.side;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.GdxGame;
import rabyrinth.gdx.screen.game.InstructionType;
import rabyrinth.gdx.screen.game.ui.side.instructions.ActivateButton;
import rabyrinth.gdx.screen.game.ui.side.instructions.InstructionButton;

/** @author Sino */
public final class Instructions extends Table {
	public Instructions(Skin skin, EventBus eventBus) {
		super(skin);

		setDebug(GdxGame.DEBUG_MODE);

		defaults().prefWidth(100F);
		add(new InstructionButton(skin, InstructionType.TURN_LEFT, eventBus));
		add(new InstructionButton(skin, InstructionType.TURN_RIGHT, eventBus)).row();

		add(new InstructionButton(skin, InstructionType.WALK, eventBus));
		add(new ActivateButton(skin, eventBus)).row();
	}
}
