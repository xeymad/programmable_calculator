/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements the duplication of the second last element of the stack.
 * @author Arianna Carratù
 */
public class OverStackOperation extends StackOperation {
    
    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public OverStackOperation(CalculatorStack calculatorStack){
        super(calculatorStack);
    }

    /**
     * Duplicate the stack's second last element.
     * If the stack is empty or it contains only one element, nothing happens.
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        if(size > 1){
            Complex top = calculatorStack.pop();
            Complex preTop = calculatorStack.top();
            calculatorStack.push(top);
            calculatorStack.push(preTop);
        }
    }
    
}
