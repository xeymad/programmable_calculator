/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements the square root operation on the top element of the stack.
 * @author aferr
 */
public class SqrtStackOperation extends StackOperation {

    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public SqrtStackOperation(CalculatorStack calculatorStack){
        super(calculatorStack);
        
    }
    
    /**
     * Execute the square root on the top element of the stack.
     * If the stack is empty, the number 0 will be pushed onto the stack.
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        if(size == 0){
            calculatorStack.push(Complex.ZERO);
        }
        else{
            Complex input = calculatorStack.pop();
            Complex output = input.sqrt();
            calculatorStack.push(output);
        }
    }
    
    
}
