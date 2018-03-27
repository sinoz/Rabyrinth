package rabyrinth.scene.event;

import com.badlogic.gdx.Gdx;
import com.google.common.eventbus.Subscribe;

/** @author Sino */
public final class ConfirmedExitListener {
	@Subscribe
	public void confirmedExit(ConfirmedExit event) {
		Gdx.app.exit();
	}
}
