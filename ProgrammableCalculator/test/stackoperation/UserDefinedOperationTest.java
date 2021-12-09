/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.ArrayList;
import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import userdefinedoperationformat.UserDefinedParseException;

/**
 *
 * @author Arianna Carratù, Giuseppe
 */
public class UserDefinedOperationTest {
    private UserDefinedOperation instance;
    private String operationName;
    private String operationsText; 
    private CalculatorStack calculatorStack;
    private ArrayList<StackOperation> operationsSequence;
 
    //dup * swap dup * + sqrt
    @Before
    public void setUp() {
    operationName = "hypotenuse";
    calculatorStack=new CalculatorStack();
    operationsSequence= new ArrayList<>();
    calculatorStack.push(new Complex(3,0));
    calculatorStack.push(new Complex(4,0));
    operationsSequence.add(new DupStackOperation(calculatorStack));
    operationsSequence.add(new MultiplicationStackOperation(calculatorStack));
    operationsSequence.add(new SwapStackOperation(calculatorStack));
    operationsSequence.add(new DupStackOperation(calculatorStack));
    operationsSequence.add(new MultiplicationStackOperation(calculatorStack));
    operationsSequence.add(new SumStackOperation(calculatorStack));
    operationsSequence.add(new SqrtStackOperation(calculatorStack));
    operationsText = "dup * swap dup * + sqrt";
    instance= new UserDefinedOperation(operationName, operationsText ,operationsSequence, calculatorStack);
    }
    
    /**
     * Test of getOperationName method, of class UserDefinedOperation.
     */
    @Test
    public void testGetOperationName() {
        System.out.println("getOperationName");
        String result = instance.getOperationName();
        assertEquals(operationName, result);

    }

    /**
     * Test of execute method, of class UserDefinedOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        instance.execute();
        assertEquals(calculatorStack.top(), new Complex(5,0));
    }
    
    /**
     * Test of modifyOperations method of class UserDefinedOperation
     */
    @Test(expected = UserDefinedCycleException.class)
    public void testModifyOperations() throws UserDefinedCycleException{
        System.out.println("modify");
        ArrayList<StackOperation> sequenceUs = new ArrayList<>();
        sequenceUs.add(instance);
        UserDefinedOperation b = new UserDefinedOperation("B",operationsText,sequenceUs,calculatorStack);
        operationsSequence.add(b);
        instance.modifyOperations(operationsText,operationsSequence);
        
    }
}
