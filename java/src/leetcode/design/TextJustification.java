package leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/text-justification/
public class TextJustification {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).toArray()));
        System.out.println(Arrays.toString(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16).toArray()));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (null == words || words.length == 0 || maxWidth < 1) {
            return Collections.emptyList();
        }

        List<String> levels = new ArrayList<>();
        StringBuilder levelStr = new StringBuilder();
        String line = "";
        int numWords = 0;

        for (String word : words) {
            if (levelStr.length() + 1 + word.length() <= maxWidth) {
                levelStr.append(word).append(" ");
                numWords++;
                continue;
            }
            line = levelStr.toString().substring(0, levelStr.length() - 1);
            levels.add(rearrange(line, maxWidth, numWords));

            levelStr = new StringBuilder(word).append(" ");
            numWords = 1;
        }
        line = levelStr.toString().substring(0, levelStr.length() - 1);
        levels.add(rearrange(line, maxWidth, numWords));

        for (String level : levels)
            System.out.println(level);

        return levels;
    }

    private static String rearrange(String line, int maxWidth, int numWords) {
        if (null == line || line.isEmpty() || maxWidth < 1) {
            return line;
        }

        String[] wordsSplit = line.split(" ");
        List<StringBuilder> sbList = new ArrayList<>();
        int wordsLength = 0;

        int i = 0;
        StringBuilder lastWord = null;
        for (String word : wordsSplit) {
            if (i == wordsSplit.length - 1)
                lastWord = new StringBuilder(word);
            else {
                sbList.add(new StringBuilder(word));
            }
            wordsLength += word.length();
            i++;
        }

        int numSpaces = maxWidth - wordsLength;

        StringBuilder sb = new StringBuilder();
        if (sbList.size() == 0) {
            while (numSpaces != 0) {
                lastWord.append(" ");
                numSpaces--;
            }
            return lastWord.toString();
        }

        while (numSpaces != 0) {
            for (StringBuilder s : sbList) {
                if (numSpaces == 0 ) {
                    break;
                }
                s.append(" ");
                numSpaces--;
            }
        }

        for (StringBuilder word : sbList)
            sb.append(word.toString());

        return sb.append(lastWord).toString();
    }
}
