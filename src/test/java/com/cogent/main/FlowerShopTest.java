package com.cogent.main;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cogent.model.FlowerCatalogue;
import com.cogent.model.Lily;
import com.cogent.model.Order;
import com.cogent.model.Rose;
import com.cogent.model.Tulip;

import junit.framework.Assert;

public class FlowerShopTest
{

  private static FlowerCatalogue catalogue;

  @BeforeClass
  public static void setup()
  {
    catalogue = FlowerCatalogue.getInstance();
    catalogue.initialize("file/Catalogue");
  }

  @After
  public void cleanUp()
  {
    FlowerShop.clearBucket();
  }

  @Test
  public void testRoseValid()
  {
    FlowerShop.addToList(new Rose("R12", new Order(10)));
    Assert.assertEquals("10 R12 $12.99\n1 X 10 $12.99\n", FlowerShop.getReciept());
  }

  @Test
  public void testLilyValid()
  {
    FlowerShop.addToList(new Tulip("L09", new Order(9)));
    Assert.assertEquals("9 L09 $24.95\n1 X 9 $24.95\n", FlowerShop.getReciept());
  }

  @Test
  public void testTulipValid()
  {
    FlowerShop.addToList(new Tulip("T58", new Order(10)));
    Assert.assertEquals("10 T58 $19.9\n2 X 5 $9.95\n", FlowerShop.getReciept());
  }

  @Test
  public void testRoseInvalid()
  {
    FlowerShop.addToList(new Rose("R12", new Order(1)));
    Assert.assertEquals("NOT A VALID ORDER FOR FLOWER CODE R12", FlowerShop.getReciept());
  }

  @Test
  public void testLilyInvalid()
  {
    FlowerShop.addToList(new Lily("L09", new Order(1)));
    Assert.assertEquals("NOT A VALID ORDER FOR FLOWER CODE L09", FlowerShop.getReciept());
  }

  @Test
  public void testTulipInvalid()
  {
    FlowerShop.addToList(new Tulip("T58", new Order(1)));
    Assert.assertEquals("NOT A VALID ORDER FOR FLOWER CODE T58", FlowerShop.getReciept());
  }

  @Test
  public void testMultipleOrder()
  {
    FlowerShop.addToList(new Rose("R12", new Order(10)));
    FlowerShop.addToList(new Lily("L09", new Order(15)));
    FlowerShop.addToList(new Tulip("T58", new Order(13)));
    Assert.assertEquals(
        "10 R12 $12.99\n1 X 10 $12.99\n\n15 L09 $41.9\n1 X 9 $24.95\n1 X 6 $16.95\n\n13 T58 $25.85\n2 X 5 $9.95\n1 X 3 $5.95\n",
        FlowerShop.getReciept());
  }

}
