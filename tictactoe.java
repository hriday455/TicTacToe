import java.util.Scanner;
public class tictactoe {
    
    static char [][] board={
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}

    };
   
    static char currentPlayer='X';
    // printing the board
    public static void printBoard(){
        System.out.println("Welcome to The game");
        for(int i=0;i<3;i++){ // row
            System.out.print("| ");
        
        for(int j=0;j<3;j++){// col
            System.out.print(board[i][j] + " | ");
        }
    }
        System.out.println();
    }
    public static boolean isValidMove(int i,int j){
        return i>0 && i<3 && j>0 && j<3 && board[i][j] == ' ';
    }
    public static void makemove(int i,int j){
        if(isValidMove(i,j)){
            board[i][j] = currentPlayer;
        }
        else{
            System.out.println("move is not valid");
        }
    }
    public static boolean checkWin() {
        for(int i=0;i<3;i++){
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer){
                return true;
            }
            if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
            {
                return true;
            }
        }
        if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
            return true;
        }
        if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
            return true;
        }
        return false;
    }
    public static boolean checkDraw() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] ==' '){
                    return false;
                }
            }
        }
        return true;
    }
    public static void switchPlayer(){
        currentPlayer=(currentPlayer == 'x')?'0':'x';
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean gameEnded=false;
        System.out.println("---------------------GAME START------------------");
        while(!gameEnded){
            printBoard();
            int i , j;
            do{
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                i = sc.nextInt() - 1;
                j = sc.nextInt() - 1;
            } while(!isValidMove(i,j));
            makemove (i,j);

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (checkDraw()) {
                printBoard();
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                switchPlayer();
            }
        }
        sc.close();
    }
}
