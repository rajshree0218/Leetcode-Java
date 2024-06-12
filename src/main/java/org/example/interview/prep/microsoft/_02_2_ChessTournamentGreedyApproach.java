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
public class _02_2_ChessTournamentGreedyApproach {

    // Greedy Approach
    /*
    * In greedy approach, we sort the position and the place of players in the rooms greedily, trying to maximize the minimum distance step by step.
    * Steps:
    * 1. sort the room positions.
    * 2. Place the first player in the first room.
    * 3. For each subsequent player, place them in the next room that maximize the distance from last placed player.
    *
    * :::: This approach also becomes complex for larger inputs
    *
    * Time Complexity : O(NlogN+logD⋅N)
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int N = sc.nextInt(); // number of rooms
            int C = sc.nextInt(); // number of players

            int[] positions = new int[N];
            for(int i=0; i<N; i++){
                positions[i] = sc.nextInt();
            }
            Arrays.sort(positions);

            int result = greedyMaxFocus(positions, N, C);
            System.out.println(result);
        }
        sc.close();
    }

    private static int greedyMaxFocus(int[] positions, int N, int C){
        int left = 0;
        int right = positions[N-1] - positions[0];
        int result = 0;

        while(left < right){
            int mid = left + (right - left)/2;

            if(canPlayPlayer(positions, C, mid)){
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return result;
    }

    private static boolean canPlayPlayer(int[] positions, int C, int minDist){
        int count =1;
        int lastPosition = positions[0];

        for(int i=1; i<positions.length; i++){
            if(positions[i]- lastPosition >= minDist){
                count++;
                lastPosition = positions[i];
                if(count == C)
                    return true;
            }
        }
        return false;
    }

   //Greedy Approach:
    //Sorting: Sorting the positions array takes O(NlogN) time complexity.
    //Binary Search: The binary search in the greedy approach is performed on the possible values of the minimum distance between any two players.
    //It has a time complexity of O(logD), where D is the range of distances.
    //Feasibility Check (per Iteration): The feasibility check in each iteration of the binary search traverses the sorted positions array once, taking O(N) time complexity.
    //Overall Time Complexity:
    //
    //Since the binary search operates within the range D, the overall time complexity of the greedy approach is O(NlogN+logD⋅N).
    //Greedy Approach: O(NlogN+logD⋅N)

    /*
    * Example Scenario:
        Suppose we have the following input:

        makefile
        Copy code
        T = 1 (1 test case)
        N = 5 (5 rooms)
        C = 3 (3 players)
        Positions: 1 3 4 7 9
        Brute Force Approach:
        For the brute force approach, we generate all possible combinations of room assignments for 3 players out of 5 rooms:

        1 3 4
        1 3 7
        1 3 9
        1 4 7
        1 4 9
        1 7 9
        3 4 7
        3 4 9
        3 7 9
        4 7 9
        Then, for each combination, we calculate the minimum distance between any two players and find the maximum of these minimum distances.

        Greedy Approach:
        For the greedy approach, we sort the room positions first:

        1 3 4 7 9
        Then, we perform a binary search on the range of distances between the minimum and maximum room positions to find the maximum possible minimum distance between any two players.

        For example, if we consider the midpoint of the range, 4, we check if it's possible to place all players such that the minimum distance between any two players is at least 4:

        We start by placing the first player in the first room (position 1).
        Then, we try to place the next player in the next room that is at least 4 units away. We can place the second player in room 4.
        Finally, we try to place the third player. Since there are no more rooms at least 4 units away from room 4, we cannot place all players with at least a 4-unit distance. So, we move to the lower half of the search space.
        We continue this process until we find the maximum possible minimum distance between any two players.

        Example Output:
        For the given input, let's assume the outputs for the brute force, greedy, and optimized binary search approaches are as follows:

        Brute Force: 3
        Greedy: 4
        Optimized Binary Search: 4
        These outputs represent the maximum possible minimum focus level (the minimum distance between any two players) achieved by each approach for the given input scenario.
    * */
}
