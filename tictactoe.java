import java.util.Scanner;

public class tictactoe{
    private static Scanner scnr = new Scanner(System.in);
    private static String[][] board = new String[3][3];
    private static final String PLAYER0CHARAC = "X";
    private static final String PLAYER1CHARAC = "O";
    public static void main(String[] args) {
        initialiseBoard();
        int currentPlayer = 1;
        while (gameOn()){
            currentPlayer = (currentPlayer+1)%2;
        int playerPos = readPlayerInput();
        if (isValid(playerPos)){
            updateBoard(playerPos, currentPlayer);
       }
        printBoard();
    }
        System.out.println("The winner is player "+ currentPlayer);

    }

    private static void printBoard() {
        System.out.println("\n------------");
        for (int row = 0; row < 3; row++){
            System.out.print("|");
            for (int column = 0; column < 3; column++){
                System.out.print(" " + board[row][column] + " |");
            }
            System.out.println("\n------------");
        }
    }
    //Supposed to update the board after each turn
    private static void updateBoard(int playerPos, int currentPlayer) {
        if (isValid(playerPos)) {
            int row = (playerPos -1) / 3;
            int column = (playerPos -1) % 3;
            if (currentPlayer == 0){
                board[row][column] = PLAYER0CHARAC;
            }
            else if (currentPlayer == 1) {
                board[row][column] = PLAYER1CHARAC;
            }
        }
    }
    //Function that handle's exceptional inputs
    private static boolean isValid(int playerPos) {
        if (playerPos >= 1 && playerPos < 10) {
            int row = (playerPos - 1) / 3;
            int column = (playerPos - 1) % 3;
            if (board[row][column].equals("-")) {
                return true;
            } else {
                System.out.println("Invalid move. Can't steal your buddy's move!");
                return false;
            }
        } else {
            System.out.println("Invalid move. Values between 1 and 9 only!");
            return false;
        }
    }

    private static int readPlayerInput() {
        System.out.println("Enter your placements ( 1 - 9): ");
        return scnr.nextInt();
    }

    private static boolean gameOn() {
        //Game would stop if either of the players win
        //Lets start checking the rows
        for (int row = 0; row < 3; row++){
            if ((board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) && !board[row][0].equals("-")){

                return false;
            }
        }

        // column check
        for (int column = 0; column < 3; column ++) {
            if ((board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) && (! board[0][column].equals("-")) ){

                return false;
            }
        }

        // diagonal check (top-left to bottom-right)
        if ((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) && !board[1][1].equals("-")) {

                return false;
            }


        // diagonal check (top-right to bottom-left)
        if ((board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) && ! board[1][1].equals("-")) {

                return false;
            }

        return true;
    }
    private static void initialiseBoard() {
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                board[row][column] = "-";

            }
        }
    }

}
