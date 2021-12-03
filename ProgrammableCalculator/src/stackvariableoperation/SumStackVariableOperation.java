/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import calculatorstack.CalculatorStack;
import java.util.NoSuchElementException;
import org.apache.commons.math3.complex.Complex;
import complexvariablesvector.ComplexVariablesVector;

/**
 *
 * @author Arianna Carratù
 */
public class SumStackVariableOperation extends StackVariableOperation {
    
    /**
     * Class Constructor
     * @param calculatorStack instance of calculator's stack
     * @param variablesVector instance of variables' vector
     * @param variable the variable used to execute the operation
     */
    public SumStackVariableOperation(CalculatorStack calculatorStack, 
            ComplexVariablesVector variablesVector, char variable){
        super(calculatorStack, variablesVector, variable);
    }

    /**
     * Sums the value of the given variable with the top element of the stack and pushes
     * the result onto the stack. <br>
     * If the stack is empty, it just pushes the variable onto the stack.
     */
    @Override
    public void execute() {
        int size = calculatorStack.size();
        Complex variableNumber = variablesVector.getVarValue(variable);
        Complex stackNumber = size == 0 ? Complex.ZERO : calculatorStack.pop();
        Complex resultNumber = variableNumber.add(stackNumber);
        calculatorStack.push(resultNumber);
    }
}
