package ccc.lvl3;

import ccc.Level;
import ccc.LevelInput;
import ccc.LevelOutput;

import java.io.IOException;
import java.util.List;

public class Level3 extends Level {
  public Level3() {
    super(3);
  }

  @Override
  public LevelInput transformFromLines(List<String> lines) {
    Level3Input in = new Level3Input();
    String[] line1Parts = lines.get(0).split(" ");
    String[] line2Parts = lines.get(1).split(" ");
    int rows = Integer.parseInt(line1Parts[0]);
    int columns = Integer.parseInt(line1Parts[1])-1;
    int startColumn = Integer.parseInt(line2Parts[1]);
    int startRow = Integer.parseInt(line2Parts[0]);
    Color[][] colors = new Color[rows][columns];
    lines.remove(1);
    lines.remove(0);

    for(int i = 0; i<rows; i++){
      String[] parts = lines.get(i).split(" ");
      for(int j = 0; j<columns; j++) {
          Color c = new Color(parts, j);
          colors[i][j] = c;
      }
    }
    in = new Level3Input(colors, startRow, startColumn);
    return in;
  }

  @Override
  public LevelOutput run(LevelInput in) throws IOException {

    Level3Input input = (Level3Input) in;
    LevelOutput output = new Level3Output();

    System.out.println(input.toString());

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

  private Coordinate leastResistance(Coordinate start, Coordinate... ends) {
    Color colorStart = start.c;
    Coordinate leastResistance = ends[0];
    int leastResistanceDistance = distance(colorStart, ends[0].c);
    for (Coordinate colorEnd : ends) {
      int distance = distance(colorStart, colorEnd.c);
      if(distance == leastResistanceDistance) {
        if(colorEnd.i < leastResistance.i) {
          leastResistance = colorEnd;
          leastResistanceDistance = distance;
        }
      }
      if(distance < leastResistanceDistance) {
        leastResistance = colorEnd;
        leastResistanceDistance = distance;
      }
    }
    return leastResistance;
  }

  @Override
  public List<String> transformToLines(LevelOutput o) {

      return o.buffer;
  }
}
