// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenBracket(c)) {
                stack.push(c);
            }
            else {
                if (!stack.isEmpty() && stack.peek().equals(getCorrespondingBracket(c))) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
    
    private boolean isOpenBracket(char c) {
        switch(c) {
            case '(':
            case '{':
            case '[': return true;
            default: return false;
        }
    }
    
    private char getCorrespondingBracket(char c) {
        switch(c) {
            case ')': return '(';
            case '}': return '{';
            default: return '[';
        }
    }
}