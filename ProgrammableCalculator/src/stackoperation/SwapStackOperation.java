/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements the swap of the last element of the stack.
 * @author Matteo Di Rienzo
 */
public class SwapStackOperation extends StackOperation{

    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public SwapStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }

    /**
     * Spaws the stack's top two element.
     * If the stack is empty or it contains only one element, nothing happens.
     */
    @Override
    public void execute(){
        if(calculatorStack.size() > 1){
            Complex c1 =calculatorStack.pop();
            Complex c2 =calculatorStack.pop();
            calculatorStack.push(c1);
            calculatorStack.push(c2);
        }
    }
    
}
