package nz.ac.vuw.ecs.swen225.gp20.maze.event;

import nz.ac.vuw.ecs.swen225.gp20.maze.*;

/**
 * Event for when chap walks onto an InfoField
 * 
 * @author Ian 300474717
 *
 */
public class MazeEventInfoField extends MazeEventWalked {
  private InfoField info;

  public MazeEventInfoField(Maze maze, PathTile origin, PathTile destination, Maze.Direction direction,
      InfoField info) {
    super(maze, origin, destination, direction);
    this.info = info;
  }

  public InfoField getInfoField() {
    return info;
  }

  @Override
  public String toString() {
    return String.format("Read an info field saying \"%s\" at tile %s,%s", info.getInformation(),
        destination.getCol(), destination.getRow());
  }
  
  @Override
  public void receive(MazeEventListener l) {
    l.update(this);
  }
}