/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.ArrayList;
import java.util.*;

/**
 * This class implements the creation and the execution of user defined operations.
 * An user defined operation is a sequence of StackOperations. It can also execute others UserDefinedOperations.
 * If a UserDefinedOperations depends from another UserDefinedOperations, it is child of the last one.
 * If a UserDefinedOperations is a child (depends from others), we also know its parents.
 * A UserDefinedOperation can be valid or not. We consider a UserDefinedOperation as invalid when it has no operations.
 * @author Arianna Carratù, Giuseppe
 */
public class UserDefinedOperation extends StackOperation {
    private String operationName;
    private String operationsTextual;
    private ArrayList<StackOperation> operationsSequence;
    private List<UserDefinedOperation> parents;
    private Map<String,UserDefinedOperation> children;
    
    /** 
     * Class constructor
     * @param opName name of the user defined operation.
     * @param opSequence sequence of operations which define the user operation(including the push of numbers).
     * @param calculatorStack instance of calculator's stack.
     */
    public UserDefinedOperation(String opName, ArrayList<StackOperation> opSequence, CalculatorStack calculatorStack) {
        super(calculatorStack);
        operationName = opName;
        operationsSequence = new ArrayList<>();
        parents = new ArrayList<>(10);
        children = new HashMap<>();
        for(StackOperation op : opSequence)
            this.addOperation(op);
    }
    
    /**
     * Private method for add a new StackOperation
     * @param stackOperation the StackOperation to add
     */
    private void addOperation(StackOperation stackOperation){
        operationsSequence.add(stackOperation);
        if(stackOperation instanceof UserDefinedOperation){
            UserDefinedOperation us = (UserDefinedOperation) stackOperation;
            parents.add(us);
            us.addChild(this);
        }
    }
    
    /**
     * This method returns the name of the user defined operation.
     * @return String the string containing the operation's name
     */ 
    public String getOperationName() {
        return operationName;
    }
    
    /**
     * This method returns the operations in textual format of the user defined operation.
     * @return String the string containing the operation's name
     */  
    public String getOperationsTextual() {
        return operationsTextual;
    }

    /**
     * Modifies the old sequence of operations with the new sequence of operations.
     * @param operations the new sequence of operations
     * @throws UserDefinedCycleException If the inserted Operations have cycles.
     */
    public void modifyOperations(ArrayList<StackOperation> operations) throws UserDefinedCycleException{
        for(StackOperation op : operations){
           if(op instanceof UserDefinedOperation){
               UserDefinedOperation us = (UserDefinedOperation) op;
               if(children.containsKey(us.operationName))
                   throw new UserDefinedCycleException("Could not modify operation (Cycle found)");
           }
        }
        operationsSequence.clear();
        parents.clear();
        for(StackOperation op : operations)
            this.addOperation(op);
    }
    
    /**
     * This method implements the execution of the operations's sequence that defines the user operation.
     * Throws a runtime exception if the user defined operation has been deleted.
     */ 
    @Override
    public void execute() {
         if (operationsSequence.isEmpty()){
            throw new RuntimeException("The operation " + operationName + " has been deleted");
        }
        checkValidate();
        for(StackOperation stackOperation: operationsSequence)
            stackOperation.execute();
    }
    
    /**
     * Checks if all the operation's dependencies are executable.
     * Throws a runtime exception if at least one dependency of a user-defined operation has been deleted.
     */
    public void checkValidate() {
        if (operationsSequence.isEmpty()){
            throw new RuntimeException("The dependency " + operationName + " has been deleted");
        }
        for(UserDefinedOperation usOperation : parents){
            usOperation.checkValidate();
        }
    }
    
    /**
     * Adds a new child of the userDefined operation
     * @param child 
     */
    private void addChild(UserDefinedOperation child){
        children.put(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.addChild(child);
    }
    
    /**
     * Removes a child from the userDefined operation
     * @param child 
     */
    private void removeChild(UserDefinedOperation child){
        children.remove(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.removeChild(child);
    }
    
    /**
     * Removes the following UserDefinedOperation from its parents' children lists and removes all its operations.
     * It also sets the textual representation of the operations to "DELETED".
     */
    public void removeOperations(){
        for(UserDefinedOperation parent : parents)
            parent.removeChild(this);
        this.operationsSequence.clear();
        operationsTextual = "DELETED";
    }
    
    /**
     * Sets the textual representation of the operation.
     * @param operationsTextual the textual representation of the operation
     */
    public void setOperationsTextual(String operationsTextual) {
        this.operationsTextual = operationsTextual;
    }
    
}
