package com.binance.crypto.controller;

import com.binance.crypto.service.CryptoPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoPriceHtmlController {

    private final CryptoPriceService cryptoPriceService;

    @Autowired
    public CryptoPriceHtmlController(CryptoPriceService cryptoPriceService) {
        this.cryptoPriceService = cryptoPriceService;
    }

    @GetMapping("/crypto-prices")
    public String getCryptoPrices(Model model) {
        Double btcPrice = cryptoPriceService.getPrice("BTCUSDT");
        Double ethPrice = cryptoPriceService.getPrice("ETHUSDT");

        model.addAttribute("btcPrice", btcPrice);
        model.addAttribute("ethPrice", ethPrice);

        return "crypto-prices";
    }
}
