package ccc.lvl4;

import java.util.Objects;

public class Coordinate
{

  public final int i, j;
  public Color c;

  public Coordinate(String[] parts, int j)
  {
    this.i = Integer.parseInt(parts[0+(j*2)]);
    this.j = Integer.parseInt(parts[1+(j*2)]);
  }

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

  public void setC(Color c) {
    this.c = c;
  }

  public void initColor(Color[][] colors){
    c = colors[i][j];
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
