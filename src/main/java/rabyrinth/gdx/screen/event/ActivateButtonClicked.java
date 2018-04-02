package rabyrinth.gdx.screen.event;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/** @author Sino */
public final class ActivateButtonClicked {
	private final ChangeListener.ChangeEvent event;

	private final Actor actor;

	public ActivateButtonClicked(ChangeListener.ChangeEvent event, Actor actor) {
		this.event = event;
		this.actor = actor;
	}

	public ChangeListener.ChangeEvent getEvent() {
		return event;
	}

	public Actor getActor() {
		return actor;
	}
}
