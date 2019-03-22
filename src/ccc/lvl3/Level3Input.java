package ccc.lvl3;

import ccc.LevelInput;

import java.util.Arrays;

public class Level3Input extends LevelInput {

  public Level3Input(){}

  private Color[][] colors;
  private int startRow, startColumn;

  public int getStartRow() {
    return startRow;
  }

  public int getStartColumn() {
    return startColumn;
  }

  public Level3Input(Color[][] colors, int startRow, int startColumn) {
    this.colors = colors;
    this.startRow = startRow;
    this.startColumn = startColumn;
  }

  public Color[][] getColors() {
    return colors;
  }

  @Override
  public String toString() {
    return "Level3Input{" +
            "colors=" + Arrays.toString(colors) +
            ", startRow=" + startRow +
            ", startColumn=" + startColumn +
            '}';
  }
}
