// Link - https://leetcode.com/problems/valid-anagram/

// Description - 
// Given two strings s and t, return true if t is an 
// anagram
//  of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for(char x : t.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) - 1);
        }

        for(int val : map.values()){
            if(val!=0){
                return false;
            }
        }

        return true;

    }
}
