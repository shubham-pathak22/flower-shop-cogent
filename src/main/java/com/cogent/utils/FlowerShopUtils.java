package com.cogent.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.cogent.model.Bundle;
import com.cogent.model.Flower;
import com.cogent.model.Reciept;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * Utility classes for Flower Shop
 *
 */
public class FlowerShopUtils
{

  /**
   * Calulates the cost of the flower and returns a Reciept
   * 
   * @param flower
   *          Flower
   * @return Reciept
   */
  public static Reciept calculateBill(Flower flower)
  {
    int count, remainder = 0;
    Map<Bundle, Integer> sizeCount = null;
    int totalBundles = flower.getBundleSize();
    boolean finished = false;
    while (totalBundles != 0) {
      Iterator<Bundle> iter = ImmutableSet
          .copyOf(Iterables.skip(flower.getBundle(), flower.getBundle().size() - totalBundles)).iterator();
      sizeCount = new HashMap<Bundle, Integer>();
      remainder = flower.getOrder().getQuantity();
      while (iter.hasNext()) {
        Bundle b = iter.next();
        if (remainder < b.getSize()) {
          continue;
        }
        count = remainder / b.getSize();
        remainder = remainder % b.getSize();
        sizeCount.put(b, count);
        if (remainder == 0) {
          finished = true;
          break;
        }
      }
      if (finished) {
        break;
      } else {
        totalBundles--;
      }
    }
    if (remainder != 0) {
      return new Reciept("NOT A VALID ORDER FOR FLOWER CODE " + flower.getCode());
    } else {
      return new Reciept(generateReciept(sizeCount, flower.getCode(), flower.getOrder().getQuantity()));
    }
  }

  private static String generateReciept(Map<Bundle, Integer> sizeCount, String code, int quantity)
  {
    StringBuilder s = new StringBuilder();
    double total = 0;
    for (Bundle b : sizeCount.keySet()) {
      s.append(sizeCount.get(b)).append(" X ").append(b.getSize()).append(" $").append(b.getPrice()).append("\n");
      total += sizeCount.get(b) * b.getPrice();
    }
    total = (Math.round(total * 100.0)) / 100.0;
    return quantity + " " + code + " " + "$" + total + "\n" + s.toString();
  }
}
