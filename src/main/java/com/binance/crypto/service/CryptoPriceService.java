package com.binance.crypto.service;



import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CryptoPriceService {

    private final Map<String, Double> priceMap = new ConcurrentHashMap<>();

    public Double getPrice(String symbol) {
        return priceMap.get(symbol);
    }

    public void updatePrice(String symbol, Double price) {
        priceMap.put(symbol, price);
    }
}
