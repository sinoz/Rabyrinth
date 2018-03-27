package rabyrinth.scene.game.event;

import com.google.common.eventbus.Subscribe;
import rabyrinth.scene.game.InstructionType;
import rabyrinth.scene.game.ui.side.Journal;

import java.util.Queue;

/** @author Sino */
public final class SelectedInstructionListener {
	private final Journal journal;

	private final Queue<InstructionType> instructions;

	public SelectedInstructionListener(Journal journal, Queue<InstructionType> instructions) {
		this.journal = journal;
		this.instructions = instructions;
	}

	@Subscribe
	public void selectedInstruction(SelectedInstruction event) {
		instructions.offer(event.getType());
		journal.add(event.getType());
	}
}
