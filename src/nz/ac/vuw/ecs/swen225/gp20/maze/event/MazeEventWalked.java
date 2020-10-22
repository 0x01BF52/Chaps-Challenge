package nz.ac.vuw.ecs.swen225.gp20.maze.event;

import com.google.common.base.Preconditions;
import nz.ac.vuw.ecs.swen225.gp20.maze.Maze;
import nz.ac.vuw.ecs.swen225.gp20.maze.PathTile;

/**
 * Event for when chap moves from one tile to another.
 *
 * @author Ian 300474717
 *
 */
public class MazeEventWalked implements MazeEvent {
  protected PathTile origin;
  protected PathTile target;
  protected Maze.Direction direction;
  protected Maze maze;

  /**
   * Construct a new instance.
   * 
   * @param maze  The maze which this event is tied to.
   * @param origin The original position of Chap.
   * @param target  The new position of Chap.
   * @param direction The direction moved.
   */
  public MazeEventWalked(Maze maze, PathTile origin, PathTile target, Maze.Direction direction) {
    Preconditions.checkArgument(maze.getChap().equals(target.getBlocker())
        || target.isWalkable() || maze.isDead(), "Target must be walkable or contain only Chap");
    this.maze = maze;
    this.origin = origin;
    this.target = target;
    this.direction = direction;
  }

  /**
   * Get the targeted PathTile.
   * @return the targeted PathTile.
   */
  public PathTile getTarget() {
    return target;
  }

  /**
   * Get new destination. May differ from target as 
   * teleportation will take you to a different destination.
   * @return New destination.
   */
  public PathTile getDestination() {
    return target;
  }

  /**
   * Get original PathTile.
   * @return  Original PathTile.
   */
  public PathTile getOrigin() {
    return origin;
  }

  /**
   * Get direction moved.
   * @return Current direction moved.
   */
  public Maze.Direction getDirection() {
    return direction;
  }

  /**
   * Get maze.
   * @return  Current maze.
   */
  public Maze getMaze() {
    return maze;
  }


  @Override
  public String toString() {
    return String.format("Walked from tile %s,%s to tile %s,%s", origin.getCol(), origin.getRow(),
        target.getCol(), target.getRow());
  }

  @Override
  public void receive(MazeEventListener l) {
    l.update(this);
  }

  @Override
  public void invert() {
    origin.moveTo(maze.getChap());
  }
}
