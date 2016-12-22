package com.albpal.pocs;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.albpal.pocs.Stock;

@ContextConfiguration("classpath:spring-config.xml")
public class StockTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private Stock stockTest;

    @Test
    public void stockBasicOperations()
    {
      int milkStockNumber = stockTest.getNumberOf("milk");
      stockTest.increaseBy("milk", 3);
      assertEquals(stockTest.getNumberOf("milk"), milkStockNumber + 3, "Stock has not been calculated propertly");
      stockTest.decreaseBy("milk", 2);
      assertEquals(stockTest.getNumberOf("milk"), milkStockNumber + 1, "Stock has not been calculated propertly");
    }
}
