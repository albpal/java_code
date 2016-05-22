package com.albpal.pocs.testng;

public class RectangleGeometry extends Geometry
{
  @Override
  public double getArea(Shape rectangle)
  {
    if (rectangle instanceof Rectangle)
      return ((Rectangle) rectangle).width * ((Rectangle)rectangle).high;

    return 0;
  }
}
