import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {

    @DataProvider(name = "Valid Division Data")
    public Object[][] dpMethod() {
        return new Object [][] {
                {10.0f, 2.0f, 5.0f},
                {-10.0f, 2.0f, -5.0f}
        };
    }
    @DataProvider(name = "Invalid Division Data")
    public Object[][] dppMethod() {
        return new Object [][] {
                {10,0},
                {-10.0f,0.0f}
        };
    }

    @Test(dataProvider = "Valid Division Data")
    public void testValidInputs(float x, float y, float expected) {
        Calculator calculator= new Calculator();
        Assert.assertEquals(calculator.division(x, y),expected);
    }

    @Test(dataProvider = "Invalid Division Data", expectedExceptions = ArithmeticException.class)
    public void testDivideByZero(float x, float y){
        Calculator calculator= new Calculator();
        calculator.division(x,y);
    }

}
