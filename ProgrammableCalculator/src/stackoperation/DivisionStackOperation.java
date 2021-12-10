/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
/**
 * This class implements the division operation between the last two elements of the stack.
 * @author Utente
 */
public class DivisionStackOperation extends StackOperation{
        
    /**
     * Class constructor 
     * @param calculatorStack instance of the calculator stack
     */
    public DivisionStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }
    
    /**
     * Method which contains the logic of the division between the last two Complex Object from the stack<br>
     * If the stack is empty it puts inside a ZERO value<br>
     * If the stack contains just one elements, the stack is unchanged<br>
     * It throws a ArithmeticException when trying to divide by zero<br>
     */
    @Override
    public void execute() throws ArithmeticException{
        int size = calculatorStack.size();
        if (size == 0){
            calculatorStack.push(Complex.ZERO);
            return;
        }
        else if (size == 1)
            return;
        Complex c1 = calculatorStack.pop();
        Complex c2 = calculatorStack.pop();
        if (c1.equals(Complex.ZERO))
            throw new ArithmeticException("Could not divide by 0"); 
        else
            calculatorStack.push(c2.divide(c1));
    }

    

}