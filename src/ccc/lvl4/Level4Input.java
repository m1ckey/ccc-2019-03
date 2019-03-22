package ccc.lvl4;

import ccc.LevelInput;

import java.util.Arrays;

public class Level4Input extends LevelInput {

  public Level4Input(){}

  private Color[][] colors;
  private Coordinate start;


  public Level4Input(Color[][] colors, Coordinate start) {
    this.colors = colors;

    this.start = start;
  }

  public Color[][] getColors() {
    return colors;
  }

  public Coordinate getStart() {
    return start;
  }

  @Override
  public String toString() {
    return "Level4Input{" +
            "colors=" + Arrays.toString(colors) +
            ", start=" + start +
            '}';
  }
}
