/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * Concrete StackOperation class that pushes a Complex in the calculatorStack
 * @author Matteo Di Rienzo
 */
public class PushStackOperation extends StackOperation{
    
    private Complex toPush;
    
    /** 
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     * @param toPush number that has to be pushed
     */
    public PushStackOperation(CalculatorStack calculatorStack, Complex toPush) {
        super(calculatorStack);
        this.toPush = toPush;
    }
    
    /**
     * Pushes toPush on the top of the stack
     */
    @Override
    public void execute(){
    calculatorStack.push(toPush);
    }
    
    /**
     * @return the complex to push
     */
    public Complex getToPush() {
        return toPush;
    }
    
    /**
     * @param toPush sets the complex to push
     */
    public void setToPush(Complex toPush) {
        this.toPush = toPush;
    }

}
