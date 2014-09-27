package IO;

import java.io.*;

public class Writer {

    private String fileName;
    private boolean isOpen = false;
    private PrintWriter writer;

    Writer() { }
    Writer(String fileName) {
        setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void open() throws IOException {
        if(fileName != null) {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            //writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)))));
            isOpen = true;
        }
    }

    public void println(String text) throws IOException {
        if(!isOpen) open();
        writer.println(text);
    }

    public void close() {
        writer.flush();
        writer.close();
        isOpen = false;
    }

}
