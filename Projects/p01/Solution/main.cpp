#include <iostream>
#include <sstream>
#include <stack>
#include <vector>
#include <string>
#include <cctype>

// Returns precedence of the given operator
int precedence(const std::string &op) {
    if (op == "*" || op == "/" || op == "%") return 2;
    if (op == "+" || op == "-") return 1;
    return 0;
}

// Checks if the token is an operator
bool isOperator(const std::string &token) {
    return token == "+" || token == "-" || token == "*" || token == "/" || token == "%";
}

// Converts infix expression (space-separated) to postfix (RPN) expression (space-separated)
std::string infixToPostfix(const std::string &infix) {
    std::stack<std::string> opStack;
    std::string output;
    std::vector<std::string> tokens;

    // Tokenize: handle both spaced and non-spaced input
    std::string num;
    for (size_t i = 0; i < infix.size(); ++i) {
        char c = infix[i];
        if (isspace(c)) {
            if (!num.empty()) {
                tokens.push_back(num);
                num.clear();
            }
        } else if (isdigit(c)) {
            num += c;
        } else if (c == '-' && (tokens.empty() || tokens.back() == "(" || isOperator(tokens.back())) && num.empty()) {
            num += c;
        } else {
            if (!num.empty()) {
                tokens.push_back(num);
                num.clear();
            }
            tokens.push_back(std::string(1, c));
        }
    }
    if (!num.empty()) tokens.push_back(num);

    for (const std::string &token : tokens) {
        if (isdigit(token[0])) {
            if (!output.empty()) output += " ";
            output += token;
        } else if (token == "(") {
            opStack.push(token);
        } else if (token == ")") {
            while (!opStack.empty() && opStack.top() != "(") {
                if (!output.empty()) output += " ";
                output += opStack.top();
                opStack.pop();
            }
            if (!opStack.empty()) opStack.pop();
        } else if (isOperator(token)) {
            while (!opStack.empty() && opStack.top() != "(" &&
                   precedence(opStack.top()) >= precedence(token)) {
                if (!output.empty()) output += " ";
                output += opStack.top();
                opStack.pop();
            }
            opStack.push(token);
        }
    }

    while (!opStack.empty()) {
        if (!output.empty()) output += " ";
        output += opStack.top();
        opStack.pop();
    }

    return output;
}

// Evaluates a postfix (RPN) expression (space-separated)
int evaluatePostfix(const std::string &postfix) {
    std::stack<int> valStack;
    std::istringstream iss(postfix);
    std::string token;

    while (iss >> token) {
        if (isOperator(token)) {
            int b = valStack.top(); valStack.pop();
            int a = valStack.top(); valStack.pop();
            int result = 0;
            if (token == "+") result = a + b;
            else if (token == "-") result = a - b;
            else if (token == "*") result = a * b;
            else if (token == "/") result = a / b;
            valStack.push(result);
        } else {
            valStack.push(std::stoi(token));
        }
    }

    return valStack.top();
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
