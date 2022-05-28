import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Lab07: Reverse Polish Notation
 * @author Vicki Young
 * @version 2022.04.07
 * CS 245-03
 */

public class RPN {
    /**
     * evalRPN() function evaluates the value of an arithmetic expression in RPN.
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     * Division between two integers should truncate toward zero.
     * It is guaranteed that the given RPN expression is always valid.
     * That means the expression would always evaluate to a result,
     * and there will not be any division by zero operation.
     * evalRPN() function loops through token list, and
     * uses a stack list to store the operands and current total result.
     * @param tokens = String list of operators and operands
     * @return int = result of the given arithmetic expression in RPN
     */
    public static int evalRPN(List<String> tokens) {
        //stack list stores operands in order of most recent (head) to oldest (tail)
        List<Integer> stack = new LinkedList<>();
        int result = 0;
        //loop through tokens list
        for (String str : tokens) {
            //if current token is a number:
            if (isNumeric(str)) {
                //add token to the front/head of stack list
                stack.add(0, Integer.parseInt(str));
            //else current token is an operator:
            } else {
                //get and remove the two most recent operands from the stack list
                //one of the operands should also be the current total result
                int operand1 = stack.remove(0);
                int operand2 = stack.remove(0);
                //perform given operation on the two operands to get the result
                switch(str) {
                    case "+":
                        result = operand2 + operand1;
                        break;
                    case "-":
                        result = operand2 - operand1;
                        break;
                    case "/":
                        result = operand2 / operand1;
                        break;
                    case "*":
                        result = operand2 * operand1;
                        break;
                }
                //add the result to the head of the stack list
                stack.add(0, result);
            }
        }
        //return result
        return result;
    }

    /**
     * isNumeric() function checks if the given String is a number; returns true if it is, false if not.
     * @param str = given String
     * @return boolean = true if String is a number, false if it is not.
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** for testing purposes only */
    public static void main(String[] args){
      List<String> tokens = new LinkedList<>(Arrays.asList("10","6","9","3","+","-11","*","/","*","17","+","5","+"));
      System.out.println("Given the array of tokens: " + tokens);
      System.out.println("Expected output: " + 22);
      System.out.println("Actual output: " + evalRPN(tokens));
    }
}
