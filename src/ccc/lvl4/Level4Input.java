package ccc.lvl4;

import ccc.LevelInput;

import java.util.Arrays;
import java.util.List;

public class Level4Input extends LevelInput {

  public Level4Input(){}

  private Color[][] colors;
  private List<Pair> pairList;

  public Level4Input(Color[][] colors, List<Pair> pairList) {
    this.colors = colors;
    this.pairList = pairList;
  }

  public List<Pair> getPairList() {
    return pairList;
  }

  public Color[][] getColors() {
    return colors;
  }

}
