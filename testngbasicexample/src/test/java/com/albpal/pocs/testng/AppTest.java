package com.albpal.pocs.testng;

import org.testng.annotations.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.albpal.pocs.testng.Shape;
import com.albpal.pocs.testng.Geometry;

@SpringBootApplication
public class AppTest
{
  @Test
	public void exampleOfTestNgMaven()
  {
    ApplicationContext ctx = SpringApplication.run(AppTest.class);

    ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Example.xml" });

    Shape square = (Shape) appContext.getBean("Square", 10);
    Geometry squareGeom = (Geometry) appContext.getBean("SquareGeometry");

    Shape rectangle = (Shape) appContext.getBean("Rectangle", 10, 20);
    Geometry rectGeom = (Geometry) appContext.getBean("RectangleGeometry");

    System.out.println("Square Area = " + squareGeom.getArea(square));
    System.out.println("Rectangle Area = " + rectGeom.getArea(rectangle));

    assert(squareGeom.getArea(square) == 100);
    assert(rectGeom.getArea(rectangle) == 200);
	}
}
