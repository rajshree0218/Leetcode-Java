package org.example.interview.prep.microsoft;

import java.util.Scanner;
import java.util.Stack;

//Q6. The Celebrity Problem
//There are ‘N’ people at a party. Each person has been assigned a unique id between 0 to 'N' - 1(both inclusive). A celebrity is a person who is known to everyone but does not know anyone at the party.
//Given a helper function ‘knows(A, B)’, It will returns "true" if the person having id ‘A’ know the person having id ‘B’ in the party, "false" otherwise. Your task is to find out the celebrity at the party. Print the id of the celebrity, if there is no celebrity at the party then print -1.
//Note:
//1. The helper function ‘knows’ is already implemented for you. 2. ‘knows(A, B)’ returns "false", if A doesn't know B. 3. You should not implement helper function ‘knows’, or speculate about its implementation. 4. You should minimize the number of calls to function ‘knows(A, B)’. 5. There are at least 2 people at the party. 6. At most one celebrity will exist.
//Input format:
//The first line of input contains an integer ‘T’ denoting the number of test cases. The description of ‘T’ test cases follows. The first line of each test case contains an integer ‘N’, representing the number of people in the party.
//Output format :
//For each test case, print an integer representing the id of the celebrity. If there is no celebrity at the party then print -1.
//Note:
//You do not need to print anything, it has already been taken care of. Just implement the given function.
//Constraints:
//1 <= T <= 50 2 <= N <= 10^4 Where ‘T’ is the total number of test cases, ‘N’ is the number of people at the party. Time Limit: 1sec
public class _06_4_CelebrityProblemUsingStack {
    //Description: Use a stack to eliminate non-celebrities. Compare the top two elements and remove one based on the knows function.
    // TC : O(N),  because each person is pushed and popped from the stack once.
    // SC : O(N), due to stack

    private Helper helper;

    public _06_4_CelebrityProblemUsingStack(Helper helper) {
        this.helper = helper;
    }

    public int findCelebrity(int N) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int A = stack.pop();
            int B = stack.pop();
            if (helper.knows(A, B)) {
                stack.push(B);
            } else {
                stack.push(A);
            }
        }

        int candidate = stack.pop();

        for (int i = 0; i < N; i++) {
            if (i != candidate && (helper.knows(candidate, i) || !helper.knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }
}

class MainStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            boolean[][] matrix = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextBoolean();
                }
            }

            Helper helper = new Helper(matrix);

            // Choose the approach to test
//            CelebrityProblemTwoPointers problem = new CelebrityProblemTwoPointers(helper);
             _06_4_CelebrityProblemUsingStack problem = new _06_4_CelebrityProblemUsingStack(helper);
            // CelebrityProblemBruteForce problem = new CelebrityProblemBruteForce(helper);

            System.out.println(problem.findCelebrity(N));
        }

        sc.close();
    }
}
