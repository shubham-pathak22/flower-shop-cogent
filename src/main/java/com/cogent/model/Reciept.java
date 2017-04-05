package com.cogent.model;

public class Reciept
{

  private String reciept;

  public Reciept(String reciept)
  {
    super();
    this.reciept = reciept;
  }

  public String getReciept()
  {
    return reciept;
  }

  @Override
  public String toString()
  {
    return reciept;
  }

}
