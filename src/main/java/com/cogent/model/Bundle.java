package com.cogent.model;

/**
 * Represents a Bundle. If the bundles are added to the list they will be sorted
 * in non-increasing order of their size
 *
 */
public class Bundle implements Comparable<Bundle>
{

  private int size;
  private double price;

  /**
   * Creates a Bundle object
   * 
   * @param size
   *          Size of the bundle
   * @param price
   *          Price of the bundle
   */
  public Bundle(int size, double price)
  {
    super();
    this.size = size;
    this.price = price;
  }

  /**
   * Get the bundle size
   * 
   * @return The bundle size
   */
  public int getSize()
  {
    return size;
  }

  /**
   * Set the size of the bundle
   * 
   * @param size
   *          Size of the bundle
   */
  public void setSize(int size)
  {
    this.size = size;
  }

  /**
   * Get the price of the bundle
   * 
   * @return the price of the bundle
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Sets the price of the bundle
   * 
   * @param price
   *          Price of the bundle
   */
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
