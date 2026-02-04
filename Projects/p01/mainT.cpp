#include <iostream>
#include <sstream>
#include <stack>
#include <vector>
#include <string>
#include <cctype>

// Returns precedence of the given operator
int precedence(const std::string &op) {
    // TODO: Implement operator precedence logic (e.g., return 2 for '*' and '/', 1 for '+' and '-')
    return 0;
}

// Checks if the token is an operator
bool isOperator(const std::string &token) {
    // TODO: Implement logic to check if token is one of '+', '-', '*', '/', '%'
    return false;
}

// Converts infix expression (space-separated) to postfix (RPN) expression (space-separated)
std::string infixToPostfix(const std::string &infix) {
    // TODO: Implement the shunting yard algorithm for infix to postfix conversion
    return "";
}

// Evaluates a postfix (RPN) expression (space-separated)
int evaluatePostfix(const std::string &postfix) {
    // TODO: Implement evaluation of postfix expression using a stack
    return 0;
}

int main() {
    std::string infix;
    std::cout << "Enter infix expression: ";
    std::getline(std::cin, infix);
    std::string postfix = infixToPostfix(infix);
    int result = evaluatePostfix(postfix);
    std::cout << "Postfix: " << postfix << std::endl;
    std::cout << "Result: " << result << std::endl;
    return 0;
}
