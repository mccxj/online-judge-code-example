package evaluateReversePolishNotation;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a + b);
            } else if ("-".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a - b);
            } else if ("*".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a * b);
            } else if ("/".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a / b);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    @Test
    public void test() {
        assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
