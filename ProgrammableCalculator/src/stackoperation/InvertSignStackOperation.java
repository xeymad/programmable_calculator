/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author giuse
 */
public class InvertSignStackOperation extends StackOperation {

    public InvertSignStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }

    @Override
    public void execute() {
        Complex c = calculatorStack.pop();
        calculatorStack.push(c.negate());
    }
    
}
