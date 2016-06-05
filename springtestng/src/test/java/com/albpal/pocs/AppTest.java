package com.albpal.pocs;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.*;

@ContextConfiguration("classpath:spring-config.xml")
public class AppTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private App app;

    @Test
    public void testAmazingFunction()
    {
      assertEquals(app.amazingFunction(), "All right");
    }
}
