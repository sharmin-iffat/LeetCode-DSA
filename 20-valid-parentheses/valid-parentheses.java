// class Solution {
//     public boolean isValid(String s) {
//         char t = s.charAt(0);
//         if (t == ')' || t == ']' || t == '}') return false;
//         Stack<Character> stack = new Stack<>();

//         int i=0;
//         while(i<s.length()){
//             char top = s.charAt(i);

//             if(top == '(' || top == '[' || top == '{'){
//                 stack.push(top);
//             } 

//             else if(top == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
//             else return false;

//             else if(top == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
//             else return false;

//             else if(top == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
//             else return false;
//             i++;
//         }
//         if(stack.isEmpty()) return true;
//         return false;
//     }
// }

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char t = s.charAt(0);
        if (t == ')' || t == ']' || t == '}') return false;

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char top = s.charAt(i);

            if (top == '(' || top == '[' || top == '{') {
                stack.push(top);
            } 
            else if (top == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (top == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }
            else if (top == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }

            i++;
        }
        return stack.isEmpty();
    }
}

