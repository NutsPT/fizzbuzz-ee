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
    public void testSimpleInputForExpectedOutputStepOne()
    {
    	FizzBuzz.main(new String[]{"1","20"});
        Assert.assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", outContent.toString());
    }
    
    @Test
    public void testInvalidRange()
    {
    	FizzBuzz.main(new String[]{"20","1"});
    	Assert.assertEquals("Invalid input (end is bigger then start)", outContent.toString());
    }
    
    @Test
    public void testINegativeIncludedRange()
    {
    	FizzBuzz.main(new String[]{"-15","15"});
    	Assert.assertEquals("fizzbuzz -14 -13 fizz -11 buzz fizz -8 -7 fizz buzz -4 fizz -2 -1 fizzbuzz 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz", outContent.toString());
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

}
