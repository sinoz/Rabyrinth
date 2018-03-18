package rabyrinth.scene.game.world.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.HashMap;
import java.util.Map;

/** @author Sino */
public final class MapController {
	/** Used to load {@link TiledMap}s from TMX files. */
	private final TmxMapLoader mapLoader = new TmxMapLoader();

	/** A cache of previously requested {@link TiledMap} binded to their {@link MapType}. */
	private final Map<MapType, TiledMap> cache = new HashMap<>();

	/** The currently active {@link TiledMap}. */
	private TiledMap active;

	/** Switches to a different {@link TiledMap}. The requested {@link TiledMap} is loaded
	 * if not previously cached. */
	public void switchTo(MapType type) {
		active = getTiledMap(type);
	}

	/** Returns the currently active {@link TiledMap}. Loads the {@link MapType#DEFAULT}
	 * if no map is currently active. */
	public TiledMap getActiveMap() {
		if (active == null) {
			active = getTiledMap(MapType.DEFAULT);
		}

		return active;
	}

	/** Attempts to retrieve a previously stored {@link TiledMap} instance from the {@link MapController#cache}.
	 * If not present, loads it from the {@link MapType#path}, stores it and returns it. */
	private TiledMap getTiledMap(MapType type) {
		return cache.computeIfAbsent(MapType.DEFAULT, key -> mapLoader.load(key.path().toString()));
	}
}
