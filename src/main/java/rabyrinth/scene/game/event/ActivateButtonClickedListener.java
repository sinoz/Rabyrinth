package rabyrinth.scene.game.event;

import com.google.common.eventbus.Subscribe;
import rabyrinth.scene.game.InstructionType;

import java.util.Queue;

/** @author Sino */
public final class ActivateButtonClickedListener {
	private final Queue<InstructionType> instructions;

	public ActivateButtonClickedListener(Queue<InstructionType> instructions) {
		this.instructions = instructions;
	}

	@Subscribe
	public void activateButtonClicked(ActivateButtonClicked event) {
		System.out.println(instructions.size());
	}
}
