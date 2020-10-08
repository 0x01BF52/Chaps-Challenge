package nz.ac.vuw.ecs.swen225.gp20.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.ac.vuw.ecs.swen225.gp20.maze.BoardRig;
import nz.ac.vuw.ecs.swen225.gp20.maze.Maze;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PersistenceTest {
  static ObjectMapper mapper = new ObjectMapper();
  private static final Maze[] levels = new Maze[]{
      BoardRig.lesson1(),
      BoardRig.crateTest(),
      BoardRig.crateAndWaterTest(),
      BoardRig.pathFindTest1(),
      BoardRig.levelEditorTest1(),
      BoardRig.levelEditorTest2(),
      BoardRig.levelEditorTest3(),
      BoardRig.teleporterTest1(),
  };

  /**
   * Convert test 01. This test is to make sure all Tile in this
   */
  @Test
  public void convertTest01() {
    for (Maze level : levels) {
      try {
        String json = mapper.writeValueAsString(level);
        Persistence.quickSave(level);
        String json2 = mapper.writeValueAsString(Persistence.quickLoad());
        assertEquals(json, json2);
      } catch (Exception e) {
        e.printStackTrace();
        assert false;
      }
    }
  }

  @Test
  public void fileWritingTest01() {
    Path p = Paths.get(".", "levels", "quickSave.json");
    try {
      Files.deleteIfExists(p);
    } catch (IOException e) {
      e.printStackTrace();
    }
//    Exception exception = assertThrows(IOException.class, () -> Persistence.quickLoad());
//    String message = "levels/quickSave.json not existed";
    assert Persistence.quickLoad()==null;
  }

//  public static void main(String[] args) {
////    System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
////    new JFileChooser(Paths.get(".").toFile());
//  }

}
