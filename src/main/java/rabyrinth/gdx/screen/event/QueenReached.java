package rabyrinth.gdx.screen.event;

import rabyrinth.gdx.screen.game.world.Entity;

/** @author Sino */
public final class QueenReached {
	private final Entity avatar, queen;

	public QueenReached(Entity avatar, Entity queen) {
		this.avatar = avatar;
		this.queen = queen;
	}

	public Entity getAvatar() {
		return avatar;
	}

	public Entity getQueen() {
		return queen;
	}
}
