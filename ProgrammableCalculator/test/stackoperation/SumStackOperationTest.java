package stackoperation;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;
import static org.junit.Assert.*;
import calculatorstack.CalculatorStack;
import org.junit.Before;
/**
 *
 * @author Matteo Di Rienzo
 */
public class SumStackOperationTest {

    private CalculatorStack testStack;
    SumStackOperation sum;
    private Complex actual, expected;
    
    @Before
    public void init(){
        testStack = new CalculatorStack();
        sum = new SumStackOperation(testStack);
    }
      
    /**
     * Test of execute method when the stack is empty
     */
    @Test
    public void testExecuteEmptyStack() {
        System.out.println("testing the execution on a empty stack");
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
    }

    /**
     * Test of execute method on a one element stack
     */
    @Test
    public void testExecuteOneElementStack(){ 
        System.out.println("testing the execution on a one element stack");    
        Complex x = new Complex(5,-5);
        testStack.push(x);
        sum.execute();
        Complex actual = testStack.pop();
        Complex expected = x;
        assertEquals(actual, expected);
    }    
    /**
     * Test of execute method between elements of from the first quadrant
     */
    @Test  
    public void testExecuteFirstQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first quadrant");  
        testStack.push(new Complex( 2.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(3.0, 3.0);
        assertEquals(actual, expected);
    }
    
        /**
     * Test of execute method between elements of from the first and second quadrant
     */
    @Test
    public void testExecuteFirstSecondQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first and second quadrants");
        testStack.push(new Complex( -1.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(0.0 , 3.0);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method between elements of from the first and third quadrants
     */
    @Test
    public void testExecuteFirstThirdQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and third quadrants");
        testStack.push(new Complex( -1.0, -1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, 1.0);
        assertEquals(actual, expected);
    }
    /**
     * Test of execute method between elements of from the first and fourth quadrants
     */
    @Test
    public void testExecuteFirstFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and fourth quadrants");    
        testStack.push(new Complex(1.0, -1.0)); 
        testStack.push(new Complex(1.0, 3.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(2.0, 2.0);
        assertEquals(actual, expected);  
    }
    /**
     * Test of execute method between elements of from the second quadrant
     */
    @Test
    public void testExecuteSecondQuadrant(){
        System.out.println("testing the execution beetween elements of from the second quadrant");
        testStack.push(new Complex(-2.0, 1.0)); 
        testStack.push(new Complex(-1.0, 3.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 4.0);
        assertEquals(actual, expected); 
    }
    /**
     * Test of execute method between elements of from the second and third quadrants
     */
    @Test 
    public void testExecuteSecondThirdQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the second and third quadrants");    
        testStack.push(new Complex(-2.0, -1.0));         
        testStack.push(new Complex(-1.0, 3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 2.0);
        assertEquals(actual, expected); 
    }    
    /**
     * Test of execute method between elements of from the second and fourth quadrants
     */
    @Test
    public void testExecuteSecondFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the second and fourth quadrants");    
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, 3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 2.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the third quadrant
     */
    @Test
    public void testExecuteThirdQuadrant(){   
        testStack.push(new Complex(-2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, -3.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the third and fourth quadrants
     */
    @Test
    public void testExecuteThirdFourthQuadrant(){   
        System.out.println("testing the execution beetween elements of from the third and fourth quadrants");
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -3.0);
        assertEquals(actual, expected); 
    }
    
     /**
     * Test of execute method between elements of from the fourth quadrant
     */
    @Test
    public void testExecuteFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the fourth quadrant");
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(3.0, -3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(5.0, -4.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method when the result is 1
     */
    @Test
    public void testExecuteResultOne(){
        System.out.println("testing the execution when the result is 1");
        testStack.push(new Complex(-2.0, 1.0));  
        testStack.push(new Complex(3.0, -1.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ONE;
        assertEquals(actual, expected);   
    }
    
    /**
     * Test of execute method when the result is 0
     */
    @Test
    public void testExecuteResultZero(){  
        System.out.println("testing the execution when the result is 0");
        testStack.push(new Complex(-1.0, -1.0));
        testStack.push(new Complex(1.0, 1.0));
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);   
    }
}
