package com.flightNetwork.DiscountService;

import com.flightNetwork.DiscountService.resource.DiscountServiceResource;
import com.flightNetwork.DiscountService.service.IDiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceResourceTests {

	@Mock
	private IDiscountService discountService;

	@Autowired
	private DiscountServiceResource  discountServiceResource;

	@Test
	public void testDiscountServiceDiscountServiceResource() {
		Mockito.when(discountService.getDiscountBasedOnUsertypeAndAmount("standard",1050D)).thenReturn(5D);
		Assert.assertEquals("Discounted amount is 1050.0- 5.0 1045.0",discountServiceResource.getDiscount("standard",1050D).getBody());

	}

}
