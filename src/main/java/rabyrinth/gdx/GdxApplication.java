package rabyrinth.gdx;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/** @author Sino */
public final class GdxApplication {
	/** The title of this game application. */
	public static final String TITLE = "Rabyrinth";

	/** Indicates whether this application is in debug mode. */
	public static final boolean DEBUG_MODE = false;

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TITLE;
		config.width = 800;
		config.height = 600;
		config.resizable = true;

		config.addIcon("resources/icon/icon_32x32.png", Files.FileType.Internal);
		config.addIcon("resources/icon/icon_64x64.png", Files.FileType.Internal);
		config.addIcon("resources/icon/icon_128x128.png", Files.FileType.Internal);

		new LwjglApplication(new GdxGame(), config);
	}
}
