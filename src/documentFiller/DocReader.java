package documentFiller;

import java.io.IOException;

public interface DocReader {

    void readFromFile(String filename) throws IOException;
}
