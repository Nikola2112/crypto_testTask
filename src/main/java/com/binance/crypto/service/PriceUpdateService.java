package com.binance.crypto.service;


import com.binance.crypto.model.BinancePriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceUpdateService {

    @Value("${application.link}")
    private String BINANCE_MARK_PRICE_URL;

    private final RestTemplate restTemplate = new RestTemplate();
    private final CryptoPriceService cryptoPriceService;

    @Autowired
    public PriceUpdateService(CryptoPriceService cryptoPriceService) {
        this.cryptoPriceService = cryptoPriceService;
    }

    @Scheduled(fixedRate = 10000) // Обновление каждые 10 секунд
    public void updatePrices() {
        String[] symbols = {"BTCUSDT", "ETHUSDT"};

        for (String symbol : symbols) {
            try {
                BinancePriceResponse response = restTemplate.getForObject(
                        BINANCE_MARK_PRICE_URL + symbol, BinancePriceResponse.class);
                if (response != null) {
                    cryptoPriceService.updatePrice(symbol, response.getMarkPrice());
                }
            } catch (Exception e) {
                System.err.println("Error fetching price for " + symbol + ": " + e.getMessage());
            }
        }
    }
}
