/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import calculatorstack.CalculatorStack;
import stackoperation.StackOperation;
import complexvariablesvector.ComplexVariablesVector;

/**
 *
 * @author aferr
 */
public abstract class StackVariableOperation extends StackOperation {
    
    ComplexVariablesVector variablesVector;
    char variable;
    
    /**
     * Class Constructor
     * @param calculatorStack instance of calculator's stack
     * @param variablesVector instance of variables' vector
     * @param variable the variable used to execute the operation
     */
    public StackVariableOperation(CalculatorStack calculatorStack, 
            ComplexVariablesVector variablesVector, char variable){
        super(calculatorStack);
        this.variablesVector = variablesVector;
        this.variable = variable;
    }
    
}
