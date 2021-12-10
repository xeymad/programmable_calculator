/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexvariablesvector;

import java.util.Iterator;
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arianna Carratù
 */
public class ComplexVariablesVectorTest {
    private ComplexVariablesVector instance;
    
    @Before
    public void setUp() {
        instance = new ComplexVariablesVector();
    }
    
    /**
     * Test of getVarValue method, of class ComplexVariablesVector.
     */
    @Test
    public void testGetVarValue() {
        System.out.println("getVarValue");
        char var = 's';
        Complex expResult = Complex.ZERO;
        Complex result = instance.getVarValue(var);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setVarValue method, of class ComplexVariablesVector.
     */
    @Test
    public void testSetVarValue() {
        System.out.println("setVarValue");
        char var = 'c';
        Complex expResult = new Complex(2,3);
        instance.setVarValue(var, expResult);
        Complex result=instance.getVarValue('c');
        assertEquals(result,expResult);
    }

    /**
     * Test of iterator method, of class ComplexVariablesVector.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Complex expResult1=new Complex(3,213);
        Complex expResult2=new Complex(77,-12);
        Complex expResult3=new Complex(-9,8);
        instance.setVarValue('a',expResult1);
        instance.setVarValue('b',expResult2);
        instance.setVarValue('c',expResult3);
        Iterator<ComplexVariable> iterator = instance.iterator();
        assertEquals(expResult1, iterator.next().getComplex());
        assertTrue(iterator.hasNext());
        assertEquals(expResult2, iterator.next().getComplex());
        assertTrue(iterator.hasNext());
        assertEquals(expResult3, iterator.next().getComplex());
        assertTrue(iterator.hasNext());
    }
    
}
