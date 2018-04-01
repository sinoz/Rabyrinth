package rabyrinth.gdx.screen.game.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Queue;
import rabyrinth.gdx.screen.game.world.frame.FrameSet;

/** @author Sino */
public final class Avatar implements Disposable {
	/** The game world this avatar is currently on. */
	private final World world;

	/** The sprite for this avatar. */
	private final Sprite sprite;

	/** The set of frames for this avatar. */
	private final FrameSet frameSet;

	/** A queue of {@link Direction}s */
	public final Queue<Direction> pending = new Queue<>();

	/** The current {@link Direction} this avatar is facing. */
	public Direction currentDirection = Direction.SOUTH;

	/** The tile points where this avatar is moving from and moving to. */
	private Vector2 movingFrom;
	private Vector2 movingTo;

	/** Creates a new {@link Avatar}. */
	public Avatar(World world, FrameSet frameSet) {
		this.world = world;
		this.frameSet = frameSet;
		this.sprite = new Sprite(frameSet.get(Direction.SOUTH).get(0));
	}

	/** Updates this avatar. */
	public void update() {
		if (movingTo == null && pending.size > 0) {
			Direction nextDirection = pending.removeFirst();

			float currentTileX = sprite.getX() / world.getTileWidth();
			float currentTileY = sprite.getY() / world.getTileHeight();

			switch (nextDirection) {
				case SOUTH:
					movingTo = new Vector2(currentTileX, currentTileY - 1);

					break;
				case NORTH:
					movingTo = new Vector2(currentTileX, currentTileY + 1);

					break;
				case EAST:
					movingTo = new Vector2(currentTileX + 1, currentTileY);

					break;
				case WEST:
					movingTo = new Vector2(currentTileX - 1, currentTileY);

					break;
				default:
					throw new IllegalArgumentException("Unsupported direction: " + nextDirection);
			}

			currentDirection = nextDirection;
			sprite.setRegion(frameSet.get(currentDirection).get(0));

			movingFrom = new Vector2(currentTileX, currentTileY);
		}

		if (movingTo != null) {
			movingFrom = null;
			movingTo = null;
		}
	}

	/** Draws this avatar. */
	public void draw(Batch batch) {
		sprite.draw(batch);
	}

	@Override
	public void dispose() {
		sprite.getTexture().dispose();
	}

	public Sprite getSprite() {
		return sprite;
	}

	public float getTileX() {
		return sprite.getX() / world.getTileWidth();
	}

	public float getTileY() {
		return sprite.getY() / world.getTileHeight();
	}
}
