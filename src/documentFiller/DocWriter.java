package documentFiller;

import java.io.IOException;

public interface DocWriter {

    /**
     * Writes information on the specified file
     * @param filename
     * @throws IOException if File not found
     */
    void writeOnFile(String filename) throws IOException;
}