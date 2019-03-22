package ccc.lvl3;

public class Coordinate
{

  public final int i, j;
  public final Color c;

  public Coordinate(int i, int j, Color c)
  {
    this.i = i;
    this.j = j;
    this.c = c;
  }

  public Coordinate(int i, int j, Color[][] cMap)
  {
    this.i = i;
    this.j = j;
    this.c = cMap[i][j];
  }

  @Override
  public String toString() {
    return "Coordinate{" +
            "i=" + i +
            ", j=" + j +
            ", c=" + c +
            '}';
  }
}
