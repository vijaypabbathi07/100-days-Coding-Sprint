// Day 1 - Problem 1
// Problem: Chessboard Color
// Platform: Unstop
import java.util.Scanner;

public class Main {
    public static String determineColor(String s) {
        int col = s.charAt(0) - 'a';
        int row = s.charAt(1) - '1';

        if ((col + row) % 2 == 0) {
            return "Black";
        } else {
            return "White";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        System.out.println(determineColor(s));
        scanner.close();
    }
}
