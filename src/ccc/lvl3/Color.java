package ccc.lvl3;

public class Color
{
  public final int red, green, blue;

  public Color(int red, int green, int blue)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public Color(String[] parts, int n){
   this.red = Integer.parseInt(parts[0+(3*n)]);
   this.green = Integer.parseInt(parts[1+(3*n)]);
   this.blue = Integer.parseInt(parts[2+(3*n)]);
  }
}
