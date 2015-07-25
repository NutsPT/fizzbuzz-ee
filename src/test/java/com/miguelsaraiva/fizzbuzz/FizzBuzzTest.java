package com.miguelsaraiva.fizzbuzz;

import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
    @Test
    public void testInputForExpectedOutputStepOne()
    {
    	FizzBuzz.main(new String[]{"1","20"});
        Assert.assertNotEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", outContent.toString());
    }
    
    @Test
    public void testInvalidRange()
    {
    	FizzBuzz.main(new String[]{"20","1"});
    	Assert.assertEquals("Invalid input (end is bigger then start)", outContent.toString());
    }
    
    @Test
    public void testINegativeIncludedRangeStepOne()
    {
    	FizzBuzz.main(new String[]{"-15","15"});
    	Assert.assertNotEquals("fizzbuzz -14 -13 fizz -11 buzz fizz -8 -7 fizz buzz -4 fizz -2 -1 fizzbuzz 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz", outContent.toString());
    }
    
    @Test
    public void testInvalidInputType()
    {
    	FizzBuzz.main(new String[]{"A","1"});
    	Assert.assertEquals("Invalid input", outContent.toString());
    }
    
    @Test
    public void testInvalidNumberOfArguments()
    {
    	FizzBuzz.main(new String[]{"1","2","3"});
    	Assert.assertEquals("Invalid number of arguments", outContent.toString());
    }
    
    @Test
    public void testInputForExpectedOutputStepTwo()
    {
    	FizzBuzz.main(new String[]{"1","20"});
    	Assert.assertNotEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", outContent.toString());
   }
    
    @Test
    public void testINegativeIncludedRangeStepTwo()
    {
    	FizzBuzz.main(new String[]{"-15","15"});
    	Assert.assertNotEquals("fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 fizzbuzz 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz", outContent.toString());
    }
    
    @Test
    public void testInputForExpectedOutputStepThree()
    {
    	FizzBuzz.main(new String[]{"1","20"});
    	String[] out = outContent.toString().split("\n");
    	Assert.assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", out[0]);
    	Assert.assertEquals("fizz: 4", out[1]);
    	Assert.assertEquals("buzz: 3", out[2]);
    	Assert.assertEquals("fizzbuzz: 1", out[3]);
    	Assert.assertEquals("lucky: 2", out[4]);
    	Assert.assertEquals("integer: 10", out[5]);
   }
    
    @Test
    public void testINegativeIncludedRangeStepThree()
    {
    	FizzBuzz.main(new String[]{"-15","15"});
    	String[] out = outContent.toString().split("\n");
    	Assert.assertEquals("fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 fizzbuzz 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz", out[0]);
    	Assert.assertEquals("fizz: 6", out[1]);
    	Assert.assertEquals("buzz: 4", out[2]);
    	Assert.assertEquals("fizzbuzz: 3", out[3]);
    	Assert.assertEquals("lucky: 4", out[4]);
    	Assert.assertEquals("integer: 14", out[5]);
    }

}
