package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;
import practise.CalculatorForHome;

public class CalculatorForHomeTest {
   CalculatorForHome calculator;

   @BeforeSuite
   public void initCalculatorObject() {
      calculator = new CalculatorForHome();
   }

   @BeforeTest
   public void beforeCalculatorTest() {
      System.out.println("Calculator testing started");
   }

   @BeforeMethod
   public void beforeMethod() {
      System.out.println("Testing started");
   }

   @Test
   public void testAddMethod() {
      Assert.assertEquals(calculator.add(6, 7), 13);
   }

   @Test
   public void subtractMethod() {
      Assert.assertEquals(calculator.substract(7, 3), 4);
   }

   @Test
   public void multiplyMethod() {
      Assert.assertEquals(calculator.multiply(5, 5), 25);
   }

   @Test
   public void divideMethod() {
      Assert.assertEquals(calculator.divide(16, 8), 2);
   }

   @AfterMethod
   public void afterAddMethod() {
      System.out.println("Testing finished");
   }


}
