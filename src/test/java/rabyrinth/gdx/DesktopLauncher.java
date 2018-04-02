package rabyrinth.gdx;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/** @author Sino */
public final class DesktopLauncher { // TODO create core and desktop modules
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Rabyrinth";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.resizable = true;

		config.addIcon("resources/icon/icon_32x32.png", Files.FileType.Internal);
		config.addIcon("resources/icon/icon_64x64.png", Files.FileType.Internal); // TODO should be 16x16
		config.addIcon("resources/icon/icon_128x128.png", Files.FileType.Internal);

		new LwjglApplication(new GdxGame(), config);
	}
}
