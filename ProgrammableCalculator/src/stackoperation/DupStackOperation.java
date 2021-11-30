/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements the dup of the top element of the stack.
 * @author Arianna Carratù
 */
public class DupStackOperation extends StackOperation {
    
    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public DupStackOperation(CalculatorStack calculatorStack){
        super(calculatorStack);
    }

    /**
     * Duplicate the stack's top element.
     * If the stack is empty, nothing happens.
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        if(size > 0){
            Complex c =calculatorStack.top();
            calculatorStack.push(c);
        }
    }
    
}
