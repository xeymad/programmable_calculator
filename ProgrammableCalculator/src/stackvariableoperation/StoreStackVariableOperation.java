/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import complexvariablesvector.ComplexVariablesVector;

/**
 *
 * @author aferr
 */
public class StoreStackVariableOperation extends StackVariableOperation{
    
    /**
     * Class Constructor
     * @param calculatorStack instance of calculator's stack
     * @param variablesVector instance of variables' vector
     * @param variable the variable used to execute the operation
     */
    public StoreStackVariableOperation(CalculatorStack calculatorStack, 
            ComplexVariablesVector variablesVector, char variable){
        super(calculatorStack, variablesVector, variable);
    }
    
    /**
     * Set the previously given variable to stack's top element.
     * If the stack is empty, the variable remains unchanged.
     */
    @Override
    public void execute(){
        int size=calculatorStack.size();
        if(size>0){
            Complex topStack = calculatorStack.top();
            variablesVector.setVarValue(variable, topStack);
            }
    }
    
}
