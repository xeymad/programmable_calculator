/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.commons.math3.complex;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.apache.commons.math3.complex.ComplexFormat;
import org.apache.commons.math3.exception.MathParseException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Giuseppe
 */
public class ComplexFormatTest {
    private ComplexFormat instance;
    
    /**
     * Initialize the ComplexFormat with "." as DecimalFormat.
     */
    @Before
    public void setUp() {
        instance = ComplexFormat.getInstance('j', Locale.US);
    }
    
    @Test
    public void testParseWithoutException1(){
        Complex c = new Complex(3.23,4.55);
        Complex parsed = instance.parse("3.23+4.55j");
        assertEquals(c,parsed);
    }

    @Test    
    public void testParseWithoutException2(){
        Complex c = new Complex(1,0);
        Complex parsed = instance.parse("1");
        assertEquals(c,parsed);
    }

    @Test    
    public void testParseWithoutException3(){
        Complex c = new Complex(10,-12);
        Complex parsed = instance.parse("10-12j");
        assertEquals(c,parsed);
    }

    @Test
    public void testParseWithoutException4(){
        Complex c = new Complex(0,-1);
        Complex parsed = instance.parse("-1j");
        assertEquals(c,parsed);
    }
    @Test(expected = MathParseException.class)
    public void testParseWithException1(){
        instance.parse("1k");
    }
            
    @Test(expected = MathParseException.class)
    public void testParseWithException2(){
        instance.parse("23r3g4tgv14");
    }
    
    @Test(expected = MathParseException.class)
    public void testParseWithException3(){
        instance.parse("3,556+45j");
    }
    
    @Test(expected = MathParseException.class)
    public void testParseWithException4(){
        instance.parse("4+3jwdqevqeverqv");
    }
    
    @Test(expected = MathParseException.class)
    public void testParseWithException5(){
        instance.parse("jwdwefef");
    }
    
    @Test(expected = MathParseException.class)
    public void testParseWithException6(){
        instance.parse("+j");
    }
    
        
    @Test(expected = MathParseException.class)
    public void testParseWithException7(){
        instance.parse("-j");
    }
}
