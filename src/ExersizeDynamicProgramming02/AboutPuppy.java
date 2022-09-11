package ExersizeDynamicProgramming02;

import java.util.Date;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 11:02
 */
public class AboutPuppy {

    private static final int n = 10;

    public static void main(String[] args) {
        System.out.println(new Date());
        char[][] playArray = new char[n][];
        playArray[0] = new char[] { 'Щ', '-', '-', '*', '*', '-', '-', '-', '-', '-' };
        playArray[1] = new char[] { '-', '-', '-', '-', '*', '-', '*', '*', '-', '-' };
        playArray[2] = new char[] { '-', '-', '-', '*', '-', '*', '-', '-', '-', '*' };
        playArray[3] = new char[] { '-', '*', '-', '-', '-', '-', '-', '-', '-', '-' };
        playArray[4] = new char[] { '-', '-', '-', '*', '*', '-', '*', '-', '-', '-' };
        playArray[5] = new char[] { '-', '-', '*', '-', '-', '*', '-', '-', '-', '-' };
        playArray[6] = new char[] { '-', '-', '-', '*', '-', '-', '*', '*', '*', '-' };
        playArray[7] = new char[] { '-', '-', '-', '-', '-', '-', '-', '-', '*', '-' };
        playArray[8] = new char[] { '-', '-', '-', '-', '-', '-', '-', '-', '*', '-' };
        playArray[9] = new char[] { '-', '-', '-', '-', '-', '*', '*', '-', '-', '-' };

        System.out.println("Output the playing field");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(playArray[i][j] + " ");
            }
            System.out.println();
        }

        findPath(playArray, 8, 3);
    }

    public static void findPath(char field[][], int x0, int y0) {
        String[][] path = new String[n][n];
        char[][] memory = new char[n][n];
        int x = x0;
        int y = y0;

        // initializing memory array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memory[i][j] = '?';
            }
        }

        // initializing path array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = "нет";
            }
        }

        while (!((x == 0) && (y == 0))) {
            // the direction of the puppy
            char direction = whereFrom(field, x, y, memory);

            if (direction == 'N') {
                System.out.println("Нет такого пути :(");

            } else if (direction == 'U') {
                path[y][x] = "да";
                y--;

            } else if (direction == 'L') {
                path[y][x] = "да";
                x--;
            }
        }

        System.out.println();
        System.out.println("Output the result");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == x0 && i == y0) {
                    System.out.print('Ч' + " ");
                } else if (path[i][j] == "да") {

                    System.out.print('X' + " ");
                } else
                    System.out.print(field[i][j] + " ");

            }
            System.out.println();

        }

    }

    // function that returns the direction
    public static char whereFrom(char field[][], int x, int y, char memory[][]) {
        int leftX;
        int leftY;
        int upX;
        int upY;

        if (x > 0) {
            leftX = x - 1;
            leftY = y;

            if (leftX == 0 && leftY == 0) {// if we are at the goal
                memory[y][x] = 'L';
                return 'L';
            }

            if (field[leftY][leftX] != '*') {
                if (whereFrom(field, leftX, leftY, memory) != 'N') {
                    memory[y][x] = 'L';
                    return 'L';
                }
            }
        }

        if (y > 0) {
            upX = x;
            upY = y - 1;

            if (upX == 0 && upY == 0) {// // if we are at the goal
                memory[y][x] = 'U';
                return 'U';
            }

            if (field[upY][upX] != '*') {
                if (whereFrom(field, upX, upY, memory) != 'N') {
                    memory[y][x] = 'U';
                    return 'U';
                }
            }
        }

        memory[y][x] = 'N';
        return 'N';
    }
}
