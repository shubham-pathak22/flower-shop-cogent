package com.cogent.exception;

public class InvalidOrderException extends Exception
{
  public InvalidOrderException()
  {
    super("Incorrent format of the Order. Please enter a valid order");
  }

}
