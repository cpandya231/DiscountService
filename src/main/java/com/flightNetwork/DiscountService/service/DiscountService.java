package com.flightNetwork.DiscountService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("discountService")
public class DiscountService implements IDiscountService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Double getDiscountBasedOnUsertypeAndAmount(String userType, Double amount) {
        Double calculatedDiscount = 0.0;

        if (userType.equalsIgnoreCase("standard")) {
            calculatedDiscount = calculateDiscountForStandardCustomer(amount);
        } else if (userType.equalsIgnoreCase("premium")) {
            calculatedDiscount = calculateDiscountForPremiumCustomer(amount);
        } else {
            logger.error("Invalid UserType");


        }
        return calculatedDiscount;
    }

    @Override
    public Double calculateDiscountForStandardCustomer(Double amount) {
        if (amount <= 1000) {
            return 0.0;
        } else if (amount > 1000 && amount <= 3000) {
            amount = amount - 1000;
            return calculateDiscount(amount, 10);
        } else if (amount > 3000 && amount <= 5000) {
            amount = amount - 3000;
            return calculateDiscount(2000D, 10) + calculateDiscount(amount, 15);
        } else {
            amount = amount - 5000;
            return calculateDiscount(2000D, 10) + calculateDiscount(2000D, 15)
                    + calculateDiscount(amount, 20);
        }
    }

    @Override
    public Double calculateDiscountForPremiumCustomer(Double amount) {
        if (amount <= 500) {
            return 0.0;
        } else if (amount > 500 && amount <= 1000) {
            amount = amount - 500;
            return calculateDiscount(amount, 10);
        } else if (amount > 1000 && amount <= 3000) {
            amount = amount - 1000;
            return calculateDiscount(500D, 10) + calculateDiscount(amount, 15);
        } else if (amount > 3000 && amount <= 5000) {
            amount = amount - 3000;
            return calculateDiscount(500D, 10) + calculateDiscount(2000D, 15) + calculateDiscount(amount, 20);
        } else {
            amount = amount - 5000;
            return calculateDiscount(500D, 10) + calculateDiscount(2000D, 15) + calculateDiscount(2000D, 20)
                    + calculateDiscount(amount, 25);
        }
    }

    private Double calculateDiscount(Double amount, Integer rate) {
        return amount * rate / 100;
    }
}
