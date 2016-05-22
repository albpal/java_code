package com.albpal.pocs.testng;

public class ShapeBuilder
{
  public Shape buildSquare(double width)
  {
    return new Square(width);
  }

  public Shape buildRectangle(double width, double high)
  {
    return new Rectangle(width, high);
  }
}
