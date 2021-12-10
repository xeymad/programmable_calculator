/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;
import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 * Concrete StackOperation class that implements the sum between the last two Complex objects from the stack
 * @author Matteo Di Rienzo
 */
public class SumStackOperation extends StackOperation{

    /**
     * Class constructor 
     * @param calculatorStack instance of the calculator stack
     */
    public SumStackOperation(CalculatorStack calculatorStack) {
        super(calculatorStack);
    }

    /**
     * Method which contains the logic of the sum between two Complex Objects from the stack
     * <br>
     * If the stack is empty it puts inside a ZERO value
     * <br>
     * If the stack contains just one elements, the stack is unchanged
     */
    @Override
    public void execute(){
        int size = calculatorStack.size();
        if (size == 0){
            calculatorStack.push(Complex.ZERO);
            return;
        }
        else if (size == 1)
            return;
        Complex c1 = calculatorStack.pop();
        Complex c2 = calculatorStack.pop();
        
        calculatorStack.push(c1.add(c2));
    }
    
    
}