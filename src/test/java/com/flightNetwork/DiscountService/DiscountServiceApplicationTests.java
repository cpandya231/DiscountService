package com.flightNetwork.DiscountService;

import com.flightNetwork.DiscountService.resource.DiscountServiceResource;
import com.flightNetwork.DiscountService.service.IDiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceApplicationTests {

	@Autowired
	private IDiscountService discountService;

	@Test
	public void testDiscountServiceStandardCustomerAmountLT1000() {
		Assert.assertEquals(new Double(0D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("standard",1000D)));

	}

	@Test
	public void testDiscountServiceStandardCustomerAmountGT1000LT3000() {
		Assert.assertEquals(new Double(5D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("standard",1050D))); }


	@Test
	public void testDiscountServiceStandardCustomerAmountET3000() {
		Assert.assertEquals(new Double(200D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("standard",3000D))); }

	@Test
	public void testDiscountServiceStandardCustomerAmountGT3000LT5000() {
		Assert.assertEquals(new Double(357.5D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("standard",4050D)));

	}

	@Test
	public void testDiscountServiceStandardCustomerAmountGT5000() {
		Assert.assertEquals(new Double(700D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("standard",6000D)));

	}


	@Test
	public void testDiscountServicePremiumCustomerAmountLT500() {
		Assert.assertEquals(new Double(0D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("premium",490D)));

	}

	@Test
	public void testDiscountServicePremiumCustomerAmountGT500LT1000() {
		Assert.assertEquals(new Double(50D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("premium",1000D))); }



	@Test
	public void testDiscountServicePremiumCustomerAmountGT1000LT3000() {
		Assert.assertEquals(new Double(349.85D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("premium",2999D)));

	}

	@Test
	public void testDiscountServicePremiumCustomerAmountGT3000LT5000() {
		Assert.assertEquals(new Double(650D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("premium",4500D)));

	}

	@Test
	public void testDiscountServicePremiumCustomerAmountGT5000() {
		Assert.assertEquals(new Double(1000D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("premium",6000D)));

	}

	@Test
	public void testDiscountServiceInvalidUserType() {
		Assert.assertEquals(new Double(0D),new Double(discountService.getDiscountBasedOnUsertypeAndAmount("xyz",6000D)));

	}

}
