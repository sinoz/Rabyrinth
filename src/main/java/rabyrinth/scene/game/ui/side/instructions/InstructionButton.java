package rabyrinth.scene.game.ui.side.instructions;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.game.InstructionType;
import rabyrinth.scene.game.event.SelectedInstruction;

/** @author Sino */
public final class InstructionButton extends TextButton {
	public InstructionButton(Skin skin, InstructionType type, EventBus eventBus) {
		super(type.getLabel(), skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				eventBus.post(new SelectedInstruction(type));
			}
		});
	}
}
