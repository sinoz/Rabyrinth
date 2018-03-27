package rabyrinth.scene.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.Subscribe;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/** @author Sino */
public final class ConfirmedExitListener {
	private final Stage stage;

	public ConfirmedExitListener(Stage stage) {
		this.stage = stage;
	}

	@Subscribe
	public void confirmedExit(ConfirmedExit event) {
		stage.addAction(sequence(delay(2.0F), run(() -> Gdx.app.exit())));
	}
}
