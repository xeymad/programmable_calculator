/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.NoSuchElementException;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author Giuseppe
 */
public class InvertSignStackOperation extends StackOperation {
    /**
     * Class constructor
     * @param calculatorStack instance of calculator's stack.
     */
    public InvertSignStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }
    
    /**
     * Pops the last element of the stack and insert's its negate.
     * WARNING: it can fail and return an NoSuchElementException if the calculatorStack is empty.
     */
    @Override
    public void execute() {
        try{
            Complex c = calculatorStack.pop();
            calculatorStack.push(c.negate());
        }catch(NoSuchElementException e){
        }
    }
    
}
