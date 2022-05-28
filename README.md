#lab 07: Reverse Polish Notation (RPN)

Vicki Young

due date: 2022.04.07

CS 245-03

DESCRIPTION:

RPN program evaluates the value of an arithmetic expression in reverse polish notation and returns the result. Valid operators are +, -, *, and /. Operands in the expression are assumed to be only integers. Division between two integers should truncate toward zero. It is also assumed that the the given RPN expression is always guaranteed to be valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation. 

RPN program works by looping through the given tokens list to check whether or not the current token is an operator or operand. The code also uses a stack list to store the operands and current total result after performing an operation.

RUNTIME & SPACE COMPLEXITY:
* entire program
  * TIME: O(n) 
    * n = size of tokens list
  * SPACE: O(n)
    * n = size of tokens list
* evalRPN(List<String> tokens)
  * TIME: O(n) 
    * O(n) = O(n) * O(1), calls isNumeric on each loop
    * n = size of tokens list, since loops through tokens list
  * SPACE: O(n)
    * creates a stack list off the token list
* isNumeric(String str)
  * TIME: O(1)
  * SPACE: O(1)