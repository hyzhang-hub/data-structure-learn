package stack;

import java.util.Stack;

public class lt_1190 {
    /**
     * 1190. 反转每对括号间的子串
     * 给出一个字符串 s（仅含有小写英文字母和括号）。
     * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     * 注意，您的结果中 不应 包含任何括号。
     * 示例 1：
     * 输入：s = "(abcd)"
     * 输出："dcba"
     *
     * 示例 2：
     * 输入：s = "(u(love)i)"
     * 输出："iloveu"
     *
     * 示例 3：
     * 输入：s = "(ed(et(oc))el)"
     * 输出："leetcode"
     *
     * 示例 4：
     * 输入：s = "a(bcdefghijkl(mno)p)q"
     * 输出："apmnolkjihgfedcbq"
     */
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if (ch == ')'){
                sb.reverse();
                System.out.println(stack.isEmpty());
                System.out.println(stack.peek());
                sb.insert(0, stack.pop());
                System.out.println(sb.toString());
            }else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        String s1 = new lt_1190().reverseParentheses(s);
        System.out.println(s1);
    }
}
