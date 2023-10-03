import jdk.jfr.Description;
import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GradeTest {
    @DataProvider (name = "gradeData")
    public Object[][] data(){
        return new Object[][]{
                {100,"Excellent"},
                {-1,"Invalid"},
        };
    }


    @Test(dataProvider = "gradeData")
    public void
    testGrade(int mark, String expected){
        Calculator calculator= new Calculator();
        Assert.assertEquals(calculator.getGrade(mark), expected);
    }


}
