package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 16/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : 
 Space Complexity : 
 */

public class TwoLetterCardGame {
    public int score(String[] cards, char x) {
        int totalPairs = 0;

        //for set1 - (first char == x)
        int maxFreqSet1 = 0, totalCountSet1 = 0;
        int[] freqSet1 = new int[26];

        //for set2 - (second char == x)
        int maxFreqSet2 = 0, totalCountSet2 = 0;
        int[] freqSet2 = new int[26];

        //wild cards set 3(both chars == target)
        int bothTargetCount = 0;

        for(String card : cards) {
            char first = card.charAt(0);
            char second = card.charAt(1);

            if(first == x && second == x) {
                bothTargetCount++;
            }
            else if(first == x) {
                freqSet1[second - 'a']++;
                maxFreqSet1 = Math.max(maxFreqSet1, freqSet1[second - 'a']);
                totalCountSet1++;
            }
            else if(second == x) {
                freqSet2[first - 'a']++;
                maxFreqSet2 = Math.max(maxFreqSet2, freqSet2[first - 'a']);
                totalCountSet2++;
            }

            //skip if there's no x in card
        }


        //handle set1 using peigonhole principle
        if(maxFreqSet1 > totalCountSet1 - maxFreqSet1) {
            totalPairs += (totalCountSet1 - maxFreqSet1);
            totalCountSet1 = maxFreqSet1 - (totalCountSet1 - maxFreqSet1);
        }  else {
            totalPairs += totalCountSet1 / 2;
            totalCountSet1 %= 2;
        }

        //handle set2 using peigon hole principle
        if(maxFreqSet2 > totalCountSet2 - maxFreqSet2) {
            totalPairs += (totalCountSet2 - maxFreqSet2);
            totalCountSet2 = (maxFreqSet2 - (totalCountSet2 - maxFreqSet2));
        } else {
            totalPairs += (totalCountSet2 / 2);
            totalCountSet2 = (totalCountSet2 % 2);
        }

        //pair leftOver (remainders) from set1 and set2 with xx (double)
        int extraPairsCount = 0;
        int use = Math.min(totalCountSet1, bothTargetCount);
        extraPairsCount += use;
        bothTargetCount -= use;

        use = Math.min(totalCountSet2, bothTargetCount);
        extraPairsCount += use;
        bothTargetCount -= use;

        //try to use remaining "xx" to split existing pairs
        totalPairs = Math.min(totalPairs * 2, totalPairs + bothTargetCount / 2);

        //Add pairs we made from the leftovers
        totalPairs += extraPairsCount;

        return totalPairs;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a deck of cards represented by a string array cards, and each card displays two lowercase letters.

 You are also given a letter x. You play a game with the following rules:

 Start with 0 points.
 On each turn, you must find two compatible cards from the deck that both contain the letter x in any position.
 Remove the pair of cards and earn 1 point.
 The game ends when you can no longer find a pair of compatible cards.
 Return the maximum number of points you can gain with optimal play.

 Two cards are compatible if the strings differ in exactly 1 position.



 Example 1:

 Input: cards = ["aa","ab","ba","ac"], x = "a"

 Output: 2

 Explanation:

 On the first turn, select and remove cards "ab" and "ac", which are compatible because they differ at only index 1.
 On the second turn, select and remove cards "aa" and "ba", which are compatible because they differ at only index 0.
 Because there are no more compatible pairs, the total score is 2.

 Example 2:

 Input: cards = ["aa","ab","ba"], x = "a"

 Output: 1

 Explanation:

 On the first turn, select and remove cards "aa" and "ba".
 Because there are no more compatible pairs, the total score is 1.

 Example 3:

 Input: cards = ["aa","ab","ba","ac"], x = "b"

 Output: 0

 Explanation:

 The only cards that contain the character 'b' are "ab" and "ba". However, they differ in both indices, so they are not compatible. Thus, the output is 0.



 Constraints:

 2 <= cards.length <= 105
 cards[i].length == 2
 Each cards[i] is composed of only lowercase English letters between 'a' and 'j'.
 x is a lowercase English letter between 'a' and 'j'.

 Hint 1
 Compute both, cnt1[c], cnt2[c] as the counts of cards with x in both positions, only the first position (other letter c), and only the second position.
 Hint 2
 Let solve(cnt, have) be the maximum pairs you can form from one‐sided counts cnt plus have two‐sided cards by sorting cnt, computing the total, and applying the same logic as in the solution.
 Hint 3
 Return the maximum over i = 0..both of solve(cnt1, i) + solve(cnt2, both - i).
 */
