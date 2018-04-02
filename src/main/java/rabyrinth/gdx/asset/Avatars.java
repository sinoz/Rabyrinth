package rabyrinth.gdx.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/** @author Sino */
public final class Avatars {
	public static final AssetDescriptor<TextureAtlas> KNUCKLES = new AssetDescriptor<TextureAtlas>(Gdx.files.internal("resources/avatar/knuckles.atlas"), TextureAtlas.class);

	/** Prevents external instantiation. */
	private Avatars() { }
}
