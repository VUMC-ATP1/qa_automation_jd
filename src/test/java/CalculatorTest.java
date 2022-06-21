import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAddMethod(){
Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10.00,20.00),30.00,"Look like method has some issues");
    }
    @Test
    public void testSubtractMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sustract(30.00,10.00),20.00);
    }
    @Test
    public void testDivideMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30,10),3.00);
    }

    @Test
    public void testMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(30.00,10.00),300.00);
    }
}
