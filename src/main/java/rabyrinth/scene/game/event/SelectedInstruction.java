package rabyrinth.scene.game.event;

import rabyrinth.scene.game.InstructionType;

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
