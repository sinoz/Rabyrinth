package rabyrinth.scene.game.world.map;

import java.nio.file.Path;
import java.nio.file.Paths;

/** @author Sino */
public enum MapType {
	DEFAULT ("resources/maps/tmx/IsometricDemo.tmx");

	/** The {@link Path} to the map. */
	private final Path path;

	/** Creates a new {@link MapType} using the specified string as the path. */
	MapType(String path) {
		this(Paths.get(path));
	}

	/** Creates a new {@link MapType}. */
	MapType(Path path) {
		this.path = path;
	}

	public Path path() {
		return path;
	}
}
