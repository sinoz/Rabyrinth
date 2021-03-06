package rabyrinth.gdx.screen.event;

import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.screen.game.InstructionType;
import rabyrinth.gdx.screen.game.ui.side.Journal;
import rabyrinth.gdx.screen.game.world.Direction;
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
				case TURN_RIGHT:
					if (world.getAvatar().currentDirection == Direction.EAST) {
						world.getAvatar().currentDirection = Direction.SOUTH;
					} else if (world.getAvatar().currentDirection == Direction.SOUTH) {
						world.getAvatar().currentDirection = Direction.WEST;
					} else if (world.getAvatar().currentDirection == Direction.WEST) {
						world.getAvatar().currentDirection = Direction.NORTH;
					} else if (world.getAvatar().currentDirection == Direction.NORTH) {
						world.getAvatar().currentDirection = Direction.EAST;
					}

					break;
				case TURN_LEFT:
					if (world.getAvatar().currentDirection == Direction.EAST) {
						world.getAvatar().currentDirection = Direction.NORTH;
					} else if (world.getAvatar().currentDirection == Direction.SOUTH) {
						world.getAvatar().currentDirection = Direction.EAST;
					} else if (world.getAvatar().currentDirection == Direction.WEST) {
						world.getAvatar().currentDirection = Direction.SOUTH;
					} else if (world.getAvatar().currentDirection == Direction.NORTH) {
						world.getAvatar().currentDirection = Direction.WEST;
					}

					break;
				case WALK:
					world.getAvatar().pending.addLast(world.getAvatar().currentDirection);

					break;
			}
		}

		// clear instructions, prepare for next set of instructions
		instructions.clear();

		// and also clear journal
		journal.clear();

		// and add the placeholder back in
		journal.addPlaceholder();
	}
}
