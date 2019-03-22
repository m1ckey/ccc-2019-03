package ccc.lvl2;

import ccc.LevelInput;
import ccc.lvl1.Pair;

import java.util.List;

public class Level2Input extends LevelInput {

  public Level2Input(){}

  private List<Pair> pairList;

  public void setPairList(List<Pair> pairList) {
    this.pairList = pairList;
  }

  public List<Pair> getPairList() {
    return pairList;
  }
}
