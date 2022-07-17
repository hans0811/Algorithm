package com.hans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hans
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st;

    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        pushListToStack(nestedList);

    }

    private void pushListToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> temp = new Stack<>();

        for(NestedInteger nested: nestedList){
            temp.push(nested);
        }

        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }


    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        return st.pop().getInteger();
    }


    @Override
    public boolean hasNext() {
        while( !st.isEmpty() && !st.peek().isInteger()){
            pushListToStack(st.pop().getList());
        }
        return !st.isEmpty();
    }


}
