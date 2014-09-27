import IO.IOManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CollectionsTest {

    private static TreeMap<String, Integer> fillArray(IOManager files) throws IOException {
        TreeMap<String, Integer> array = new TreeMap<>();
        Integer count;
        String word = files.readWord();
        while(word != null) {
            word = word.toLowerCase();
            count = array.get(word);
            array.put(word, count == null ? 1 : ++count);
            word = files.readWord();
        }
        return array;
    }

    private static List<Map.Entry<String,Integer>> sortArray(TreeMap<String, Integer> array) {
        List<Map.Entry<String,Integer>> list = new ArrayList(array.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
                @Override
                public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            }
        );
        return list;
    }

    public static void main(String[] args) {
        try {

            IOManager files = new IOManager();
            TreeMap<String, Integer> array = fillArray(files);
            List<Map.Entry<String, Integer>> list = sortArray(array);
            List<String> stringList = new ArrayList<>();
            list.forEach(e -> stringList.add(e.getKey() + " " + e.getValue()));
            files.writeList(stringList);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + System.getProperty("user.dir") + "\\in.txt' doesn't exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}