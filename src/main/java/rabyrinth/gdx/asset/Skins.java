package rabyrinth.gdx.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** @author Sino */
public final class Skins {
	/** The default {@link Skin} to use. */
	public static final AssetDescriptor<Skin> DEFAULT = new AssetDescriptor<Skin>(Gdx.files.internal("resources/ui/uiskin.json"), Skin.class);
}
