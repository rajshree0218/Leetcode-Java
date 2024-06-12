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
public class _01_3_BusesOptimized {
    // Optimized approach using Array of Multiples
    /*
    * Idea:
    * 1. use an array to track the buses that stop at each position due to multiples.
    * 2. for each bus stop, distribute the buses to all multiples of that stop and subtract appropriately.
    *
    * Steps:
    * 1. Initialize an array to track the buses stopping at each position.
    * 2. For each bus stop, subtract the tracked buses to get the originating buses.
    * 3. Distribute the originating buses to all multiples of the current stop.
    *
    * Complexity :
    * Time Complexity : O(N log N) for each test case due to the nested loop over multiples.
    * Space Complexity : O(N)
    *
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
            int[] stops = new int[N];

            for(int i=0; i<N; i++){
                result[i] = buses[i] - stops[i];

                for(int j=2 * (i+1); j<=N; j++){
                    stops[j-1] += result[i];
                }
            }

            for(int i=0; i<N; i++){
                System.out.print(result[i] + (i<N-1 ? " " : "\n"));
            }
        }
        sc.close();
    }
}
