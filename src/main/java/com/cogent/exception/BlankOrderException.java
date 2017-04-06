package com.cogent.exception;

public class BlankOrderException extends Exception
{

  public BlankOrderException()
  {
    super("Please enter a valid Order");
  }
}
