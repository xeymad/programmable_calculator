/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationexecutor;

import stackoperation.StackOperation;

/**
 * This class has the role of executing the commands given by the client of the application.
 * @author matteo
 */
public class OperationExecutor {
    private StackOperation operation;

    public OperationExecutor(StackOperation operation) {
        this.operation = operation;
    }

    public OperationExecutor() {
        operation = null;
    }
    
    /**
     * Sets a new operation
     * @param operation the new operation to set 
     */
    public void setCommand(StackOperation operation) {
        this.operation = operation;
    }
    
    /**
     * Execute the current operation
     */
    public void execute(){
        if (operation == null)
            throw new UndefinedOperationException("Operation MUST be set before execution!");
        operation.execute();
    }
    
}
