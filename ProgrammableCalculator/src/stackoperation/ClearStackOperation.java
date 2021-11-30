/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;

/**
 * This class implements clear all the elements of the stack.
 * @author MatteoDiRienzo
 */
public class ClearStackOperation extends StackOperation{

    public ClearStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }

     /**
     * Pops all the elements from the stack.
     */
    @Override
    public void execute() {
        while(!calculatorStack.isEmpty())
            calculatorStack.pop();
    }
    
}
