package IO;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class IOManager {

    private final String inName = "in.txt";
    private final String outName = "out.txt";
    private final Reader reader = new Reader(inName);
    private final Writer writer = new Writer(outName);
    //private LinkedList<String> stack = new LinkedList<String>();
    private Deque<String> stack = new ArrayDeque<>();

    private void readLine() throws IOException {
        String words = reader.readString();
        if(words != null)
            for(String word : Pattern.compile("[^A-zА-я]+").matcher(words).replaceAll(" ").split(" "))
                stack.addLast(word);
    }

    public String readWord() throws IOException {
        if(stack.isEmpty())
            readLine();
        if(!stack.isEmpty())
            return stack.removeFirst();
        else {
            reader.close();
            return null;
        }
    }

    public void println(String text) throws IOException {
        writer.println(text);
    }

    public void writeList(List<String> text) throws IOException {
        for(String line: text)
            println(line);
        writer.close();
    }

}
