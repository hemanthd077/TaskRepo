package ddd;

import helper.StringHelper;

import static org.junit.Assert.*;

import org.junit.Test;

import customException.CustomException;

public class Test1 {

	StringHelper helper = new StringHelper();
	
	@Test
	public  void test2() {
		try {
			assertEquals("he",helper.firstNChar("hemanth",2));
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
}
