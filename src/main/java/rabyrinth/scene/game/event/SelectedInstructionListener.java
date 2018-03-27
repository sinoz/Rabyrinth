package rabyrinth.scene.game.event;

import com.google.common.eventbus.Subscribe;
import rabyrinth.scene.game.InstructionType;

import java.util.Queue;

/** @author Sino */
public final class SelectedInstructionListener {
	private final Queue<InstructionType> instructions;

	public SelectedInstructionListener(Queue<InstructionType> instructions) {
		this.instructions = instructions;
	}

	@Subscribe
	public void selectedInstruction(SelectedInstruction event) {
		instructions.offer(event.getType());

		System.out.println(instructions.size());

		// TODO update instruction journal
	}
}
