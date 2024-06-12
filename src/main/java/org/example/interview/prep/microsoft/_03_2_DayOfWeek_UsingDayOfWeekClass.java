package org.example.interview.prep.microsoft;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
public class _03_2_DayOfWeek_UsingDayOfWeekClass {

    // Using Java.time.DayOfWeek class
    /*
    * java8 introduced the java.time package, which provides comprehensive support for date and time. We can use the java.time.DayOfWeek enum to get the day of the week directly.
    *
    * Time Complexity: O(1)
    * Space Complexity: O(1)
    *
    * */
    public static String getDayOfWeek(int day, int month, int year){
        LocalDate date = LocalDate.of(year,month,day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            System.out.println(getDayOfWeek(day, month, year));
        }
        sc.close();
    }

    //Given the following inputs:
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
    //Output for java.time.DayOfWeek Approach:
    //FRIDAY
    //SATURDAY
    //FRIDAY



    //### Approach 2: Using `java.time.DayOfWeek` Class
    //
    //**Time Complexity (TC):**
    //- Creating a `LocalDate` instance and calling `getDayOfWeek` involves a constant amount of work.
    //- Therefore, the time complexity is **O(1)** for each date calculation.
    //
    //**Space Complexity (SC):**
    //- The space required is for the `LocalDate` object and a few other variables.
    //- The space complexity is **O(1)** since the space used is independent of the input size.
    //
    //However, the choice of approach can be influenced by factors such as readability, ease of implementation, and usage of built-in libraries.

}
