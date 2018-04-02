package rabyrinth.gdx.screen.event;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/** @author Sino */
public final class LevelSelected {
	private final int levelId;

	private final ChangeListener.ChangeEvent event;

	private final Actor actor;

	public LevelSelected(int levelId, ChangeListener.ChangeEvent event, Actor actor) {
		this.levelId = levelId;
		this.event = event;
		this.actor = actor;
	}

	public int getLevelId() {
		return levelId;
	}

	public ChangeListener.ChangeEvent getEvent() {
		return event;
	}

	public Actor getActor() {
		return actor;
	}
}
