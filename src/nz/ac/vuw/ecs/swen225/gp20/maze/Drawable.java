package nz.ac.vuw.ecs.swen225.gp20.maze;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.awt.*;
import java.util.UUID;

/**
 * Base class for anything which can be drawn on the board
 *
 * @author Ian 300474717
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS)
public class Drawable {
  public final String id = UUID.randomUUID().toString();
  protected Toolkit toolkit = Toolkit.getDefaultToolkit();
  protected String initials; // the string representation of this Drawable for drawing in text form

  // public Image image;
  public String filename;

  public Drawable(String filename, String initials) {

    this.initials = initials;
    this.filename = filename;
  }

  public Drawable() {}

  public String getInitials() {
    return initials;
  }

  public String getFilename() {
    return filename;
  }

  public void changeFile(String newFile) {
    filename = newFile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Drawable drawable = (Drawable) o;

    if (id != null ? !id.equals(drawable.id) : drawable.id != null) return false;
    if (getInitials() != null ? !getInitials().equals(drawable.getInitials()) : drawable.getInitials() != null)
      return false;
    return getFilename() != null ? getFilename().equals(drawable.getFilename()) : drawable.getFilename() == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (getInitials() != null ? getInitials().hashCode() : 0);
    result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
    return result;
  }
}
