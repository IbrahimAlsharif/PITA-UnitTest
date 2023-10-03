import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnTest {

    @BeforeClass
    public void printStatus(){
        System.out.println("Class is started");
    }
@BeforeMethod
public void beforeMethod(ITestResult result){
    System.out.println(result.getMethod().getMethodName()+" Started");
}
@AfterMethod
public void afterMethod(ITestResult result){
    System.out.println(result.getMethod().getMethodName()+" Finished");
}


    @Test(priority = 1)
    public void testMultiplication(){
        Assert.assertTrue(5==5);
    }

    @Test(priority = 2)
    public void testDivision(){
        Assert.assertTrue(5==5);
    }

    @Test(priority = 3)
    public void testZivision(){
        Assert.assertTrue(5==5);
    }
}
