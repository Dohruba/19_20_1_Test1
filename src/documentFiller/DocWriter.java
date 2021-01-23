package documentFiller;

import java.io.IOException;

public interface DocWriter {
    void writeOnFile(String filename) throws IOException;
}