package rabyrinth.gdx.screen.game;

/** @author Sino */
public enum InstructionType {
	WALK ("Walk"),
	TURN ("Turn"),
	WAIT ("Wait"),
	JUMP ("Jump"),
	LOOP ("Loop");

	private final String label;

	InstructionType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
