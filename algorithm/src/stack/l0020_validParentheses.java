package com.hans.stack;

import java.util.Stack;

/**
 * @author hans
 */
public class l0020_validParentheses {



    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }else{

                if(stack.isEmpty()) return false;

                char p = stack.pop();
                char match;

                if( c == ')'){
                    match = '(';
                }else if( c == ']'){
                    match = '[';
                }else{
                    match='{';
                }

                if( p != match){
                    return false;
                }
            }

        }

        if(!stack.isEmpty())return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
