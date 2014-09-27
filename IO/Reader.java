package IO;

import java.io.*;
import java.util.*;

public class Reader {

    private String fileName;
    private boolean isOpen = false;
    BufferedReader reader;

    Reader() { }
    Reader(String fileName) {
        setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void open() throws FileNotFoundException {
        if(fileName != null) {
            reader = new BufferedReader(new FileReader(new File(fileName)));
            //reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "UTF-8"));
            //new Scanner(fileName);
            isOpen = true;
        }
    }

    public String readString() throws IOException {
        if(!isOpen) open();
        return isOpen ? reader.readLine() : null;
    }

    public void close() throws IOException {
        reader.close();
    }

}
