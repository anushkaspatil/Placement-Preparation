// Link - https://leetcode.com/problems/valid-parentheses/description/

// Description - 
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 
// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Example 4:
// Input: s = "([])"
// Output: true

// Constraints:
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int top = 'a';

        while(i<s.length()){
            char ch = s.charAt(i);

            if(!st.empty()){
                top = st.peek();
            }

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
                i++;
            }
            else if(ch == ')' && top == '(' && !st.empty()){
                st.pop();
                i++;
            }
            else if(ch == ']' && top == '[' && !st.empty()){
                st.pop();
                i++;
            }
            else if(ch == '}' && top == '{' && !st.empty()){
                st.pop();
                i++;
            }
            else{
                return false;
            }
        }
        return st.empty();
    }
}
