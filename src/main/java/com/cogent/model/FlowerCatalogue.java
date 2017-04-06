package com.cogent.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.cogent.main.FlowerType;

/**
 * Singleton representing Flower Catalogue.
 *
 */
public class FlowerCatalogue
{
  private static FlowerCatalogue flowerCatalogue;

  private FlowerCatalogue()
  {
  }

  public static FlowerCatalogue getInstance()
  {
    if (flowerCatalogue == null) {
      flowerCatalogue = new FlowerCatalogue();
    }
    return flowerCatalogue;
  }

  private static Map<FlowerType, List<String>> priceMap = new HashMap<FlowerType, List<String>>();

  public void initialize()
  {
    String result = "";
    ClassLoader classLoader = FlowerCatalogue.class.getClassLoader();
    try {
      result = IOUtils.toString(classLoader.getResourceAsStream("Catalogue"));
      String[] flowers = result.split("\n");
      for (String f : flowers) {
        String[] flower = f.split("\\|");
        FlowerType fType = FlowerType.valueOf(flower[0]);
        List<String> prices = new ArrayList<String>();
        for (int i = 1; i < flower.length; i++) {
          prices.add(flower[i]);
        }
        priceMap.put(fType, prices);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<String> getBundleInfoList(FlowerType type)
  {
    return priceMap.get(type);
  }

}
