package rabyrinth.scene.level;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/** @author Sino */
public final class LevelSelectButton extends TextButton {
	public LevelSelectButton(Skin skin, int levelId, LevelSelectScene scene) {
		super("Level " + levelId, skin);

		addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent changeEvent, Actor actor) {
				scene.switchToGameScene();
			}
		});
	}
}
