import java.awt.*;
import java.util.ArrayList;

/**
 * Sorry couldnt get this to fully work.
 * It still has bugs for 8x8 and 16x16 but should still work for 4x4
 */
class Tromino_tiling {

    static int[][] board = new int[0][0];
    public static ArrayList<tromino> trominos = new ArrayList<tromino>();

    public static void main(String[] args){

        location b = new location(0, 0);

        //n = size of board
        int n = 16;
        //L = location of missing square x=0, y=0 - x=n-1, y=n-1
        location L = new location(0, 0);

        tile(n, L, b);

        for (tromino x : trominos){
            System.out.println(x);
        }

        Frame frame = new Frame();
        frame.add(new paint());
        int frameWidth = 1000;
        int frameHeight = 1000;
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);




    }




    static void tile(int n, location L, location b) {
        String temp = "";
        if (n==2){
            if(L.getX()==0 && L.getY()==0) temp = "UR";
            if(L.getX()==0 && L.getY()==1) temp = "LR";
            if(L.getX()==1 && L.getY()==0) temp = "UL";
            if(L.getX()==1 && L.getY()==1) temp = "LL";
            System.out.println(temp);
            System.out.println("");
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
        if(temp!="UR") tile(n/2, new location(n/2-1, n/2-1), b);
        else tile(n/2, L, b);
        //BR
        if(temp!="UL") tile(n/2, new location(n/2, n/2-1), new location(b.getX()+n/2, b.getY()));
        else tile(n/2, new location(L.getX()-n/2, L.getY()), new location(b.getX()+n/2, b.getY()));
        //TL
        if(temp!="LR") tile(n/2, new location(n/2-1, n/2-2), new location(b.getX(), b.getY()+n/2));
        else tile(n/2, new location(L.getX(), L.getY()-n/2), new location(b.getX(), b.getY()+n/2));
        //TR
        if(temp!="LL") tile(n/2, new location(n/2-2, n/2-2), new location(b.getX()+n/2, b.getY()+n/2));
        else tile(n/2, new location(L.getX()-n/2, L.getY()-n/2), new location(b.getX()+n/2, b.getY()+n/2));


    }

}
