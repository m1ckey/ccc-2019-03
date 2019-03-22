package ccc.lvl2;

import ccc.Level;
import ccc.LevelInput;
import ccc.LevelOutput;
import ccc.lvl2.Color;

import java.io.IOException;
import java.util.List;

public class Level2 extends Level {
  public Level2() {
    super(2);
  }

  @Override
  public LevelInput transformFromLines(List<String> lines) {
    Level2Input in = new Level2Input();
    String[] line1Parts = lines.get(0).split(" ");
    int rows = Integer.parseInt(line1Parts[0]);
    int columns = Integer.parseInt(line1Parts[0]);
    Color[][] colors = new Color[rows][columns];
    lines.remove(0);
    for(int i = 0; i<rows; i++){
      String[] parts = lines.get(i).split(" ");
      for(int j = 0; j<columns; j++) {
          Color c = new Color(parts, j);
          colors[i][j] = c;
      }
    }
    in.setColors(colors);
    return in;
  }

  @Override
  public LevelOutput run(LevelInput i) throws IOException {

    Level2Input input = (Level2Input) i;
    LevelOutput output = new Level2Output();


    Color[][] map = null;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; i < map[i].length - 1; j++) {

        output.buffer.add("" + distance(map[i][j], map[i][j + 1]));
      }
      output.buffer.add("\n");
    }
    return output;
  }

  private int distance(Color c1, Color c2)
  {
    return (int) Math.sqrt(Math.pow(c1.red - c2.red, 2) + Math.pow(c1.green - c2.green, 2) + Math.pow(c1.blue - c2.blue, 2));
  }

  @Override
  public List<String> transformToLines(LevelOutput o) {

      return o.buffer;
  }
}
