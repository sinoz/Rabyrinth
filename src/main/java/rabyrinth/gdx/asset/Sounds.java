package rabyrinth.gdx.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;

/** @author Sino */
public final class Sounds {
	public static final AssetDescriptor<Sound> CHAOS = new AssetDescriptor<>(Gdx.files.internal("resources/sound/chaos.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> DO_YOU_KNOW_THE_WAE = new AssetDescriptor<>(Gdx.files.internal("resources/sound/do_you_know_the_wae.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> HE_DOES_NOT_KNOW_THE_WAE = new AssetDescriptor<>(Gdx.files.internal("resources/sound/he_does_not_know_the_wae.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> MUSIC_THE_WAE = new AssetDescriptor<>(Gdx.files.internal("resources/sound/music_the_wae.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> MY_BROS = new AssetDescriptor<>(Gdx.files.internal("resources/sound/my_brothers_what_do_we_want.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> ALSO_LOOKING_FOR_WAE = new AssetDescriptor<>(Gdx.files.internal("resources/sound/so_you_are_also_looing_for_the_wae.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> MUST_PRAY = new AssetDescriptor<>(Gdx.files.internal("resources/sound/we_must_pray_for_this_one.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> YOU_DO_NOT_KNOW_THE_WAE = new AssetDescriptor<>(Gdx.files.internal("resources/sound/you_do_not_know_the_wae.mp3"), Sound.class);
	public static final AssetDescriptor<Sound> YOU_NEED_EBOLA = new AssetDescriptor<>(Gdx.files.internal("resources/sound/you_have_to_have_ebola_to_know_the_wae.mp3"), Sound.class);

	/** Prevents external instantiation. */
	private Sounds() { }
}
