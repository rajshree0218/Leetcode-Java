package org.example.interview.prep.microsoft;

import java.util.Scanner;

//Q5. Check If One String Is A Rotation Of Another String
//You are given two Strings 'P' and 'Q' of equal length. Your task is to check whether String 'P' can be converted into String 'Q' by cyclically rotating it to the right any number of times ( Possibly Zero ).
//A cyclic rotation to the right on String A consists of taking String A and moving the rightmost character to the leftmost position. For example, if A = "pqrst", then it will be "tpqrs" after one cyclic rotation on A.
//For example:
//Consider the two strings P = "abfyg" and Q = "gabfy" If we cyclically rotate String P to the right once. The resulting string P becomes "gabfy" which is equal to String Q. Therefore it is possible to convert String P to String Q.
//Input Format:
//The first line of the input contains an integer 'T', denoting the number of test cases. The first line of each test case contains the String 'P'. The second line of each test case contains the String 'Q'.
//Output Format:
//For each test case print 1 if String 'P' can be converted to String 'Q' by cyclically rotating it to the right any number of tines, otherwise print 0. Print the output of each test case in a new line.
//Note:
//You do not need to print anything, it has already been taken care of. Just implement the given function.
//Constraints:
//1 <= T <= 10 1 <= |P| , |Q| <= 10^5 |P| = |Q| String 'P' and 'Q' both have the same length and contain lowercase English letters only. Time Limit: 1 sec
//Follow Up:
//Can you solve this in O(N) time?
public class _05_3_StringRotation_KMPAlgo {

    //KMP(Knuth-Morris-Pratt) Algorithm for Substring search
    /*
    * By using the KMP algorithm to check if Q is a substring of P + P.
    * Steps:
    * 1. Concatenate string P with itself.
    * 2. Use the KMP algorithm to search for Q in the concatenated string.
    *
    * Time Complexity: O(N)
    * SC : O(N)
    * */

    public static boolean isRotation(String P, String Q) {
        String concatenatedP = P + P;
        return kmpSearch(concatenatedP, Q);
    }

    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        int n = text.length();
        int m = pattern.length();

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return true;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume newline after integer input

        for (int t = 0; t < T; t++) {
            String P = sc.nextLine();
            String Q = sc.nextLine();

            if (isRotation(P, Q)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        sc.close();
    }

    //Summary
    //Concatenation and Substring Check: This is the most efficient and preferred method with O(N) time complexity.
    //Brute Force: This method is simple but inefficient with O(N^2) time complexity.
    //KMP Algorithm: Efficient for large strings with O(N) time complexity but involves more complex implementation.
}
