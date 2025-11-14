import java.util.Scanner;

public class Nqueens{




    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the Queen size");
        int n= sc.nextInt();

        char board[][]=new char[n][n];
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++ ){
                board[i][j]= '.' ;
            }
        }
        // printArray(board);
        // array and row 
        nQueen(board,0);
        
        System.out.println( "total no. of the boards are  "+count);
    }

    static int count=0;

    public static void nQueen(char[][] board, int row) {
        if (row==board.length) {
            printArray(board);
            count++;
            return ;
        }

        // loop
        for(int j=0; j<board.length; j++){

            if(isSafe(board , row , j))
           {
             board[row][j]='Q';
            nQueen(board, row+1);
            board[row][j]='.';
            // call function 
            //backtrac function 
           }

        }


        
    }


    public static boolean isSafe(char[][] board, int row, int col){

        //vertical up 
        for(int i=row-1; i>=0; i-- ){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // digonal left up 
        for(int i=row-1, j=col-1; i>=0 && j>=0; i-- , j-- ){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // diagonal right up 
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++ ){
            if(board[i][j]=='Q'){
                return false;
            }
        }
 

        return true;

    }



 public static void printArray(char board[][]){
    int n=board.length;
    System.out.println("`````````````chass board````````````````");
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }

 }


}