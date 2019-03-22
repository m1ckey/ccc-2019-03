package ccc.lvl4;

public class Pair {
    private final Coordinate c1;
    private final Coordinate c2;

    public Pair(Coordinate c1, Coordinate c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Coordinate getC1() {
        return c1;
    }

    public Coordinate getC2() {
        return c2;
    }

    public void initColor(Color[][] colors){
        c1.initColor(colors);
        c2.initColor(colors);
    }
}
