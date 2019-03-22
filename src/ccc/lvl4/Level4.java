package ccc.lvl4;

import ccc.Level;
import ccc.LevelInput;
import ccc.LevelOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level4 extends Level {
  public Level4() {
    super(4);
  }

  @Override
  public LevelInput transformFromLines(List<String> lines) {
    Level4Input in = new Level4Input();
    String[] line1Parts = lines.get(0).split(" ");
    int rows = Integer.parseInt(line1Parts[0]);
    int columns = Integer.parseInt(line1Parts[1]);
    Color[][] colors = new Color[rows][columns];
    lines.remove(0);

    int n = Integer.parseInt(lines.get(0));
    List<Pair> pairList = new ArrayList<>();
    lines.remove(0);

    for(int i = 0; i<n; i++){
      String[] parts = lines.get(0).split(" ");
      Coordinate c1 = new Coordinate(parts, 0);
      Coordinate c2 = new Coordinate(parts, 1);
      Pair pair = new Pair(c1, c2);
      pairList.add(pair);
      lines.remove(0);
    }

    for(int i = 0; i<rows; i++){
      String[] parts = lines.get(i).split(" ");
      for(int j = 0; j<columns; j++) {
          Color c = new Color(parts, j);
          colors[i][j] = c;
      }
    }

    for(Pair pair : pairList){
      pair.initColor(colors);
    }
    in = new Level4Input(colors, pairList);
    return in;
  }

  public List<Coordinate> getValidMoves(Coordinate cord){
    List<Coordinate> list = new ArrayList<>();

    if(cord.j-1>=0){
      Coordinate left = new Coordinate(cord.i, cord.j-1, colorMap);
      if(left.c.isPassable()) {
        list.add(left);
      }
    }

    if(cord.j+1<colorMap[cord.i].length){
      Coordinate right = new Coordinate(cord.i, cord.j+1, colorMap);
      if(right.c.isPassable()) {
        list.add(right);
      }
    }

    if(cord.i+1<colorMap.length){
      Coordinate down = new Coordinate(cord.i+1, cord.j, colorMap);
      if(down.c.isPassable()) {
        list.add(down);
      }
    }

    if(cord.i-1>=0){
      Coordinate up = new Coordinate(cord.i-1, cord.j, colorMap);
      if(up.c.isPassable()) {
        list.add(up);
      }
    }

    list.removeAll(visited);


    return list;
  }

  List<Coordinate> visited = new ArrayList<>();
  Color[][] colorMap = null;

  @Override
  public LevelOutput run(LevelInput in) throws IOException {

    visited = new ArrayList<>();

    Level4Input input = (Level4Input) in;
    LevelOutput output = new Level4Output();

    System.out.println(input.toString());


    visited.forEach(c -> output.buffer.add(c.i + " " + c.j + "\n"));

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
      if(leastResistance.equals(colorEnd)) continue;
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
