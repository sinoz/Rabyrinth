package rabyrinth.scene.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;

public final class Background extends Table {
	public Background(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");
		setDebug(true);

		add(new ExitButton(skin, eventBus)).expandX().left();
		add(new SoundToggle(skin)).expandX().center();
		add(new LevelDisplay(1, skin)).expandX().right();
	}
}
