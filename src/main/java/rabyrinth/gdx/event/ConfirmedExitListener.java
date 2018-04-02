package rabyrinth.gdx.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.Subscribe;
import rabyrinth.gdx.asset.Sounds;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/** @author Sino */
public final class ConfirmedExitListener {
	private final Stage stage;
	private final AssetManager assetManager;

	public ConfirmedExitListener(Stage stage, AssetManager assetManager) {
		this.stage = stage;
		this.assetManager = assetManager;
	}

	@Subscribe
	public void confirmedExit(ConfirmedExit event) {
		assetManager.get(Sounds.YOU_DO_NOT_KNOW_THE_WAE).play();
		stage.addAction(sequence(delay(1.5F), run(new Runnable() {
			@Override
			public void run() {
				Gdx.app.exit();
			}
		})));
	}
}
