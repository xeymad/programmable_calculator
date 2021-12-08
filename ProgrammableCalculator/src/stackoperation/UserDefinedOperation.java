/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.ArrayList;

/**
 * This class implements the creation and the execution of user defined operations.
 * @author Arianna Carratù
 */
public class UserDefinedOperation extends StackOperation {
    private String operationName;
    private ArrayList<StackOperation> operationsSequence;

    /** 
     * Class constructor
     * @param opName name of the user defined operation.
     * @param opSequence sequence of operations which define the user operation(including the push of numbers).
     * @param calculatorStack instance of calculator's stack.
     */
    public UserDefinedOperation(String opName,  ArrayList<StackOperation> opSequence, CalculatorStack calculatorStack) {
        super(calculatorStack);
        operationName = opName;
        operationsSequence=opSequence;
        
    }
    
    /**
    * This method returns the name of the user defined operation.
    * @return String This returns the string containing the operation's name
    */ 
    public String getOperationName() {
        return operationName;
    }

    /**
     * This method takes a string containing the operation's name.It sets the operation's name with the specific string passed.
     * @param operationName The string containing the operation's name
     */ 
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
    * This method returns the sequence of operations of the user defined operation.
    * @return ArrayList<StackOperation> This returns the list containing the operations' sequence.
    */ 
    public ArrayList<StackOperation> getOperationsSequence() {
        return operationsSequence;
    }
    
    /**
     * This method takes a list containing the operations'sequence.It sets the operations'sequence with the specific list passed.
     * @param operationsSequence The list containing the operations' sequence.
     */ 
    public void setOperationsSequence(ArrayList<StackOperation> operationsSequence) {
        this.operationsSequence = operationsSequence;
    }
    
    /**
     * This method implements the execution of the operations's sequence that defines the user operation.
     */ 
    @Override
    public void execute() {
        for(StackOperation op: operationsSequence){
            op.execute();
        }
    }
    
}
