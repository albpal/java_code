package com.albpal.pocs;

import java.util.Map;
import javax.annotation.Resource;

public class Stock
{
    @Resource(name="stock")
    private Map<String, Integer> stock;

    Stock(){}

    public int getNumberOf(String product)
    {
      return stock.containsKey(product) ? (Integer)stock.get(product) : 0;
    }

    public void increaseBy(String product, int unitsToDeposit)
    {
      stock.put(product, (Integer)stock.get(product) + unitsToDeposit);
    }

    public void decreaseBy(String product, int unitsToWithdraw)
    {
      stock.put(product, (Integer)stock.get(product) - unitsToWithdraw);
    }
}
