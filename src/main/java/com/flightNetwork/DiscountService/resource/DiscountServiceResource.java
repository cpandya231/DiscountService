package com.flightNetwork.DiscountService.resource;


import com.flightNetwork.DiscountService.service.DiscountService;
import com.flightNetwork.DiscountService.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DiscountServiceResource {

    @Autowired
    private IDiscountService discountService;
    @GetMapping("/discount")
    public ResponseEntity<String> getDiscount(@RequestParam("userType") String userType, @RequestParam("amount") Double amount){

        Double discount=discountService.getDiscountBasedOnUsertypeAndAmount(userType,amount);

        return new ResponseEntity<>("Discounted amount is "+amount+"- "+discount+" "+(amount-discount), HttpStatus.OK);
    }



}
