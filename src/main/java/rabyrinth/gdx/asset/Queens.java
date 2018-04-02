package rabyrinth.gdx.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/** @author Sino */
public final class Queens {
	public static final AssetDescriptor<TextureAtlas> KNUCKLES_QUEEN = new AssetDescriptor<TextureAtlas>(Gdx.files.internal("resources/queen/queen.atlas"), TextureAtlas.class);

	/** Prevents external instantiation. */
	private Queens() { }
}
