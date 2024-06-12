package org.example.interview.prep.microsoft;

import java.util.Scanner;

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
public class _06_2_CelebrityProblemTwoPointer {

    // we can utilize a two-step approach:
    //1. Identify a potential celebrity: We use a two-pointer technique to narrow down the potential candidate for the celebrity.
    //2. Verify the potential celebrity: We confirm if the potential candidate is indeed a celebrity by checking the conditions:
    //  1.The celebrity should be known by everyone.
    //  2.The celebrity should not know anyone.

    //Steps to Implement:
    //1. Identifying a potential celebrity:
    //Start with two pointers, left at 0 and right at N-1.
    //Use the knows function to determine whether to move the left pointer forward or the right pointer backward.
    //This will help to narrow down to a single candidate.
    //
    //2. Verifying the potential celebrity:
    //Check if this candidate is known by everyone.
    //Check if this candidate knows no one.

    // TC : O(N)
    // SC : O(1)

    public static boolean knows(int A, int B){
        return false;
    }

    public static int findCelebrity(int N){
        int left =0;
        int right = N-1;

        // Step 1: Find the potential celebrity
        while(left < right){
            if(knows(left, right)){
                left++;
            } else {
                right--;
            }
        }

        int candidate = left;

        // Step 2: Verify the potential celebrity
        for(int i=0; i<N; i++){
            if(i!=candidate && (knows(candidate, i) || !knows(i, candidate))){
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            System.out.println(findCelebrity(N));
        }

        sc.close();
    }

    //Explanation:
    //1. Identify Potential Celebrity:
    //
    //Initialize two pointers, left and right.
    //Use the knows function to move the pointers:
    //  If left knows right, left cannot be a celebrity. Move left forward.
    //  If left does not know right, right cannot be a celebrity. Move right backward.
    //Continue this until left and right converge to a single candidate.
    //
    // 2. Verify Potential Celebrity:
    //
    //Ensure the candidate does not know anyone else.
    //Ensure everyone else knows the candidate.
}

class CelebrityProblemTwoPointers {
    private Helper helper;

    public CelebrityProblemTwoPointers(Helper helper) {
        this.helper = helper;
    }

    public int findCelebrity(int N) {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (helper.knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        int candidate = left;

        for (int i = 0; i < N; i++) {
            if (i != candidate && (helper.knows(candidate, i) || !helper.knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }
}

class Main {
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
            CelebrityProblemTwoPointers problem = new CelebrityProblemTwoPointers(helper);
            // CelebrityProblemStack problem = new CelebrityProblemStack(helper);
            // CelebrityProblemBruteForce problem = new CelebrityProblemBruteForce(helper);

            System.out.println(problem.findCelebrity(N));
        }

        sc.close();
    }
}


