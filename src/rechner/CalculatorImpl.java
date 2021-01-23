package rechner;

import java.util.ArrayList;

public class CalculatorImpl implements Calculator {

    public static ArrayList<Integer> valuesList = new ArrayList<>();


    public static void back2Zero() throws Exception {

    }
    @Override
    public void add(int number) throws Exception {

    }

    @Override
    public void sub(int number) throws Exception {

    }


    @Override
    public String PrintSavedValue() throws Exception {

        return "hi";
    }

    @Override
    public void Undo() throws Exception {

    }

    public static int getLastInt() {
        return CalculatorImpl.valuesList.get(CalculatorImpl.valuesList.size()-1);
    }
}
