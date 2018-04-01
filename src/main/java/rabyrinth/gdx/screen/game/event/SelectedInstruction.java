package rabyrinth.gdx.screen.game.event;

import rabyrinth.gdx.screen.game.InstructionType;

/** @author Sino */
public final class SelectedInstruction {
	private final InstructionType type;

	public SelectedInstruction(InstructionType type) {
		this.type = type;
	}

	public InstructionType getType() {
		return type;
	}
}
