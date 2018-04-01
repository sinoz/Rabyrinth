package rabyrinth.gdx.screen.game.event;

import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.screen.game.InstructionType;
import rabyrinth.gdx.screen.game.ui.side.Journal;
import rabyrinth.gdx.screen.game.world.World;

import java.util.Deque;

/** @author Sino */
public final class ActivateButtonClickedListener {
	private final World world;

	private final Journal journal;

	private final Deque<InstructionType> instructions;

	public ActivateButtonClickedListener(Journal journal, World world, Deque<InstructionType> instructions) {
		this.world = world;
		this.journal = journal;
		this.instructions = instructions;
	}

	@Subscribe
	public void activateButtonClicked(ActivateButtonClicked event) {
		while (!instructions.isEmpty()) {
			InstructionType type = instructions.poll();
			switch (type) {
				case TURN:
					// TODO

					break;
				case WALK:
					// TODO
					world.getAvatar().moveTo(world.getAvatar().getTileX() + 1, world.getAvatar().getTileY());

					break;
				case JUMP:
					// TODO

					break;
				case LOOP:
					// TODO

					break;
				case WAIT:
					// TODO

					break;
			}
		}

		// clear instructions, prepare for next set of instructions
		instructions.clear();

		// and also clear journal
		journal.clear();
	}
}
