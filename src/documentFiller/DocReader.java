package documentFiller;

import java.io.IOException;

public interface DocReader {

    /**
     * Reads information from the specified file and creates the memory at the start of the program
     * @param filename
     * @throws IOException if File not found
     */
    void readFromFile(String filename) throws IOException;
}
