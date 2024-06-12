package org.example.interview.prep.microsoft;

import java.util.Scanner;

//Q3. Day of the Week
//Write a function that calculates the corresponding day of the week for any particular date in the past or future.
//For example, for the date 28th August 2020 happens to be Friday. Hence the expected output will be Friday.
//Input format :
//The first line contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow: The first line of each test case or query contains the three space-separated integers denoting the 'Day', 'Month', and the 'Year' respectively.
//Note :
//It's guaranteed that the input date will always be a valid one.
//Output format :
//For each test case/query, print a single line containing a single string denoting the corresponding day of the week for the particular input date. The answer will be one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}. The output for every test case will be printed in a separate line.
//Note :
//You do not need to print anything, it has already been taken care of. Just implement the given function.
//Constraints :
//1 <= T <= 10 ^ 5 1 <= Day <= 31 1 <= Month <= 12 1 <= Year <= 2,000,000 Time Limit : 1 sec.
public class _03_1_DayOfWeek_ZellersCongruenceAlgo {

    // Zeller's Congruence Algorithm
    /*
    * Zeller's Congruence is an algorithm devised by Christian Zeller to calculate the day of the week for any date.
    * The Algorithm takes into account the day, month, and year of the date.
    *
    * Time Complexity: O(1)
    * Space Complexity: O(1)
    *
    * */
    public static String getDayOfWeek(int day, int month, int year){
        //Zeller's Congruence algo
        String[] daysOfWeek = {"Sunday",  "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if(month < 3){
            month += 12;
            year -= 1;
        }
        int h = (day + ((13 * (month+1))/5) + year + (year/4) - (year/100) +(year/400)) % 7;
        return daysOfWeek[h];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T; t++){
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            System.out.println(getDayOfWeek(day, month, year));
        }
        sc.close();
    }

    // Given the following inputs:
    //
    //Number of test cases: 3
    //Test cases:
    //Day: 28, Month: 8, Year: 2020 (Expected output: Friday)
    //Day: 1, Month: 1, Year: 2000 (Expected output: Saturday)
    //Day: 15, Month: 3, Year: 2024 (Expected output: Friday)

    //Example Inputs and Outputs
    //Input:
    //3
    //28 8 2020
    //1 1 2000
    //15 3 2024
    //Output for Zeller's Congruence Approach:
    //Friday
    //Saturday
    //Friday


    //### Approach 1: Zeller's Congruence Algorithm
    //**Time Complexity (TC):**
    //- The Zeller's Congruence algorithm performs a constant number of arithmetic operations.
    //- Each operation (addition, subtraction, multiplication, division, and modulo) takes constant time.
    //- Therefore, the time complexity is **O(1)** for each date calculation.
    //
    //**Space Complexity (SC):**
    //- The space required is primarily for the array of days of the week and a few integer variables.
    //- The space complexity is **O(1)** since the amount of space used does not depend on the input size.
    //
}
