package com.cogent.model;

import java.util.Collection;

public abstract class Flower
{

  private String code;
  private Order order;

  public Flower(String code,Order order)
  {
    super();
    this.code = code;
    this.order = order;
  }

  public String getCode()
  {
    return code;
  }
  
  public Order getOrder()
  {
    return order;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public abstract int getBundleSize();

  public abstract Collection getBundle();

  public abstract Reciept getReciept();

}
