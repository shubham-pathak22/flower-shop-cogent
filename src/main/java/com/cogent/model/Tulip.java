package com.cogent.model;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.cogent.main.FlowerType;
import com.cogent.utils.FlowerShopUtils;

public class Tulip extends Flower
{
  private SortedSet<Bundle> bundle;

  public Tulip(String code, Order order)
  {
    super(code, order);
    this.bundle = new TreeSet<Bundle>();
    for (String b : FlowerCatalogue.getBundleInfoList(FlowerType.valueOf(code))) {
      String[] tuple = b.split("@");
      this.addToBundle(Integer.parseInt(tuple[0]), Double.parseDouble(tuple[1]));
    }
  }

  private void addToBundle(int size, double price)
  {
    this.bundle.add(new Bundle(size, price));

  }

  @Override
  public int getBundleSize()
  {
    return this.bundle.size();
  }

  @Override
  public Reciept getReciept()
  {
    return FlowerShopUtils.calculateBill(this);
  }

  @Override
  public Collection getBundle()
  {
    return this.bundle;
  }

}
