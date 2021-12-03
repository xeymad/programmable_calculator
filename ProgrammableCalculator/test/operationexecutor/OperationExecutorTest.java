/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationexecutor;

import org.junit.*;
import static org.junit.Assert.*;
import calculatorstack.*;
import stackoperation.*;
import variablesvector.VariablesVector;

/**
 *
 * @author aferr
 */
public class OperationExecutorTest {

    private OperationExecutor operationExecutor;
    private CalculatorStack calculatorStack;
    private VariablesVector variablesVector;

    /**
     * Initialize a OperationExecutor with a new CalculatorStack
     */
    @Before
    public void init() {
        calculatorStack = new CalculatorStack();
        variablesVector = new VariablesVector();
        operationExecutor = new OperationExecutor(calculatorStack,variablesVector);    
    }

    /**
     * Test if the constructor puts the right entries into the dictionary. The
     * dictionary should contains the following entries: <br>
     * - &lt;"+", SumStackOperation&gt; <br>
     * - &lt;"-", SubtractionStackOperation&gt; <br>
     * - &lt;"-", MultiplicationStackOperation&gt; <br>
     * - &lt;"-", DivisionStackOperation&gt; <br>
     * - &lt;"-", SqrtStackOperation&gt; <br>
     * - &lt;"-", InvertSignStackOperation&gt; <br>
     * In order to perform the test, the getOperation method is being used. Thus
     * the following tests the getOperation method too.
     */
    @Test
    public void testConstructor() {
        StackOperation sumStackOperation = operationExecutor.getOperation("+");
        assertNotNull(sumStackOperation);
        assertTrue(sumStackOperation instanceof SumStackOperation);
        
        StackOperation subtractionStackOperation = operationExecutor.getOperation("-");
        assertNotNull(subtractionStackOperation);
        assertTrue(subtractionStackOperation instanceof SubtractionStackOperation);
        
        StackOperation multiplicationStackOperation = operationExecutor.getOperation("*");
        assertNotNull(multiplicationStackOperation);
        assertTrue(multiplicationStackOperation instanceof MultiplicationStackOperation);
        
        StackOperation divisionStackOperation = operationExecutor.getOperation("/");
        assertNotNull(divisionStackOperation);
        assertTrue(divisionStackOperation instanceof DivisionStackOperation);
        
        StackOperation sqrtStackOperation = operationExecutor.getOperation("sqrt");
        assertNotNull(sqrtStackOperation);
        assertTrue(sqrtStackOperation instanceof SqrtStackOperation);
        
        StackOperation invertSignStackOperation = operationExecutor.getOperation("+-");
        assertNotNull(invertSignStackOperation);
        assertTrue(invertSignStackOperation instanceof InvertSignStackOperation);
    }

    /**
     * Test if the putOperation method puts an entry into the dictionary.
     */
    @Test
    public void testPutOperation() {
        StackOperation sumStackOperation = new SumStackOperation(calculatorStack);
        operationExecutor.putOperation("sum", sumStackOperation);
        
        StackOperation shouldBeSumStackOperation = operationExecutor.getOperation("sum");
        assertNotNull(shouldBeSumStackOperation);
        assertTrue(shouldBeSumStackOperation instanceof SumStackOperation);
    }

    /**
     * Test if the removeOperation method removes an existing entry from the dictionary.
     */
    @Test
    public void testRemoveOperation() {
        operationExecutor.removeOperation("+");
        StackOperation shouldBeNullOperation = operationExecutor.getOperation("+");
        assertNull(shouldBeNullOperation);
    }
    
    /**
     * Test if the removeOperation method returns null when an operation's name
     * not present in the dictionary is given as input.
     */
    @Test
    public void testRemoveOperationNotPresent(){
        StackOperation removedOperation = operationExecutor.removeOperation("404");
        assertNull(removedOperation);
    }

    /**
     * Test if the renameOperation method changes the name of an existing entry
     * and returns True.
     */
    @Test
    public void testRenameOperation() {
        boolean nameChanged = operationExecutor.renameOperation("+", "sum");
        assertTrue(nameChanged);
        
        StackOperation shouldBeNullOperation = operationExecutor.getOperation("+");
        assertNull(shouldBeNullOperation);
        
        StackOperation shouldBeSumOperation = operationExecutor.getOperation("sum");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with
     * key equals to name is not present in the dictionary and there aren't any
     * associations to the given names.
     */
    @Test
    public void testRenameOperationNotPresent(){
        boolean nameChanged = operationExecutor.renameOperation("404", "200");
        assertFalse(nameChanged);
        
        StackOperation shouldBeNullOperation = operationExecutor.getOperation("404");
        assertNull(shouldBeNullOperation);
        
        StackOperation shouldBeNullOperation2 = operationExecutor.getOperation("200");
        assertNull(shouldBeNullOperation2);
        
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with 
     * Key equals to newName is already present in the dictionary and the
     * associations have not been changed.
     */
    @Test
    public void testRenameOperationAlreadyPresent(){
        boolean nameChanged = operationExecutor.renameOperation("+", "-");
        assertFalse(nameChanged);
        
        StackOperation shouldBeSumOperation = operationExecutor.getOperation("+");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
        
        StackOperation shouldBeSubtractionOperation = operationExecutor.getOperation("-");
        assertNotNull(shouldBeSubtractionOperation);
        assertTrue(shouldBeSubtractionOperation instanceof SubtractionStackOperation);
    }

    /**
     * Test if containsKey method returns True when the Key is present in the
     * dictionary.
     */
    @Test
    public void testContainsKey() {
        boolean keyIsPresent = operationExecutor.containsKey("+");
        assertTrue(keyIsPresent);
    }

    /**
     * Test if containsKey method returns False when the Key is NOT present
     * in the dictionary.
     */
    @Test
    public void testContainsKeyNotPresent(){
        boolean keyIsPresent = operationExecutor.containsKey("404");
        assertFalse(keyIsPresent);
    }
    /**
     * Test if the execute method performed on an operation present in the 
     * dictionary returns True.
     */
    @Test
    public void testExecute() {
        boolean operationPerformed = operationExecutor.execute("+");
        assertTrue(operationPerformed);
    }
    
    /**
     * Test if the execute method performed on an operation NOT present
     * in the dictionary returns False.
     */
    @Test
    public void testExecuteNotPresent(){
        boolean operationPerformed = operationExecutor.execute("404");
        assertFalse(operationPerformed);
    }
    
}
