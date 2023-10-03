import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleTest {

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
                {10.0f, 0.0f}
        };
    }

    @Test(dataProvider = "Valid Division Data")
    public void testValidInputs(float x, float y, float expected) {
        Calculator calculator= new Calculator();
        Assert.assertEquals(calculator.division(x, y),expected);
    }

    @Test(dataProvider = "Invalid Division Data")
    public void testInvalidInputs(float x, float y){
    try{
        new Calculator().division(x,y);}
    catch (ArithmeticException e){
        System.out.println(e.getClass());
        Assert.assertEquals(e.getClass(),ArithmeticException.class);
    }
    }

}
