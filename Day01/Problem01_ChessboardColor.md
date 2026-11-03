# Day 01 – Problem 01: Chessboard Color

## Problem Statement

![Chessboard representation](https://d8it4huxumps7.cloudfront.net/uploads/courseDetails/628db68ec030d_picture_1.png)

Above is the standard representation of a chessboard.

This could be imagined as a 2D Cartesian plane, with the x-axis represented by the alphabets and the y-axis by the numbers.

Given coordinates in the form of a string, print if that cell is White or Black.

## Input Format
First line contains a string `s`.

## Output Format
Print `White` or `Black`.

## Constraints
- |s| = 2

## Sample Test Case 0

**Input:**
```text
b2
```

**Output:**
```text
Black
```

## Sample Test Case 1

**Input:**
```text
a1
```

**Output:**
```text
Black
```

## Java Solution
import java.util.Scanner;

public class Main {
    public static String determineColor(String s) {
        int column = s.charAt(0) - 'a';
        int row = s.charAt(1) - '1';

        if ((column + row) % 2 == 0) {
            return "Black";
        } else {
            return "White";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String result = determineColor(s);
        System.out.println(result);
    }
}


## Explanation
1. Convert the alphabet into a column number.
2. Convert the digit into a row number.
3. Add the row and column values.
4. If the sum is even, print `Black`.
5. Otherwise, print `White`.

## Time Complexity
O(1)

## Space Complexity
O(1)
