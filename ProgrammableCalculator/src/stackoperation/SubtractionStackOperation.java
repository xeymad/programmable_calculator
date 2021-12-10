/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;
import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * Concrete StackOperation class that implements the subtraction between the last two Complex objects from the stack
 * @author Matteo Di Rienzo
 */
public class SubtractionStackOperation extends StackOperation{
        
    /**
     * Class constructor 
     * @param calculatorStack istance of the calculator stack
     */
    public SubtractionStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }
    
    /**
     * Method which contains the logic of the subtraction between the last two Complexs Object from the stack
     * <br>
     * If the stack is empty it puts inside a ZERO value
     * <br>
     * If the stack contains just one elements, the stack is unchanged
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        if (size == 0){
            calculatorStack.push(Complex.ZERO);
            return;
        }
        else if (size == 1)
            return;
        Complex c1 = calculatorStack.pop();
        Complex c2 = calculatorStack.pop();
        
        calculatorStack.push(c2.subtract(c1));
    }

    

}
