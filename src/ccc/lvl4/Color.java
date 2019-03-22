package ccc.lvl4;

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

    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

  public boolean isPassable() {
      return !(this.red == 0 && this.blue == 0 && this.green == 0);
  }
}
