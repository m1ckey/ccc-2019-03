package ccc.lvl3;

import ccc.LevelInput;

import java.util.Arrays;

public class Level3Input extends LevelInput {

  public Level3Input(){}

  private Color[][] colors;
  private Coordinate start;


  public Level3Input(Color[][] color, Coordinate start) {
    this.colors = colors;

    this.start = start;
  }

  public Color[][] getColors() {
    return colors;
  }

  public Coordinate getStart() {
    return start;
  }

}
