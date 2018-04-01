package rabyrinth.gdx.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

/** @author Sino */
public final class Avatars {
	public static final AssetDescriptor<Texture> KNUCKLES = new AssetDescriptor<>(Gdx.files.internal("resources/knuckles.png"), Texture.class);

	/** Prevents external instantiation. */
	private Avatars() { }
}
