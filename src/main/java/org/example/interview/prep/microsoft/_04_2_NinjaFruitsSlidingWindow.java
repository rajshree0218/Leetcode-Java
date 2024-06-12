package org.example.interview.prep.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//There are ‘n’ fruit trees that are planted along a road. The trees are numbered from 0 to n-1. The type of fruit each tree bears is represented by an uppercase character of the English alphabet. A Ninja is walking along that road. He has two baskets and wants to put the maximum number of fruits in them. The restriction is that each basket can have only one type of fruit.
//Ninja can start with any tree and end at any tree, but once he has started he cannot skip a tree i.e if he picks fruit from the tree ‘i’, then he has to pick fruit from tree ‘i+1’ before going to the tree ‘i+2’. He will pick one fruit from each tree until he cannot, i.e, he will stop when he has to pick a fruit of the third type because both the baskets can be filled by only two different fruits.
//You are given a string ‘str’ consisting of the ‘n’ uppercase character of the English alphabet. The ‘i’th character in this string represents the type of fruit tree ‘i’ bears. Return the maximum number of fruits ninja can put in both the baskets after satisfying all the given conditions.
//Input format:
//The first line of input contains an integer ‘T’ denoting the number of test cases. The next ‘2*T’ lines represent the ‘T’ test cases. The first line of each test case contains an integer ‘n’ representing the number of trees. The second line of the test case contains a string consisting of the ‘n’ uppercase character of the English alphabet that represents the type of fruit in each tree.
//Output format :
//For each test case, output in a separate line, the maximum number of fruits Ninja can put in both the baskets after satisfying all the given conditions.
//Note:
//You do not need to print anything, it has already been taken care of. Just implement the given function.
//Constraints:
//1 <= T <= 50 1 <= n <= 10^4 Where ‘T’ is the total number of test cases, ‘N’ represents the number of trees. Time limit: 1 sec
public class _04_2_NinjaFruitsSlidingWindow {

    // Approach : Sliding Window Technique (two pointer)
    /*
    * This is efficient and optimal for this problem.
    * Time Complexity: O(n) for each test case, where n is the number of trees.
    * Space Complexity: O(1) for fixed size hash map storing at most 2 fruit types.
    *
    * */

    public static int maxFruits(String fruits){
        int n = fruits.length();
        Map<Character, Integer> fruitCount = new HashMap<>();
        int maxFruit = 0;
        int left = 0;

        for(int right =0; right<n; right++){
            char fruit = fruits.charAt(right);
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0)+1);

            while (fruitCount.size() > 2) {

                char leftFruit = fruits.charAt(left);
                fruitCount.put(leftFruit, fruitCount.get(leftFruit)-1);
                if(fruitCount.get(leftFruit) == 0){
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            maxFruit = Math.max(maxFruit, right-left+1);
        }

        return maxFruit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            String fruits = sc.next();
            System.out.println(maxFruits(fruits));
        }
        sc.close();
    }
}
