package nz.ac.vuw.ecs.swen225.gp20.application;

import java.io.File;
import nz.ac.vuw.ecs.swen225.gp20.maze.BoardRig;
import nz.ac.vuw.ecs.swen225.gp20.maze.Maze;
import nz.ac.vuw.ecs.swen225.gp20.persistence.Persistence;

/**
 * Main class for running Chap's Challenge.
 */
public class Main {
  /*private static final Maze[] levels = new Maze[]{
      BoardRig.lesson1(),
      BoardRig.crateTest(),
      BoardRig.crateAndWaterTest(),
      BoardRig.pathFindTest1(),
      BoardRig.levelEditorTest1(),
      BoardRig.levelEditorTest2(),
      BoardRig.levelEditorTest3(),
      BoardRig.teleporterTest1(),
  };*/

  public static final File level1 = new File("levels/official_levels/level1.json");
  public static final File level2 = new File("levels/official_levels/level2.json");

  /**
   * Key objects and components are invoked here to run the game.
   *
   * @param args the commandline arguments
   */
  public static void main(String[] args) {
    //new TextGUI();
    Maze maze = BoardRig.enemyKillTest1();
    //Maze maze = Persistence.loadMaze(level1);

    Gui gui = new Gui(maze);
    gui.getFrame().setVisible(true);
  }
}
