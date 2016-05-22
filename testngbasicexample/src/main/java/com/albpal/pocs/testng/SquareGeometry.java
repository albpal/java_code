package com.albpal.pocs.testng;

public class SquareGeometry extends Geometry
{
  @Override
  public double getArea(Shape square)
  {
    if (square instanceof Square)
      return ((Square)square).width * ((Square)square).width;

    return 0;
  }
}
