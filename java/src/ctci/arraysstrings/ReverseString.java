package ctci.arraysstrings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("reverse(\"Miral\") = " + reverse("Miral"));
        System.out.println("reverse(\"Shreya\") = " + reverse("Shreya"));
        System.out.println("reverse(\"Apple\") = " + reverse("Apple"));
        System.out.println("reverse(\"leetcode\") = " + reverse("leetcode"));
        System.out.println("reverse(\"leetcode\") = " + reverse("aba"));
    }

    public static String reverse(String s) {
        if (null == s || s.isEmpty()) {
            return s;
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length()/2; i++) {
            int end = s.length() -i -1;
            int start = i;

            char temp = s.charAt(end);
            sChars[end] = s.charAt(start);
            sChars[start] = temp;
        }

        return new String(sChars);
    }
}
