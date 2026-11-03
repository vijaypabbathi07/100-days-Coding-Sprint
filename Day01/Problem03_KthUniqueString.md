# Day 01 – Problem 03: Kth Unique String

## Problem Statement
Given N strings, find the kth string that appears exactly once in the collection. If fewer than k unique strings exist, print -1.

## Input Format
- First line contains N.
- Next N lines contain the strings.
- Last line contains k.

## Output Format
Print the kth unique string or -1.

## Sample Input
```text
6
d
b
c
b
c
a
2
```

## Sample Output
```text
a
```

## Java Solution
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int k = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == 1) {
                count++;

                if (count == k) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

        System.out.println(-1);
        sc.close();
    }
}
```

## Explanation
1. Read N strings and store them in an array.
2. Use a HashMap to count the frequency of each string.
3. Traverse the array again and consider only strings with frequency 1.
4. Print the kth unique string. If it does not exist, print -1.

## Complexity
- **Time Complexity:** O(N × L) average case.
- **Space Complexity:** O(N × L).

Here, L is the maximum length of a string.
