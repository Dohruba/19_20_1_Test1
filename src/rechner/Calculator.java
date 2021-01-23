package rechner;

public interface Calculator {

    /**
     * Adds a number to the last in memory
     * @param number
     * @throws Exception by Overflow
     */
    void add(int number) throws Exception;

    /**
     * Substracts one number from the last in memory
     * @param number
     * @throws Exception by Overflow
     */
    void sub(int number) throws Exception;

    /**
     * Outputs the last saved Number
     * @return the last number
     * @throws Exception if list is empty
     */
    String PrintSavedValue() throws Exception;

    /**
     * Undos the las operation
     * @throws Exception If there is nothing to undo
     */
    void Undo() throws Exception;
}
