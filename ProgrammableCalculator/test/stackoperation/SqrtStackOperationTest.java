/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import org.junit.*;
import static org.junit.Assert.*;
import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author aferr
 */
public class SqrtStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private SqrtStackOperation sqrtStackOperation;
    
    /**
     * Initialize a CalculatorStack and the SqrtStackOperation command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        sqrtStackOperation = new SqrtStackOperation(calculatorStack);
    }
    
    /**
     * Test case for a positive real number.
     */
    @Test
    public void testExecutePositiveReal(){
        Complex input = new Complex(42, 0);
        Complex expected = new Complex(6.48074069840786, 0);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for a negative real number.
     */
    @Test
    public void testExecuteNegativeReal(){
        Complex input = new Complex(-42, 0);
        Complex expected = new Complex(0, 6.48074069840786);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for a positive imaginary number.
     */
    @Test
    public void testExecutePositiveImaginary(){
        Complex input = new Complex(0, 42);
        Complex expected = new Complex(4.582575694955840, 4.582575694955840);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for a negative imaginary number.
     */
    @Test
    public void testExecuteNegativeImaginary(){
        Complex input = new Complex(0, -42);
        Complex expected = new Complex(4.582575694955840, -4.582575694955840);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for positive real part and positive imaginary part.
     */
    @Test
    public void testExecutePosRealPosIm(){
        Complex input = new Complex(42, 42);
        Complex expected = new Complex(7.120286848844995, 2.949319380778385);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for positive real part and negative imaginary part.
     */
    @Test
    public void testExecutePosRealNegIm(){
        Complex input = new Complex(42, -42);
        Complex expected = new Complex(7.120286848844995, -2.949319380778385);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for negative real part and positive imaginary part.
     */
    @Test
    public void testExecuteNegRealPosIm(){
        Complex input = new Complex(-42, 42);
        Complex expected = new Complex(2.949319380778385, 7.120286848844995);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
    
    /**
     * Test case for negative real part and negative imaginary part.
     */
    @Test
    public void testExecuteNegRealNegIm(){
        Complex input = new Complex(-42, -42);
        Complex expected = new Complex(2.949319380778385, -7.120286848844995);
        calculatorStack.push(input);
        sqrtStackOperation.execute();
        Complex result = calculatorStack.pop();
        assertEquals(expected, result);
    }
}
