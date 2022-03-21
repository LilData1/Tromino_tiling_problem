public class tromino {
    location L;
    String orientation;

    public tromino(location l, String orientation) {
        L = l;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "tromino{" +
                "L=" + L +
                ", orientation='" + orientation + '\'' +
                '}';
    }

    public location getL() {
        return L;
    }

    public String getOrientation() {
        return orientation;
    }
}
