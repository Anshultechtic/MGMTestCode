package sqlTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;

public class R_TC extends BaseClass  {

	
	@Test
	public void TC1() {

		System.out.println("Hello");
		Assert.assertTrue(false);
	}
	
	@Test
	public void TC2() {
		System.out.println("Hello");
		Assert.assertTrue(true);

	}

	
	@Test
	public void TC3() {
		System.out.println("Hello");
		
		Assert.assertTrue(false);

	}
	
	@Test
	public void TC4() {
		System.out.println("Hello");
		
		Assert.assertTrue(true);

	}
	
	
	@Test
	public void TC5() {
		System.out.println("Hello");
		
		Assert.assertTrue(true);

	}
	
	@Test
	public void TC6() {
		System.out.println("Hello");
		
		Assert.assertTrue(false);

	}
	
	@Test
	public void TC8() {
		System.out.println("Hello");
		
		Assert.assertTrue(false);

	}
	
	@Test
	public void TC9() {
		System.out.println("Hello");
		
		Assert.assertTrue(true);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
