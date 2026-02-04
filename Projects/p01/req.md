# Infix to Reverse Polish Notation (RPN) Converter and Evaluator
 
This project develops a C++ program that reads infix arithmetic expressions, converts them into Reverse Polish Notation (RPN), and evaluates the resulting expression. The program uses the shunting yard algorithm for infix-to-postfix conversion, utilizing a stack for operators and constructing the output directly as a space-separated string.
 
## Step 1: Implement the Shunting Yard Algorithm (Infix to Postfix Conversion)
 
- Read a valid infix arithmetic expression as a space-separated string. Allowed tokens: single-digit numbers, +, -, *, /, (, and ).
- Convert the infix expression to a postfix (RPN) expression using the shunting yard algorithm:
  - Use a stack only for operators and parentheses (do not use a stack for the output/postfix string).
  - Append numbers (operands) directly to the output string.
  - Handle operators and parentheses per precedence and associativity.
  - After reading all tokens, pop any remaining operators from the stack and append them to the output.
- Return the postfix expression as a space-separated string.
 
**Example:**
```
Input: 3 + 4 * 2 / ( 1 - 5 )
Output: 3 4 2 * 1 5 - / +
```
 
_Note: Manage operator precedence (* and / higher than + and -) and left-to-right associativity. Only use one stack for operators and parentheses._
 
## Step 2: Evaluate the Postfix (RPN) Expression
 
- Read the postfix expression from Step 1.
- Use a stack to evaluate the postfix expression:
  - Push operands onto the stack as they appear.
  - For each operator, pop the appropriate number of operands, apply the operation, and push the result.
- After all tokens, the remaining value on the stack is the result.
 
**Example:**
```
Input: 3 4 2 * 1 5 - / +
Output: 1
```
 
## Step 3: Main Program Flow and Input/Output Requirements
 
- Prompt the user for an infix arithmetic expression (space-separated tokens).
- Display both the postfix expression and its evaluated result.
 
**Example:**
```
Enter infix expression: 5 + ( 6 - 2 ) * 3 / 4
Postfix: 5 6 2 - 3 * 4 / +
Result: 8
```
 
## Step 4: Program Requirements
 
- Use C++ standard library containers (std::stack, std::vector as needed).
- Assume all input expressions are valid; advanced error handling is not required.
- Supported operators: +, -, *, /, and parentheses (, ).
- ~~Only single-digit, non-negative integer operands are allowed.~~ (This was a lie, sorry)
 
_Note: Build the output (postfix string) directly as a string or vector, not as a stack. Operator stack is only for managing operators/parentheses during conversion._
 
## Step 5: Example Runs
 
**Example 1:**
```
Enter infix expression: 7 * ( 8 + 2 )
Postfix: 7 8 2 + *
Result: 70
```
 
**Example 2:**
```
Enter infix expression: 2 + 3 * 4 - 5
Postfix: 2 3 4 * + 5 -
Result: 9
```
 
_Hint: Operator precedence and associativity are critical for correct postfix conversion. Use the operator stack to enforce these rules._