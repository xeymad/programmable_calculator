/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import calculatorstack.CalculatorStack;
import complexvariablesvector.ComplexVariablesVector;

/**
 * This class implements the push operation of the value of a variable on the stack.
 * @author aferr
 */
public class PushStackVariableOperation extends StackVariableOperation{
    
    /**
     * Class Constructor
     * @param calculatorStack instance of calculator's stack
     * @param variablesVector instance of variable's vector
     * @param variable the variable used to execute the operation
     */
    public PushStackVariableOperation(CalculatorStack calculatorStack, 
            ComplexVariablesVector variablesVector, char variable){
        super(calculatorStack, variablesVector, variable);
    }
    
    /**
     * Pushes the variable's value at the top of the stack.
     */
    @Override
    public void execute(){
        calculatorStack.push(variablesVector.getVarValue(variable));    
    }
    
}