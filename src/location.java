public class location {
    int x;
    int y;

    public location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }



    public location up(){
        return new location(x, y+1);
    }

    public location down(){
        return new location(x, y-1);
    }

    public location left(){
        return new location(x-1, y);
    }

    public location right(){
        return new location(x+1, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
