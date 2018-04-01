package rabyrinth.gdx.screen.main.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.event.ConfirmedExit;

/** @author Sino */
public final class ConfirmDialog extends Dialog {
	/** The event bus to publish events to. */
	private final EventBus eventBus;

	/** Creates a new {@link ConfirmDialog}. */
	ConfirmDialog(Skin skin, EventBus eventBus) {
		super("Warning", skin);

		this.eventBus = eventBus;

		setWidth(250F);
		setHeight(250F);

		setResizable(false);
		setMovable(true);

		text("Are you sure you would like to quit?");

		button("Yes", true);
		button("No", false);
	}

	@Override
	protected void result(Object object) {
		if (object == Boolean.TRUE) {
			eventBus.post(new ConfirmedExit());
		}
	}
}
