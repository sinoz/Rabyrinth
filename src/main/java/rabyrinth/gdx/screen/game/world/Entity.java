package rabyrinth.gdx.screen.game.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Queue;
import rabyrinth.gdx.screen.game.world.frame.FrameSet;

/** @author Sino */
public final class Entity implements Disposable {
	/** The default walking velocity at which an entity moves. */
	public static final float WALK_VELOCITY = 3F;

	/** The game world this entity is currently on. */
	private final World world;

	/** The sprite for this entity. */
	private final Sprite sprite;

	/** The set of frames for this entity. */
	private final FrameSet frameSet;

	/** A queue of {@link Direction}s */
	public final Queue<Direction> pending = new Queue<Direction>();

	/** The current {@link Direction} this entity is facing. */
	public Direction currentDirection = Direction.SOUTH;

	/** The tile points where this entity is moving from and moving to. */
	private Vector2 movingFrom;
	private Vector2 movingTo;

	/** The velocity at which the entity moves. */
	public float velocity = WALK_VELOCITY;

	/** Creates a new {@link Entity}. */
	public Entity(World world, FrameSet frameSet) {
		this.world = world;
		this.frameSet = frameSet;
		this.sprite = new Sprite(frameSet.get(Direction.SOUTH).get(0));
	}

	/** Sets this entity's screen position to the specified tile position. */
	public void setPosition(float tileX, float tileY) {
		float screenX = tileX * world.getTileWidth();
		float screenY = tileY * world.getTileHeight();

		sprite.setPosition(screenX, screenY);
	}

	/** Updates this entity. */
	public void update(float deltaTime) {
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
			float currentTileX = sprite.getX() / world.getTileWidth();
			float currentTileY = sprite.getY() / world.getTileHeight();

			float targetTileX = movingTo.x;
			float targetTileY = movingTo.y;

			if (currentDirection == Direction.SOUTH) {
				currentTileY -= velocity * deltaTime;
				if (currentTileY < targetTileY) {
					currentTileY = targetTileY;
				}
			} else if (currentDirection == Direction.NORTH) {
				currentTileY += velocity * deltaTime;
				if (currentTileY > targetTileY) {
					currentTileY = targetTileY;
				}
			} else if (currentDirection == Direction.EAST) {
				currentTileX += velocity * deltaTime;
				if (currentTileX > targetTileX) {
					currentTileX = targetTileX;
				}
			} else if (currentDirection == Direction.WEST) {
				currentTileX -= velocity * deltaTime;
				if (currentTileX < targetTileX) {
					currentTileX = targetTileX;
				}
			}

			if (currentTileX >= 0 && currentTileY >= 0 && currentTileX < world.getMapWidth() && currentTileY < world.getMapHeight()) {
				setPosition(currentTileX, currentTileY);

				boolean reachedTargetTileX = currentTileX == targetTileX;
				boolean reachedTargetTileY = currentTileY == targetTileY;

				if (reachedTargetTileX && reachedTargetTileY) {
					movingFrom = null;
					movingTo = null;
				}
			} else {
				movingFrom = null;
				movingTo = null;
			}
		}
	}

	/** Draws this entity. */
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
