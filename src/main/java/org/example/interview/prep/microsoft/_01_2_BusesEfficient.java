package org.example.interview.prep.microsoft;

import java.util.Scanner;

//Q1. Buses
//You are given a vector of 'N' integers denoting the number of buses that can be boarded from the i-th
// position. The bus stops only at stops whose number is a multiple of the bus stop number from which the
// bus originates. You need to find the number of buses originating from each bus stop from 1 to 'N'.
//For example:
//If 'N' = 4 and the given vector is: [1 3 4 3]. 1 bus can be boarded from the first bus stop which means
// that 1 bus originates from the first bus stop. 3 buses can be boarded from the second bus stop which
// means that (3 - 1 = 2) buses originate from the second bus stop. This is because the bus originating
// from the first stop will stop at the second stop as well. 4 buses can be boarded from the third bus
// stop which means that (4-1 = 3) buses originate from the third bus stop. This is because the bus
// originating from the first stop will stop at the third stop as well. 3 buses can be boarded from the
// fourth bus stop which means that (3-3 = 0) buses originate from the fourth bus stop. This is because
// the buses originating from the first and second stop will stop at the fourth stop as well. So the
// final vector would be: [1 2 3 0].
//Note:
//The given vector uses 1-based indexing.
//Input Format:
//The first line of input contains a single integer 'T', representing the number of test cases or queries
// to be run. Then the 'T' test cases follow. The first line of each test case contains a single integer
// 'N' representing the length of the vector. The second line of each test case contains 'N' space-separated
// integers denoting the elements of the given vector.
//Output Format:
//For each test case, print 'N' integers denoting the number of buses originating from each bus stop
// from 1 to 'N'.
//Note:
//You are not required to print the expected output, it has already been taken care of. Just implement
// the function.
//Constraints:
//1 ≤ T ≤ 50 1 ≤ N ≤ 10^4 1 ≤ Ai ≤ 10^6 Time Limit : 1 secs
public class _01_2_BusesEfficient {

    // Efficient Approach using cumulative sum
    /*
    * Idea :
    * 1. use a cumulative sum to track the buses that are stopping at each bus stop due to previous stops.
    * 2. update the cumulative sum as we calculate the originating buses.
    *
    * Steps:
    * 1. Initialize the array to store the originating buses.
    * 2. Maintain a cumulative sum of originating buses.
    * 3. for each bus stop, calculate the originating buses by subtracting the cumulative sum from the total buses.
    * 4. update the cumulative sum with originating buses.
    *
    * Complexity:
    * Time Complexity: O(N) for each test case.
    * Space Complexity: O(N).
    *
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] buses = new int[N];

            for(int i=0; i<N; i++){
                buses[i] = sc.nextInt();
            }

            int[] result = new int[N];
            int cumulativeSum = 0;
            for(int i=0; i<N; i++){
                result[i] = buses[i] - cumulativeSum;
                cumulativeSum += result[i];
            }

            for(int i=0; i<N; i++){
                System.out.print(result[i] + (i<N-1 ?  " ":"\n"));
            }
        }
        sc.close();
    }
    
    // Examples explanations :
    //Example 1:
    //Input:
    //1
    //4
    //1 3 4 3
    //Explanation:
    //
    //For bus stop 1:
    //Total buses: 1
    //Buses originating from stop 1: 1 (since there are no previous stops to subtract from)
    //For bus stop 2:
    //Total buses: 3
    //Buses from stop 1: 1 (since bus from stop 1 will stop at stop 2)
    //Buses originating from stop 2: 3 - 1 = 2
    //For bus stop 3:
    //Total buses: 4
    //Buses from stop 1: 1 (bus from stop 1 stops at stop 3)
    //Buses from stop 2: 2 (buses from stop 2 stop at stop 3)
    //Buses originating from stop 3: 4 - (1 + 2) = 1
    //For bus stop 4:
    //Total buses: 3
    //Buses from stop 1: 1 (bus from stop 1 stops at stop 4)
    //Buses from stop 2: 2 (buses from stop 2 stop at stop 4)
    //Buses originating from stop 4: 3 - (1 + 2) = 0
    //Output: 1 2 1 0

    //Example 2:
    //Input:
    //1
    //5
    //5 8 6 10 9
    //Explanation:
    //
    //For bus stop 1:
    //Total buses: 5
    //Buses originating from stop 1: 5 (no previous stops)
    //For bus stop 2:
    //Total buses: 8
    //Buses from stop 1: 5 (bus from stop 1 stops at stop 2)
    //Buses originating from stop 2: 8 - 5 = 3
    //For bus stop 3:
    //Total buses: 6
    //Buses from stop 1: 5 (bus from stop 1 stops at stop 3)
    //Buses from stop 2: 0 (no bus from stop 2 stops at stop 3, since 3 is not a multiple of 2)
    //Buses originating from stop 3: 6 - 5 = 1
    //For bus stop 4:
    //Total buses: 10
    //Buses from stop 1: 5 (bus from stop 1 stops at stop 4)
    //Buses from stop 2: 3 (bus from stop 2 stops at stop 4)
    //Buses from stop 3: 0 (no bus from stop 3 stops at stop 4, since 4 is not a multiple of 3)
    //Buses originating from stop 4: 10 - (5 + 3) = 2
    //For bus stop 5:
    //Total buses: 9
    //Buses from stop 1: 5 (bus from stop 1 stops at stop 5)
    //Buses from stop 2: 0 (no bus from stop 2 stops at stop 5, since 5 is not a multiple of 2)
    //Buses from stop 3: 0 (no bus from stop 3 stops at stop 5, since 5 is not a multiple of 3)
    //Buses from stop 4: 0 (no bus from stop 4 stops at stop 5, since 5 is not a multiple of 4)
    //Buses originating from stop 5: 9 - 5 = 4
    //Output: 5 3 1 2 4


    //Example 3:
    //Input:
    //1
    //3
    //1 2 3
    //Explanation:
    //
    //For bus stop 1:
    //Total buses: 1
    //Buses originating from stop 1: 1 (no previous stops)
    //For bus stop 2:
    //Total buses: 2
    //Buses from stop 1: 1 (bus from stop 1 stops at stop 2)
    //Buses originating from stop 2: 2 - 1 = 1
    //For bus stop 3:
    //Total buses: 3
    //Buses from stop 1: 1 (bus from stop 1 stops at stop 3)
    //Buses from stop 2: 1 (bus from stop 2 stops at stop 3)
    //Buses originating from stop 3: 3 - (1 + 1) = 1
    //Output:1 1 1
}
