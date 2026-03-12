#include <iostream>
#include <sstream>
#include <stack>
#include <vector>
#include <string>
#include <cctype>

// Returns precedence of the given operator
int precedence(const std::string &op) {
    // TODO: Implement operator precedence logic (e.g., return 2 for '*' and '/', 1 for '+' and '-')
    if(op=="*"||op=="/") return 2;
    if(op=="+"||op=="-") return 1;
    return 0;
}

// Checks if the token is an operator
bool isOperator(const std::string &token) {
    // TODO: Implement logic to check if token is one of '+', '-', '*', '/', '%'
    return  token=="+"||token=="-"||token=="*"||token=="/";
}

// Converts infix expression (space-separated) to postfix (RPN) expression (space-separated)
std::string infixToPostfix(const std::string &infix) {
    // TODO: Implement the shunting yard algorithm for infix to postfix conversion
    std::string output;
    std::stack<std::string> operators;
    std::stringstream iss(infix);
    std::string token;

    
    while(iss>>token){
        if(isOperator(token)){
            if(operators.empty() || operators.top()=="(")
                operators.push(token);
            else{ 
                while (!operators.empty() && operators.top() != "(" && 
                    precedence(operators.top()) >= precedence(token)) {
                    output += operators.top() + " ";
                    operators.pop();
                }
                operators.push(token);
            }
        }
        else if(token=="(") operators.push(token);
        else if(token==")") {
            while(operators.top()!="(") {
            output += operators.top() + " ";
            operators.pop();
            }
            operators.pop(); // Remove the "("
        }
        else output += token + " ";
    }
    while(!operators.empty()){
        output += operators.top() + " ";
        operators.pop();
    }
    if (!output.empty()) output.pop_back();
    return output;
}

// Evaluates a postfix (RPN) expression (space-separated)
int evaluatePostfix(const std::string &postfix) {
    // TODO: Implement evaluation of postfix expression using a stack
    std::stack<int> valStack;
    std::istringstream iss(postfix);
    std::string token;
    while(iss>>token){
        if(isOperator(token)){
            int b = valStack.top(); valStack.pop();
            int a = valStack.top(); valStack.pop();
            int result = 0;
            if (token == "+") result = a + b;
            else if (token == "-") result = a - b;
            else if (token == "*") result = a * b;
            else if (token == "/") result = a / b;
            else if(token=="%") result=a%b;
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
