package org.example.interview.prep.microsoft;

import java.util.Arrays;
import java.util.Scanner;

//Q2. 9268 | Chess Tournament
//Chess tournament is going to be organized in Ninjaland. There will be C chess players going to attend the tournament. All the players will be staying in a hotel. The hotel has N free rooms available for the players, where one player will choose one room to live in. The ith room is at position[i] in the hotel. All rooms are in distinct positions.
//Focus level of a chess player is defined as the minimum distance between his room and the room of another player. The overall focus of a tournament is defined as the minimum focus level among all players. You as an organizer obviously want the overall focus as high as possible so you assign the rooms to players such that the overall focus is as high as possible.
//For example,
//let say we have 3 players and 5 rooms available and the rooms are at positions: 1 2 3 4 6 Here the optimal allocation is in rooms 1 3 6 and the overall focus level is 2.
//Input format :
//The first line of input contains a single integer T, representing the number of test cases or queries to be run. Then the T test cases follow. The first line of each test case contains two positive integers N and C, which represent the number of rooms in the hotel and the number of chess players. The next line contains N space-separated positive integers representing the position of available room in the hotel.
//Output Format :
//For each test case, print a single integer, representing the maximum overall focus of the tournament. Print the output of each test case in a separate line.
//Note:
//You do not need to print anything. It has already been taken care of. Just implement the given function.
//Constraint :
//1 <= T <= 10 2 <= N <= 10 ^ 4 2 <= C <= N 1 <= positions[i] <= 10 ^ 9 Time Limit: 1 sec
public class _02_3_ChessTournamentOptimizedBinarySearch {

    // Binary Search Approach
    /*
    * this is the most efficient approach. Here we use binary search to find the maximum possible minimum distance b/w any two players.
    * Steps:
    * 1. sort the room positions.
    * 2. use binary search on the possible values of the minimum distance b/w any two players.
    * 3. for each midpoint in the binary search, use a greedy method to check if it is possible to place all players such that the minimum distance is at least this midpoint.
    * 4. adjust the search space based on the feasibility of placement.
    *
    * Time Complexity Analysis :
    * Sorting : O(N log N) for sorting the positions.
    * Binary Search : O(log D), Where d is the range of distance.
    * Feasibility check : O(N) for each iteration of the binary search.
    * Overall complexity : O(T * (N log N + N log D)), where T is the number of test cases
    *
    * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int C = sc.nextInt();

            int[] positions = new int[N];
            for(int i=0; i<N; i++){
                positions[i] = sc.nextInt();
            }
            Arrays.sort(positions);

            int left = 1;
            int right = positions[N-1] - positions[0];
            int result = 0;

            while(left< right){
                int mid = left + (right-left)/2;

                if(canPlacePlayers(positions, C, mid)){
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

    private static boolean canPlacePlayers(int[] positions, int C, int minDist){
        int count =1; // place 1st players in 1st room
        int lastPosition = positions[0];

        for(int i=1; i<positions.length; i++){
            if(positions[i] - lastPosition >= minDist){
                count++;
                lastPosition = positions[i];

                if(count >= C){
                    return true;
                }
            }
        }

        return false;
    }

    // Time Complexity Analysis in details :
    /*
    * Sorting:
    *   Sorting the positions array takes O(NlogN) time complexity using efficient sorting algorithms like quicksort or mergesort.
    * Binary Search:
    *   The binary search is performed on the possible values of the minimum distance between any two players, which ranges from 1 to the difference between the maximum and minimum room positions. Let's denote this range as D.
    *   Binary search has a time complexity of O(logD).
    * Feasibility Check:
    *   For each iteration of the binary search, a feasibility check is performed using a greedy method to check if it's possible to place all players with at least the midpoint distance apart.
    *   The feasibility check traverses the sorted positions array once, which takes O(N) time complexity.
    *
    * Overall Time Complexity:
    *   Sorting:        O(NlogN)
    *   Binary Search: O(logD)
    *   Feasibility Check (per iteration): O(N)
    *
    * Since the binary search operates within the range D, where D is the difference between the maximum and minimum room positions, the overall time complexity of the optimized solution is given by:
    * O(T⋅(NlogN+logD⋅N))
    * Here, T is the number of test cases. This complexity captures the overhead of sorting the positions, performing binary search, and the feasibility check for each iteration of the binary search.
    * */

    /*
        Sure, let's consider the example input and walk through how the optimized binary search approach works to find the maximum possible minimum focus level.

        ### Example Input:

        ```
        T = 1 (1 test case)
        N = 5 (5 rooms)
        C = 3 (3 players)
        Positions: 1 3 4 7 9

        ### Optimized Binary Search Approach:

        1. **Sorting**:
           - First, we sort the room positions:
             ```
             Sorted Positions: 1 3 4 7 9
             ```

        2. **Binary Search**:
           - We perform a binary search on the range of distances between the minimum and maximum room positions.
           - The search space for the minimum distance is between 1 and the difference between the maximum and minimum room positions.
           - Let's denote the range of distances as \(D\), which is \(9 - 1 = 8\).

        3. **Iteration 1 (Midpoint = 4)**:
           - We check if it's possible to place all players such that the minimum distance between any two players is at least 4.
           - We start by placing the first player in the first room (position 1).
           - Then, we try to place the second player in the next room that is at least 4 units away. We can place the second player in room 4.
           - Finally, we try to place the third player. Since there are no more rooms at least 4 units away from room 4, we cannot place all players with at least a 4-unit distance.
           - So, we move to the lower half of the search space.

        4. **Iteration 2 (Midpoint = 2)**:
           - We check if it's possible to place all players such that the minimum distance between any two players is at least 2.
           - Using the same greedy strategy, we can place all players with a minimum distance of 2 units between any two players.
           - We can place the first player in room 1, the second player in room 4, and the third player in room 9.
           - Since this placement is possible, we move to the upper half of the search space.

        5. **Iteration 3 (Midpoint = 3)**:
           - We check if it's possible to place all players such that the minimum distance between any two players is at least 3.
           - Using the same greedy strategy, we can place all players with a minimum distance of 3 units between any two players.
           - We can place the first player in room 1, the second player in room 4, and the third player in room 9.
           - Since this placement is possible, we move to the upper half of the search space.

        6. **Final Result**:
           - The search space reduces to the range [3, 8].
           - The binary search converges to the maximum possible minimum distance between any two players, which is 4.

        ### Example Output:
        For the given example input, the maximum possible minimum focus level (the minimum distance between any two players) achieved by the optimized binary search approach is 4. This means that the minimum distance between any two players in the tournament can be 4 rooms apart.
         * */
}
