package ccc.lvl1;

import ccc.Level;
import ccc.LevelInput;
import ccc.LevelOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level1 extends Level {
  public Level1() {
    super(1);
  }

  @Override
  public LevelInput transformFromLines(List<String> lines) {
    Level1Input in = new Level1Input();
    List<Pair> pairList = new ArrayList<>();
    int n = Integer.parseInt(lines.get(0));
    lines.remove(0);
    for(int i = 0; i<n; i++){

    }
    return in;
  }

  @Override
  public LevelOutput run(LevelInput i) throws IOException {

    Level1Input input = (Level1Input) i;
    LevelOutput output = new Level1Output();

    // todo: solution goes here
    return output;
  }

  @Override
  public List<String> transformToLines(LevelOutput o) {

      return o.buffer;
  }
}
