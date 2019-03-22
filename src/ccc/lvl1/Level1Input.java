package ccc.lvl1;

import ccc.LevelInput;

import java.util.List;

public class Level1Input  extends LevelInput {

  public Level1Input(){}

  private List<Pair> pairList;

  public void setPairList(List<Pair> pairList) {
    this.pairList = pairList;
  }

  public List<Pair> getPairList() {
    return pairList;
  }
}
