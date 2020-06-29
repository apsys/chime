package com.test.chime;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.chime.common.utility.RestClientImpl;
import com.test.chime.common.utility.WResponse;
import com.test.chime.base.BaseTest;
import com.test.chime.base.Path;

public class TakeHomeTest extends BaseTest{	

	RestClientImpl restClient = new RestClientImpl();

	@Test (groups="regression")
	public void testOne() {
		WResponse apiResponse = restClient.get(Path.RANDOM);
		Assert.assertEquals(apiResponse.getType(), "programming");
	}

	@Test (groups="regression")
	public void testTwo() {		
		WResponse apiResponse = restClient.get(Path.TEN);
		Assert.assertEquals(apiResponse.getSize(), 10);
		Assert.assertTrue(apiResponse.verifyAll());
	}
}
