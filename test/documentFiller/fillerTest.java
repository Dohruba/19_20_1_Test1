package documentFiller;

//https://github.com/Dohruba/19_2_Test1/tree/master/test/documentFiller

import org.junit.Assert;
import org.junit.Test;
import rechner.Calculator;
import rechner.CalculatorImpl;

public class fillerTest {

    private Calculator createCalculator() throws Exception{
        return new CalculatorImpl();
    }

    private void EmptyAndInitialize(){
        //Empty and initialize
        CalculatorImpl.valuesList.clear();
        CalculatorImpl.valuesList.add(0);
    }

    @Test
    public void writeReadTest() throws Exception {
        EmptyAndInitialize();
        Calculator calculator = createCalculator();

        calculator.add(5);
        calculator.add(12);
        calculator.sub(3);
        calculator.add(2);

        DocWriter writer = new FillerImpl();
        DocReader reader = new FillerImpl();

        writer.writeOnFile("Test.txt");
        Thread.sleep(2000);
        CalculatorImpl.valuesList.clear();
        reader.readFromFile("Test.txt");

        Assert.assertEquals(CalculatorImpl.valuesList.size(), 5);
        Assert.assertEquals(CalculatorImpl.getLastInt(),16);

    }
    @Test(expected = Exception.class)
    public void badWriteTest() throws Exception {
        EmptyAndInitialize();
        Calculator calculator = createCalculator();

        calculator.add(5);
        calculator.add(12);
        calculator.sub(3);
        calculator.add(2);

        DocWriter writer = new FillerImpl();
        //Wrong Filename
        writer.writeOnFile("Test");
    }

    @Test
    public void randTest() throws Exception{
        EmptyAndInitialize();
        Calculator calculator = createCalculator();

        //Only one value. 0
        DocWriter writer = new FillerImpl();
        writer.writeOnFile("Test.txt");

        DocReader reader = new FillerImpl();
        CalculatorImpl.valuesList.clear();
        reader.readFromFile("Test.txt");

        Assert.assertEquals(0,CalculatorImpl.getLastInt());
        Assert.assertEquals(1,CalculatorImpl.valuesList.size());

    }
}
