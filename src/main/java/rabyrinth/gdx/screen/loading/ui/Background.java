package rabyrinth.gdx.screen.loading.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import rabyrinth.gdx.GdxApplication;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/** @author Sino */
public final class Background extends Table {
	private final ProgressText progressText;
	private final Image knucklesIcon;

	private final Array<TextureAtlas.AtlasRegion> knucklesFrames;

	private int frameId = 0;

	public Background(Skin skin, Array<TextureAtlas.AtlasRegion> frames) {
		super(skin);

		setDebug(GdxApplication.DEBUG_MODE);
		setBackground("default-background");
		setFillParent(true);

		knucklesFrames = frames;

		knucklesIcon = new Image(frames.get(0));
		progressText = new ProgressText(skin);

		add(knucklesIcon).row();
		add(progressText);

		animateKnucklesIcon();
	}

	private void animateKnucklesIcon() {
		Action wait = delay(0.25F);
		Action transitionIntoNextFrame = run(this::nextFrame);

		knucklesIcon.addAction(forever(sequence(wait, transitionIntoNextFrame)));
	}

	private void nextFrame() {
		if (frameId == 0) {
			frameId = 1;
		} else {
			frameId = 0;
		}

		knucklesIcon.setDrawable(new TextureRegionDrawable(knucklesFrames.get(frameId)));
	}

	public ProgressText getProgressText() {
		return progressText;
	}
}
