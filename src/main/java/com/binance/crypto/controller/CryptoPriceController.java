package com.binance.crypto.controller;




import com.binance.crypto.service.CryptoPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoPriceController {

    private final CryptoPriceService cryptoPriceService;

    @Autowired
    public CryptoPriceController(CryptoPriceService cryptoPriceService) {
        this.cryptoPriceService = cryptoPriceService;
    }

    @GetMapping("/crypto-price/{symbol}")
    public Double getCurrentPrice(@PathVariable String symbol) {
        return cryptoPriceService.getPrice(symbol.toUpperCase());
    }
}
