package com.flightNetwork.DiscountService.service;

public interface IDiscountService {

    Double getDiscountBasedOnUsertypeAndAmount(String userType, Double amount);
    Double calculateDiscountForStandardCustomer(Double amount) ;
    Double calculateDiscountForPremiumCustomer(Double amount);
}
