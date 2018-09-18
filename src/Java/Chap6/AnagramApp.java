import java.util.ArrayList;
import java.util.List;

class Anagram {
    private char[] str;
    private int size;
    int count;
    private List<String> anagramList;

    Anagram(String string) {
        str = string.toCharArray();
        size = str.length;
        count = 0;
        anagramList = new ArrayList<>();
    }

    Anagram doAnagram(int size) {
        if (size == 1)
            return this;
        for (int i = 0; i < size; i++) {
            doAnagram(size - 1);
            if (size == 2)
                setAnagramList();
            rotate(size);
        }
        return this;
    }

    private void rotate(int size) {
        int i;
        int pos = this.size - size;
        char temp = str[pos];
        for (i = pos + 1; i < this.size; i++)
            str[i - 1] = str[i];
        str[i - 1] = temp;
    }

    public List<String> getAnagramList() {
        return anagramList;
    }

    private void setAnagramList() {
        count++;
        anagramList.add(String.valueOf(str));
    }
}

public class AnagramApp {
    public static void main(String[] args) {
        Anagram anagram = new Anagram("CAT").doAnagram(3);
        List<String> list = anagram.getAnagramList();
        for (String l : list) {
            System.out.println(l);
        }
    }
}
