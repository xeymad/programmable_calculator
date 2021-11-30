/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;

/**
 * This class implements the drop of the top element of the stack.
 * @author aferr
 */
public class DropStackOperation extends StackOperation {
    
    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public DropStackOperation(CalculatorStack calculatorStack){
        super(calculatorStack);
    }

    /**
     * Remove the stack's top element.
     * If the stack is empty, nothing happens.
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        if(size > 0){
            calculatorStack.pop();
        }
    }
    
}
