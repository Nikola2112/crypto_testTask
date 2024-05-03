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

@SpringBootTest
@AutoConfigureMockMvc
public class CryptoPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CryptoPriceService cryptoPriceService;

    @Test
    public void testGetCurrentPrice() throws Exception {
        cryptoPriceService.updatePrice("BTCUSDT", 62000.0);


        mockMvc.perform(get("/crypto-price/BTCUSDT"))
                .andExpect(status().isOk()) // Проверяем, что статус ответа 200
                .andExpect(content().string("62000.0")); // Ожидаемое значение в ответе
    }
}
