package rechner;

public interface Calculator {

    void add(int number) throws Exception;

    void sub(int number) throws Exception;

    String PrintSavedValue() throws Exception;

    void Undo() throws Exception;
}
