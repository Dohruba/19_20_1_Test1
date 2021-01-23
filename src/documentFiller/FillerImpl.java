package documentFiller;


import rechner.CalculatorImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;

//Modifiyiert von mein eigenes Code in https://github.com/Dohruba/19_2_Test1/tree/master/src/documentFiller

public class FillerImpl implements DocReader, DocWriter {
    @Override
    public void readFromFile(String filename) throws IOException {
        String readString;
        String[] productInfo;
        String productName;
        int price;

        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        do {
            readString = br.readLine();
            if (readString == null) break;
            int value = Integer.parseInt(readString);
            CalculatorImpl.valuesList.add(value);

        }while (!readString.isBlank());
    }



    @Override
    public void writeOnFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        for (int i = 0; i< CalculatorImpl.valuesList.size(); i++){
            String toAdd = String.valueOf(CalculatorImpl.valuesList.get(i)) + "\n";
            byte[] valueBytes = (toAdd.getBytes(StandardCharsets.UTF_8));
            fos.write(valueBytes);
        }
        fos.close();

    }
}
