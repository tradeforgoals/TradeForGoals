package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Product;
import com.hva.tradeforgoals.domain.Trade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {

    private static final long FAKE_ID = 1L;

    private TradeService objectUnderTest;

    @Mock
    private TradeRepository tradeRepositoryMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectUnderTest = new TradeService();
        objectUnderTest.setTradeRepository(tradeRepositoryMock);
    }

    @Test
    public void findById() {
        Trade trade = createTrade();
        when(tradeRepositoryMock.findById(FAKE_ID)).thenReturn(Optional.of(trade));

        Trade trade1 = objectUnderTest.findById(FAKE_ID);
        assertNotNull(trade1);

        assertEquals(trade1.getId(), trade.getId());
        assertEquals(2, trade.getTradingProducts().size());
        assertEquals(2, trade1.getTradingProducts().size());

    }

    @Test
    public void testSave() {
        Trade trade = createTrade();
        objectUnderTest.save(trade);

        assertNotNull(trade);
    }

    @Test
    public void testFindAll() {
        Trade trade1 = createTrade();
        Trade trade2 = createTrade();
        trade1.setId(1L);
        trade2.setId(2L);

        Iterable<Trade> trades = objectUnderTest.findAll();
        assertNotNull(trades);
    }

    private Trade createTrade() {

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setId(1L);
        product2.setId(2L);
        product1.setTitle("product1InTrade");
        product2.setTitle("product2InTrade");

        Set<Product> products = new HashSet<>();

        products.add(product1);
        products.add(product2);

        Trade trade = new Trade();
        trade.setId(FAKE_ID);
        trade.setTradingProducts(products);

        return trade;
    }
}