package com.binance.crypto;


import com.binance.crypto.service.CryptoPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@SpringBootTest
@AutoConfigureMockMvc
public class CryptoPriceHtmlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CryptoPriceService cryptoPriceService;

    @Test
    public void testGetCryptoPrices() throws Exception {

        cryptoPriceService.updatePrice("BTCUSDT", 62000.0);
        cryptoPriceService.updatePrice("ETHUSDT", 3200.0);


        mockMvc.perform(get("/crypto-prices"))
                .andExpect(status().isOk()) // Ожидаем HTTP-статус 200
                .andExpect(xpath("//h1").string("Cryptocurrency Prices")) // Проверяем заголовок
                .andExpect(xpath("//p[1]/span").string("62000.0")) // Проверяем цену Биткоина
                .andExpect(xpath("//p[2]/span").string("3200.0")); // Проверяем цену Эфира
    }
}
