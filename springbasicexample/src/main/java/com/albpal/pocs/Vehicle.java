package com.albpal.pocs;

public abstract class Vehicle
{
      String brand;
      String colour;

      public String getBrand() { return brand; }
      public String getColour() { return colour; }

      public void setBrand(String b)
      {
        brand = b;
      }

      public void setColour(String c)
      {
        colour = c;
      }

      public void foo()
      {
        System.out.println("My class is " + getClass().getName() + ", my brand is " + getBrand() + " and my colour is " + getColour());
      }
}
