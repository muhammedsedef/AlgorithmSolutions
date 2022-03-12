import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    String[][] board;
    String[][] map;
    boolean isGameOver;

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.board = new String[rowNumber][colNumber];
        this.map = new String[rowNumber][colNumber];
        this.isGameOver = false;
    }

    void run() {
        int success = 0;
        fillBoard();
        System.out.println("Positions of Mines: ");
        printMap(map);
        System.out.println("Map of the game: ");

        Scanner input = new Scanner(System.in);
        while (!isGameOver) {
            printMap(board);
            System.out.println("Please enter a row : ");
            int selectedRow = input.nextInt();
            System.out.println("Please enter a column : ");
            int selectedCol = input.nextInt();

            int length = this.rowNumber * this.colNumber;
            if ((selectedRow < 0 || selectedRow >= rowNumber) || (selectedCol < 0 || selectedCol >= colNumber)) {
                System.out.println("You Entered the Wrong Coordinate ");
                continue;
            }

            if (isSweeper(selectedRow, selectedCol)) {
                System.out.println("Game is over! You stepped on a mine");
                isGameOver = true;
            } else {
                System.out.println("You didn't step on a mine, congratulations!");
                calcSweeper(selectedRow, selectedCol);
                success++;
                if(success == (this.rowNumber * this.colNumber) - ((this.rowNumber * this.colNumber) / 4)) {
                    System.out.println("Congratulations, you won the game!");
                    break;
                }
            }
        }
    }

    void fillBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                this.map[row][col] = "- ";
                this.board[row][col] = "- ";
            }
        }

        int sweeperCount = (this.rowNumber * this.colNumber) / 4;
        int count = 0;
        Random random = new Random();

        while (count != sweeperCount) {
            int randomRow = random.nextInt(this.rowNumber);
            int randomCol = random.nextInt(this.colNumber);
            if (!this.map[randomRow][randomCol].equals("* ")) {
                this.map[randomRow][randomCol] = "* ";
                count++;
            }
        }
    }

    void printMap(String[][] arr) {
        for (String[] row : arr) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    void calcSweeper(int selectedRow, int selectedCol) {
        // 1 - 1 => 1 - 2 =>  right side
        int count = 0;
        if ((selectedCol + 1 <= this.colNumber - 1) && (map[selectedRow][selectedCol + 1].equals("* "))) {
            count++;
            board[selectedRow][selectedCol] = count + " ";
        }
        // underside => 1 - 1 => 2 - 1
        if ((selectedRow + 1 <= this.rowNumber - 1) && (map[selectedRow + 1][selectedCol].equals("* "))) {
            count++;
            board[selectedRow][selectedCol] = count + " ";
        }
        // left side => 1-1 => 1 - 0
        if ((selectedCol - 1 >= 0) && (map[selectedRow][selectedCol - 1].equals("* "))) {
            count++;
            board[selectedRow][selectedCol] = count + " ";
        }
        // top side => 1-1 => 0 1
        if ((selectedRow - 1  >= 0) && (map[selectedRow - 1][selectedCol].equals("* "))) {
            count++;
            board[selectedRow][selectedCol] = count + " ";
        }
        else{
            board[selectedRow][selectedCol] = count + " ";
        }
    }


    boolean isSweeper(int selectedRow, int selectedCol) {
        return this.map[selectedRow][selectedCol].equals("* ") ? true : false;
    }
}
