package leetcode.string;

import java.util.*;

// https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderLogs {

    public static void main(String[] args) {
        System.out.println("reorderLogFiles(\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\",\"let2 own kit dig\",\"let3 art zero\"})) = " +
                Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }

    public static String[] reorderLogFiles(String[] logs) {
        if (null == logs || logs.length == 0) {
            return new String[]{};
        }

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si + 1);
                char s2fc = s2.charAt(s2si + 1);

                // digit log
                if (s1fc <= '9') {
                    if (s2fc <= '9') return 0;
                    else return 1;
                }
                if (s2fc <= '9') return -1;

                // letter log
                int cmp = s1.substring(s1si + 1)
                        .compareTo(s2.substring(s2si + 1));

                if (cmp == 0)
                    return s1.substring(0, s1si)
                            .compareTo(s2.substring(0, s2si));

                return cmp;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
