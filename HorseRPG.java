//姓名 : 鍾明智
//學號 : 107213067
import java.util.Scanner;
public class HorseRPG {
    // Below arrays details all 8 possible movements for a knight.
    // Don't change the sequence of below arrays
    public static final int[] row = { 2, 1, -1, -2, -2, -1,  1,  2 , 2 };
    private static final int[] col = { 1, 2,  2,  1, -1, -2, -2, -1, 1 };
    private static int times = 0; //marker how many times

    // Check if (x, y) is valid chess board coordinates
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;

        return true;
    }

    //print out the result
    private static void print(int times){
        System.out.println(times+" Ways of Method");
    }

    // Recursive function to perform the Knight's tour using backtracking
    private static void knightTour(int[][] visited, int x, int y, int pos, int n, int m) {
        // mark current square as visited
        visited[x][y] = pos;
        // if all squares are visited, print the solution
        if (pos >= n*m) {
            times++; //times +1 every all squares are visited
            // backtrack before returning
            visited[x][y] = 0;
            return;
        }
        // check for all 8 possible movements for a knight
        // and recur for each valid movement
        for (int k = 0; k < 8; k++) {
            // Get the new position of Knight from current
            // position on chessboard
            int newX = x + row[k];
            int newY = y + col[k];

            // if new position is a valid and not visited yet
            if (isValid(newX, newY, n, m) && visited[newX][newY] == 0) {
                knightTour(visited, newX, newY, pos + 1, n, m);
            }
        }
        // backtrack from current square and remove it from current path
        visited[x][y] = 0;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //row
        int m = input.nextInt(); //column
        int xituy = input.nextInt(); //x coordinate
        int yitux = input.nextInt(); //y coordinate
        int[][] visited = new int[n][m]; //make the board
        int pos = 1; //pos as marker

        // start knight tour from corner square (0, 0)
        knightTour(visited, yitux, xituy, pos, n, m);
        print(times);
    }
}