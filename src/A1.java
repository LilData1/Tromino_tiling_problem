
class A1 {

    static boolean[][] board = new boolean[0][0];


    public static void main(String[] args){

        System.out.println("Please give size of board and co-ordanates of the missing square");
        int n=8;
        location L = new location(0,7);

        location b = new location(0,0);
        board = new boolean[n][n];
        board[L.getX()][L.getY()]=true;

        tile(n, L, b);


        for(int i = 0; i<n; i++){
            for(int y = n-1; y>=0; y--){
                if(board[i][y])System.out.print("X|");
                else System.out.print(" |");

            }

            System.out.println(" ");
            System.out.println("----------------------------------------------");
        }
    }


    static void tile(int n, location L, location b) {
        if (n == 2) return;


        for(int i = 0; i<8; i++){
            System.out.print("|");
            for(int y = 8-1; y>=0; y--){
                if(board[i][y])System.out.print("X|");
                else System.out.print(" |");

            }

            System.out.println(" ");
            System.out.println("----------------------------------------------");
        }
        System.out.println(" ");

        System.out.println(" ");
        System.out.println(n);
        System.out.println("Missing: "+ L.getX() +" "+ L.getY());
        System.out.println("bot: "+ b.getX() +" "+ b.getY());
        System.out.println("Middle: "+n/2);
        System.out.println(" ");



        System.out.println(" ");
        System.out.println(" ");


        //Right
        if (L.getX() + b.getX() > (n / 2)) {
            //Top
            if (L.getY() + b.getY() > (n / 2)) {
                System.out.println("TR");
                board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = true;
                board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = true;
                board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = true;

                //TR
                tile(n/2, L, new location(n/2,n/2));

                //BL
                tile(n/2, new location(n/2-1, n/2-1), b);
                //BR
                tile(n/2, new location(n/2, n/2-1), new location(n/2,0));
                //TL
                tile(n/2, new location(n/2-1, n/2), new location(0,n/2));

            }
            //Bot
            else {
                System.out.println("BR");
                board[(n / 2)+b.getX()][(n / 2)+b.getY()] = true;
                board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = true;
                board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = true;

                //BR
                tile(n/2, L, new location(n/2,0));

                //BL
                tile(n/2, new location(n/2-1, n/2-1), b);
                //TL
                tile(n/2, new location(n/2-1, n/2), new location(0,n/2));
                //TR
                tile(n/2, new location(n/2, n/2), new location(n/2,n/2));
            }
        }   //Left
            else{
                //Top
                if (L.getY() + b.getY() > (n / 2)) {
                    System.out.println("TL");

                    board[(n / 2)+b.getX()][(n / 2)+b.getY()] = true;
                    board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = true;
                    board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = true;

                    //TL
                    tile(n/2, L, new location(0,n/2));

                    //TR
                    tile(n/2, new location(n/2-1, n/2-1), b);
                    //BR
                    tile(n/2, new location(n/2, n/2-1), new location(n/2,0));
                    //BL
                    tile(n/2, new location(n/2, n/2), new location(n/2,n/2));
                }
                //Bot
                else {
                    System.out.println("BL");
                    board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = true;
                    board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = true;
                    board[(n / 2)+b.getX()][(n / 2)+b.getY()] = true;

                    //BL
                    tile(n/2, L, b);

                    //BR
                    tile(n/2, new location(n/2, n/2-1), new location(n/2,0));
                    //TL
                    tile(n/2, new location(n/2-1, n/2), new location(0,n/2));
                    //TR
                    tile(n/2, new location(n/2, n/2), new location(n/2,n/2));
                }


            }


        }
    }
