import java.util.ArrayList;

class Tromino_tiling {

    static int[][] board = new int[0][0];
    static ArrayList<tromino> trominos = new ArrayList<tromino>();

    public static void main(String[] args){

        int n = 4;
        location L = new location(0, 3);
        location b = new location(0, 0);
        tile(n, L, b);

        System.out.println(trominos.size());
        System.out.println("");
        for (tromino x : trominos){
            System.out.println(x);
        }

    }




    static void tile(int n, location L, location b) {
        String temp = "";
        if (n==2){
            System.out.println(L);
            System.out.println(b);
            System.out.println("");
            if(L.getX()==0 && L.getY()==0) temp = "UR";
            if(L.getX()==0 && L.getY()==1) temp = "LR";
            if(L.getX()==1 && L.getY()==0) temp = "UL";
            if(L.getX()==1 && L.getY()==1) temp = "LL";
            if(temp!="") trominos.add(new tromino(b.up().right(), temp));
            return;
        }

        //BL
        if(L.getX() + b.getX() <= n/2 && L.getY() + b.getY() <= n/2){
            temp = "UR";
        }
        //BR
        else if(L.getX() + b.getX() > n/2 && L.getY() + b.getY() <= n/2){
            temp = "UL";
        }
        //TL
        else if(L.getX() + b.getX() <= n/2 && L.getY() + b.getY() > n/2){
            temp = "LR";
        }
        //TR
        else if(L.getX() + b.getX() > n/2 && L.getY() + b.getY() > n/2){
            temp = "LL";
        }

         trominos.add(new tromino( new location(b.getX()+(n/2), b.getY()+(n/2)), temp));

        //BL
        if(temp!="UR") tile(n/2, new location(n/2-1, n/2-1), new location(0, 0));
        //BR
        if(temp!="UL") tile(n/2, new location(n/2-1, n/2-2), new location(n/2, 0));
        //TL
        if(temp!="LR") tile(n/2, new location(n/2-2, n/2-1), new location(0, n/2));
        //TR
        if(temp!="LL") tile(n/2, new location(n/2-2, n/2-2), new location(n/2, n/2));

    }

}
