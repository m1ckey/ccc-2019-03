package ccc.lvl3;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordinate that = (Coordinate) o;
    return i == that.i &&
            j == that.j &&
            Objects.equals(c, that.c);
  }

  @Override
  public int hashCode() {
    return Objects.hash(i, j, c);
  }
}
