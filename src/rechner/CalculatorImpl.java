package rechner;

import java.util.ArrayList;

public class CalculatorImpl implements Calculator {

    public static ArrayList<Integer> valuesList = new ArrayList<>();


    public static void back2Zero() throws Exception {

        valuesList.add(0);
    }
    @Override
    public void add(int number) throws Exception {
        if (getLastInt()>0 && number > 0 && getLastInt()+number<0) throw new Exception("Overflow");
        if (getLastInt()<0 && number < 0 && getLastInt()+number>0) throw new Exception("Overflow");
        valuesList.add(getLastInt()+number);
    }

    @Override
    public void sub(int number) throws Exception {
        if (getLastInt()>0 && number < 0 && getLastInt()-number<0) throw new Exception("Overflow");
        if (getLastInt()<0 && number > 0 && getLastInt()+number>0) throw new Exception("Overflow");
        valuesList.add(getLastInt() - number);

    }


    @Override
    public String PrintSavedValue() throws Exception {

        return String.valueOf(getLastInt());
    }

    @Override
    public void Undo() throws Exception {
        if (valuesList.size() == 1) throw new Exception("All operations have been undone. Actual value 0");
        valuesList.remove(valuesList.size()-1);
    }

    public static int getLastInt() {
        return CalculatorImpl.valuesList.get(CalculatorImpl.valuesList.size()-1);
    }
}
