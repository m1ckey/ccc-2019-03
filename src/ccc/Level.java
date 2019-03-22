package ccc;

import ccc.io.OutputParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The Level Object handles all the logic behind the different code in the levels.
 */
public abstract class Level {

  public final int lvl;

  public Level(int lvl) {
    this.lvl = lvl;
  }

  /**
   * Casts a list of lines into a list of objects.
   * @param lines the lines read from the input file.
   * @return a list of parsed objects needed for this level.
   */
  public abstract LevelInput transformFromLines(List<String> lines);

  /**
   * The main logic for the level.
   */
  public abstract LevelOutput run(LevelInput input) throws IOException;

  /**
   * Casts a list of objects to a list of lines fitted for output.
   * @param objects a list of objects needed for this level.
   * @return a list of lines which can be outputted to console or file.
   */
  public abstract List<String> transformToLines(LevelOutput objects);

  /**
   * Writes all lines to an output file.
   * @param lines a list of lines.
   * @return a file which can be written to disk.
   */
  public void writeOutputFile(List<String> lines, String filename) throws IOException {
    OutputParser op = new OutputParser(lvl);
    op.write(lines, filename);
  }

  /**
   * Writes all lines to console for debugging purposes.
   * @param lines a list of lines.
   */
  public void writeConsole(List<String> lines, String filename) {
    System.out.println("----- [" + filename + "] -----");
    for(String line : lines) {
      System.out.println(line);
    }
    System.out.println("----- [ ] -----");
  }
}
