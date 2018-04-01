package rabyrinth.gdx.screen.game.world.frame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.google.common.collect.ImmutableMap;
import rabyrinth.gdx.screen.game.world.Direction;

/** @author Sino */
public final class FrameSet {
	private final ImmutableMap<Direction, Array<TextureAtlas.AtlasRegion>> set;

	public FrameSet(ImmutableMap<Direction, Array<TextureAtlas.AtlasRegion>> set) {
		this.set = set;
	}

	public Array<TextureAtlas.AtlasRegion> get(Direction direction) {
		return set.get(direction);
	}
}
