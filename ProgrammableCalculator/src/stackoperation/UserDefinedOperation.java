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
    * @return String This returns the string containing the operation's name
    */ 
    public String getOperationName() {
        return operationName;
    }
      
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
     */ 
    @Override
    public void execute() {
        checkValidate();
        for(StackOperation stackOperation: operationsSequence)
            stackOperation.execute();
    }
    
    /**
     * Check if all dependencies are executable.
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
     * Add a new child of the userDefined operation
     * @param child 
     */
    private void addChild(UserDefinedOperation child){
        children.put(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.addChild(child);
    }
    
    /**
     * remove a child from the userDefined operation
     * @param child 
     */
    private void removeChild(UserDefinedOperation child){
        children.remove(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.removeChild(child);
    }
    
    /**
     * Removes the following UserDefinedOperation from its parents' children lists and all its operations.
     * It also set the validate flag to false. 
     */
    public void removeOperations(){
        for(UserDefinedOperation parent : parents)
            parent.removeChild(this);
        this.operationsSequence.clear();
        operationsTextual = "";
    }

    public void setOperationsTextual(String operationsTextual) {
        this.operationsTextual = operationsTextual;
    }
    
}