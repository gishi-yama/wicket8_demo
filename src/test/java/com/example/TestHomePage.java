package com.example;

import com.example.page8.form.OrderPage01;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page8
		tester.startPage(OrderPage01.class);

		//assert rendered page8 class
		tester.assertRenderedPage(OrderPage01.class);
	}
}
