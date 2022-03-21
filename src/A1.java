
class A1 {

    static int[][] board = new int[0][0];
    static int count = 1;

    public static void main(String[] args){

        System.out.println("Please give size of board and co-ordanates of the missing square");
        int n=8;
        location L = new location(7,0);

        location b = new location(0,0);
        board = new int[n][n];
        board[L.getX()][L.getY()]=count;

        //board[0][1]=true;

        tile(n, L, b);

        }




    static void tile(int n, location L, location b) {
        count++;




        for(int i = 8-1; i>=0; i--){
            System.out.print("|");
            for(int y = 0; y<8; y++){
                System.out.print(board[y][i]+"|");
            }

            System.out.println(" ");
            System.out.println("----------------------------------------------");
        }
        System.out.println(" ");


        if (n == 2) {
            int int1 = board[b.getX()][b.getY()];
            int int2 = board[b.getX()+1][b.getY()];
            int int3 = board[b.getX()][b.getY()+1];
            int int4= board[b.getX()+1][b.getY()+1];

            if(int1!=0 || int2!=0 || int3!=0 || int4!=0) {
                if (int1 == 0) board[b.getX()][b.getY()] = count;
                if (int2 == 0) board[b.getX() + 1][b.getY()] = count;
                if (int3 == 0) board[b.getX()][b.getY() + 1] = count;
                if (int4 == 0) board[b.getX() + 1][b.getY() + 1] = count;
            }

            return;
        }

        /*System.out.println(" ");
        System.out.println(n);
        System.out.println("Missing: "+ L.getX() +" "+ L.getY());
        System.out.println("bot: "+ b.getX() +" "+ b.getY());
        System.out.println("Middle: "+n/2);
        System.out.println(" ");*/



        System.out.println(" ");
        System.out.println(" ");


        //Right
        if (L.getX() - b.getX() > (n / 2)) {
            //Top
            if (L.getY() - b.getY() > (n / 2)) {
                System.out.println("TR");
                board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = count;
                board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = count;
                board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = count;


                tile(n/2, L, new location(n/2,n/2));


                tile(n/2, new location(n/2-1, n/2-1), b);

                tile(n/2, new location(n/2, n/2-1), new location(n/2,0));

                tile(n/2, new location(n/2-1, n/2), new location(0,n/2));

            }
            //Bot
            else {
                System.out.println("BR");
                board[(n / 2)+b.getX()][(n / 2)+b.getY()] = count;
                board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = count;
                board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = count;

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
                if (L.getY() - b.getY() > (n / 2)) {
                    System.out.println("TL");
                    board[(n / 2)+b.getX()][(n / 2)+b.getY()] = count;
                    board[(n / 2 - 1)+b.getX()][(n / 2 - 1)+b.getY()] = count;
                    board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = count;

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
                    board[(n / 2 - 1)+b.getX()][(n / 2)+b.getY()] = count;
                    board[(n / 2)+b.getX()][(n / 2 - 1)+b.getY()] = count;
                    board[(n / 2)+b.getX()][(n / 2)+b.getY()] = count;

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
