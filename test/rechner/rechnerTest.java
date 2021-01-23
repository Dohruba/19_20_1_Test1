package rechner;

import org.junit.Assert;
import org.junit.Test;

public class rechnerTest {

    private final int MAX_NUM = Integer.MAX_VALUE;
    private final int MIN_NUM = Integer.MIN_VALUE;

    private Calculator createAndBack2Zero() throws Exception {
        CalculatorImpl.back2Zero();
        return new CalculatorImpl();
    }
    private Calculator createCalculator() throws Exception{
        return new CalculatorImpl();
    }

    private void EmptyAndInitialize(){
        //Empty and initialize
        CalculatorImpl.valuesList.clear();
        CalculatorImpl.valuesList.add(0);
    }
    private void EmptyAndDoNotInitialize(){
        CalculatorImpl.valuesList.clear();

    }

    @Test
    public void goodAddTest() throws Exception {
        Calculator calcTest = createAndBack2Zero();
        calcTest.add(5);
        int lastSavedNumber = CalculatorImpl.getLastInt();
        Assert.assertEquals(5,lastSavedNumber);
        }

    @Test(expected = Exception.class)
    public void badAddTest() throws Exception{
        Calculator calcTest = createAndBack2Zero();
        calcTest.add(1);
        calcTest.add(MAX_NUM);
    }

    @Test
    public void randAddTest() throws Exception{
        Calculator calcTest = createAndBack2Zero();
        calcTest.add(MAX_NUM);
        Assert.assertEquals(MAX_NUM, CalculatorImpl.getLastInt());
    }

    @Test
    public void goodSubTest() throws Exception {
        Calculator calcTest = createAndBack2Zero();
        calcTest.sub(5);
        int lastSavedNumber = CalculatorImpl.getLastInt();
        Assert.assertEquals(-5,lastSavedNumber);
    }

    @Test(expected = Exception.class)
    public void badSubTest() throws Exception{
        Calculator calcTest = createAndBack2Zero();
        calcTest.sub(1);
        calcTest.add(MIN_NUM);
    }

    @Test
    public void randSubTest() throws Exception{
        Calculator calcTest = createAndBack2Zero();
        calcTest.sub(MIN_NUM);
        Assert.assertEquals(MIN_NUM, CalculatorImpl.getLastInt());
    }

    @Test
    public void goodPrintLastTest()throws Exception{
        Calculator calcTest = createAndBack2Zero();
        calcTest.add(5);
        Assert.assertEquals("5", calcTest.PrintSavedValue());
        calcTest.add(10);
        Assert.assertEquals("15", calcTest.PrintSavedValue());
    }

    @Test(expected = Exception.class)
    public void badPrintLastTest()throws Exception{
        Calculator calcTest = createAndBack2Zero();
        CalculatorImpl.valuesList.clear();
        //Nothing to print
        String thereIsNothingToPrint = calcTest.PrintSavedValue();

    }

    @Test
    public void randPrintLastTest()throws Exception{
        Calculator calculator = createAndBack2Zero();
        calculator.add(MAX_NUM);
        String maxInteger = String.valueOf(MAX_NUM);
        Assert.assertEquals(maxInteger, calculator.PrintSavedValue());
    }



    @Test
    public void goodUndoTest() throws Exception{
        EmptyAndInitialize();
        Calculator calculator = createCalculator();
        calculator.add(5);
        calculator.add(5);
        calculator.add(10);

        Assert.assertEquals(20, CalculatorImpl.getLastInt());
        calculator.Undo();
        Assert.assertEquals(10, CalculatorImpl.getLastInt());
        calculator.Undo();
        Assert.assertEquals(5, CalculatorImpl.getLastInt());
        calculator.Undo();
        Assert.assertEquals(0, CalculatorImpl.getLastInt());
    }

    @Test(expected = Exception.class)
    public void badUndoTest() throws Exception {
        EmptyAndInitialize();
        Calculator calculator = createCalculator();
        calculator.add(5);

        Assert.assertEquals(5, CalculatorImpl.getLastInt());
        calculator.Undo();
        Assert.assertEquals(0, CalculatorImpl.getLastInt());
        calculator.Undo();
    }
}
