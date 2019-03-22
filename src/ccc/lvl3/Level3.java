package ccc.lvl3;

import ccc.Level;
import ccc.LevelInput;
import ccc.LevelOutput;

import java.io.IOException;
import java.util.ArrayList;
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
    Coordinate start = new Coordinate(startRow, startColumn, colors[startRow][startColumn]);
    in = new Level3Input(colors, start);
    return in;
  }

  public List<Coordinate> getValidMoves(Coordinate cord){
    List<Coordinate> list = new ArrayList<>();

    if(cord.j+1<colorMap[cord.i].length){
      list.add(new Coordinate(cord.i, cord.j+1, colorMap));
    }

    if(cord.i+1<colorMap.length){
      list.add(new Coordinate(cord.i+1, cord.j, colorMap));
    }

    if(cord.i-1>=0){
      list.add(new Coordinate(cord.i-1, cord.j, colorMap));
    }


    return list;
  }

  List<Coordinate> visited = new ArrayList<>();
  Color[][] colorMap = null;

  @Override
  public LevelOutput run(LevelInput in) throws IOException {

    Level3Input input = (Level3Input) in;
    LevelOutput output = new Level3Output();

    System.out.println(input.toString());

    colorMap = null;
    Coordinate start = null; // todo
    visited.add(start);

    List<Coordinate> next = getValidMoves(start); // todo

    while(!next.isEmpty())
    {

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
        else if(colorEnd.i == leastResistance.i) {
          if(colorEnd.j < leastResistance.j) {
            leastResistance = colorEnd;
            leastResistanceDistance = distance;
          }
        }
      }
      else if(distance < leastResistanceDistance) {
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
