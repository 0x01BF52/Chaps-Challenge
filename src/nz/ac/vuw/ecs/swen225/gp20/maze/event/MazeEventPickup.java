package nz.ac.vuw.ecs.swen225.gp20.maze.event;

import com.google.common.base.Preconditions;

import nz.ac.vuw.ecs.swen225.gp20.maze.*;

/**
 * Event for when chap picks something up off a tile they just walked onto.
 * 
 * @author Ian 300474717
 *
 */
public class MazeEventPickup extends MazeEventWalked {
  protected Pickup picked;

  public MazeEventPickup(Maze maze, PathTile origin, PathTile target, Maze.Direction direction,
      Pickup picked) {
    super(maze, origin, target, direction);
    this.picked = picked;
  }

  public Pickup getPicked() {
    return picked;
  }

  @Override
  public String toString() {
    return String.format("Picked up a %s at %s,%s", picked, target.getCol(),
        target.getRow());
  }
  
  @Override
  public void receive(MazeEventListener l) {
    l.update(this);
  }
  
  @Override
  public void invert() {
    target.place(picked);
    maze.getChap().unPickup(maze, picked);
    super.invert();
  }
}
