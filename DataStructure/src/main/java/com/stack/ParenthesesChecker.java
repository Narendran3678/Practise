package com.stack;

import java.util.Stack;

public class ParenthesesChecker<T>{
    public boolean checkWithPredefined(String parentheses) {
        ParenthesesChecker<String> parenthesesChecker = new ParenthesesChecker<>();
        Stack<String> parenthesesStack = parenthesesChecker.convertToStack(parentheses);
        Stack<String> validatorStack = new Stack<>();
        while(!parenthesesStack.empty()) {
            String data = parenthesesStack.peek();
            if (data.equals("}") || data.equals("]") || data.equals(")")) {
                validatorStack.push(parenthesesStack.pop());
            }
            else {
                if(data.equals("{") && validatorStack.peek().equals("}")) {
                    validatorStack.pop();
                    parenthesesStack.pop();
                }
                else if(data.equals("[") && validatorStack.peek().equals("]")) {
                    validatorStack.pop();
                    parenthesesStack.pop();
                }
                else if(data.equals("(") && validatorStack.peek().equals(")")) {
                    validatorStack.pop();
                    parenthesesStack.pop();
                }
                else {
                    break;
                }
            }
        }
        return validatorStack.isEmpty();
    }
    private Stack<String> convertToStack(String syntax) {
        Stack<String> parentheses = new Stack<>();
        String[] strArr =  syntax.split("");
        for(String arr:strArr) {
            parentheses.push(arr);
        }
        return parentheses;
    }
    public static void main(String[] args) {
        ParenthesesChecker<String> parenthesesChecker = new ParenthesesChecker<>();
        String syntax = "{}{([])}";
        //syntax = "{}{({])}";
        parenthesesChecker.checkWithPredefined(syntax);
        if(parenthesesChecker.checkWithPredefined(syntax)) {
            System.out.println("Parentheses ["+syntax+"] enclosed Properly");
        }
        else {
            System.out.println("Invalid Parentheses ["+syntax+"] Formation");
        }
    }
}
