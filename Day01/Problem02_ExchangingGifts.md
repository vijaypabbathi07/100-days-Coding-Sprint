# Day 01 – Problem 02: Exchanging Gifts

## Problem Statement

The royal family exchanges gifts at Christmas, where the youngest member receives gifts from everyone but doesn't give any gifts.

Given the data for all exchanged gifts among family members, identify the youngest member, who receives gifts from everyone but does not give any gifts.

**Note:** A family member does not give more than one gift to the same member.

## Input Format

- The first line contains two integers `n` and `m`, representing the number of family members and the number of gifts exchanged.
- The next `m` lines contain two integers `a` and `b`, representing a gift given by member `a` to member `b`.

## Output Format

Print the number representing the youngest member.

If no such member exists, print `-1`.

## Constraints

- 1 ≤ n ≤ 10⁴
- 0 ≤ m ≤ 10⁵
- 1 ≤ aᵢ, bᵢ ≤ n

## Sample Test Case 0

**Input:**
```text
2 1
1 2
```

**Output:**
```text
2
```

**Explanation:**

Family member 1 gave a gift to family member 2. Member 2 did not give any gift but received one from everyone else. Therefore, member 2 is the youngest.

## Sample Test Case 1

**Input:**
```text
3 2
1 3
2 3
```

**Output:**
```text
3
```

**Explanation:**

Member 3 received gifts from members 1 and 2 but did not give any gifts. Therefore, member 3 is the youngest.

## Java Solution

```java
import java.util.*;

public class Main {
    public static void find_youngest_member(int n, int m, int[][] gifts) {

        int[] count = new int[n + 1];
        boolean[] gave = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = gifts[i][0];
            int b = gifts[i][1];

            count[a]--;
            count[b]++;

            gave[a] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1 && gave[i] == false) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] gifts = new int[m][2];

        for (int i = 0; i < m; i++) {
            gifts[i][0] = scanner.nextInt();
            gifts[i][1] = scanner.nextInt();
        }

        find_youngest_member(n, m, gifts);
    }
}
```

## Explanation of the Logic

1. Create an array `count` to track the difference between gifts received and gifts given.
2. Create a boolean array `gave` to identify members who have given gifts.
3. For every gift from `a` to `b`:
   - Decrease `count[a]` by 1.
   - Increase `count[b]` by 1.
   - Mark `gave[a]` as true.
4. Check each member:
   - Their count must equal `n - 1`.
   - They must not have given any gifts.
5. If both conditions are satisfied, print their number.
6. Otherwise, print `-1`.

## Time Complexity

**O(n + m)**

We process all gifts once and then check all family members once.

## Space Complexity

**O(n + m)**

We use arrays of size `n + 1` and a gifts array of size `m × 2`.
