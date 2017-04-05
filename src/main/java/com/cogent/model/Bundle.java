package com.cogent.model;

public class Bundle implements Comparable<Bundle>
{

  private int size;
  private double price;

  public Bundle(int size, double price)
  {
    super();
    this.size = size;
    this.price = price;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public int compareTo(Bundle bundle)
  {
    return bundle.size - this.size;
  }

  @Override
  public String toString()
  {
    return "Bundle [size=" + size + ", price=" + price + "]";
  }

}
