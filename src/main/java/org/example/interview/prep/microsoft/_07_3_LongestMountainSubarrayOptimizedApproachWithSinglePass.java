package org.example.interview.prep.microsoft;

import java.util.Scanner;

//Q7. Longest Mountain Subarray
//You are given an array of 'N' integers denoting the heights of the mountains. You need to find the length of the longest subarray which has the shape of a mountain.
//A mountain subarray is defined as a subarray which consists of elements that are initially in ascending order until a peak element is reached and beyond the peak element all other elements of the subarray are in decreasing order.
//Example:
//If the given array is: [1 3 1 4]. The longest mountain subarray would be 3. This is because the longest mountain is [1 3 1] having length 3.
//Input Format:
//The first line of input contains a single integer 'T', representing the number of test cases or queries to be run. Then the 'T' test cases follow. The first line of each test case contains a single integer 'N' representing the length of the array. The second line of each test case contains 'N' space-separated integers denoting the elements of the given array.
//Output Format:
//For each test case, print the length of the longest subarray which has the shape of a mountain in a seperate line.
//Constraints:
//1 ≤ T ≤ 10 1 ≤ N ≤ 10^5 1 ≤ Ai ≤ 10^9 Time Limit : 1 sec
//Note:
//You are not required to print the expected output, it has already been taken care of. Just implement the function.
public class _07_3_LongestMountainSubarrayOptimizedApproachWithSinglePass {

    public static int findLongestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int length = right - left + 1;
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(findLongestMountain(arr));
        }

        scanner.close();
    }
}
