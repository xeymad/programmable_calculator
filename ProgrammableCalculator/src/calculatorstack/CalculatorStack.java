/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorstack;

import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements a stack of complex number called Calculator Stack.
 * 
 * @author Arianna Carratù 
 * @version 1.0
 */
public class CalculatorStack implements Iterable<Complex> {
   
    private LinkedList<Complex> calculatorStack;  
    
    /**
    * Class constructor
    */
    public CalculatorStack() {
        calculatorStack= new LinkedList<Complex>();
    }
    
    /**
    * This method takes a Complex object and pushes it on the top of the stack.
    * @param c The complex number to put on the stack 
    */ 
    public void push(Complex c){
        calculatorStack.push(c);
    }
    
    /**
    * This method removes the top element of the stack and returns it.
    * @return Complex This returns the last inserted complex number
    */ 
    public Complex pop(){
        return calculatorStack.pop();
    }
    
    /**
    * This method returns the top element of the stack without removing it.
    * @return Complex This returns the last inserted complex number
    */ 
    public Complex top(){
        return calculatorStack.getFirst();
    }
    
    /**
    * This method returns True if this stack contains no elements.
    * @return True if this stack contains no elements
    */ 
    public boolean isEmpty(){
        return calculatorStack.isEmpty();
    }
    
    /**
    * This method returns the number of elements that the stack contains.
    * @return int the number of elements of the stack
    */
    public int size(){
        return calculatorStack.size();
    }

    /**
    * This method returns an iterator over the elements of the stack, starting from the top.
    * @return Iterator an iterator over the elements of the stack
    */
    @Override
    public Iterator<Complex> iterator() {
        return calculatorStack.iterator();
    }
    
    
    
}
