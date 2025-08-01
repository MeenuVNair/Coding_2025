package com.meenu.coding.easy;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */


/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class GuessNumberHigherOrLower /*extends GuessGame */{
    public int guessNumber(int n) {
        int l = 1, r = n, mid;

        while(l <= r) {
            mid = l + (r - l) / 2;
            if(guess(mid) == -1) {
                r = mid - 1;
            } else if(guess(mid) == 1) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //dummy method to fix compile error
    int guess(int num) {
        return -100;
    }
}


/**
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

 You call a pre-defined API int guess(int num), which returns three possible results:

 -1: Your guess is higher than the number I picked (i.e. num > pick).
 1: Your guess is lower than the number I picked (i.e. num < pick).
 0: your guess is equal to the number I picked (i.e. num == pick).
 Return the number that I picked.



 Example 1:

 Input: n = 10, pick = 6
 Output: 6
 Example 2:

 Input: n = 1, pick = 1
 Output: 1
 Example 3:

 Input: n = 2, pick = 1
 Output: 1


 Constraints:

 1 <= n <= 231 - 1
 1 <= pick <= n
 */
