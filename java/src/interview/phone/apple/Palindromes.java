package interview.phone.apple;

public class Palindromes {
    public static String[] candidates = {
            // Valid
            "zzracecar",
            "Kayak",
            "never odd or even",
            "rats live on no evil star",
            "A Toyota! Race fast... safe car: a Toyota",
            "Some men interpret nine memos",
            "     Some men interpret nine memos     ",
            "    ",
            null,
            // Invalid
            "wombat",
            "No lemons, one melon", // lemons, one->lemon, no
            "Too bad – I hid a book", // book->boot
            "No trace; not one cartoon", // cartoon->carton
            "Ma'am, I'm Adam", // Ma'am->Madam
            "Del was a sled", // was->saw
            "Flee to Em, remote elf", // Em->me
            "Ma? Ha! A sham!" // Ha! A sham->Has a ham
    };

    public static double palindromeQuality(String candidate) {
        return 0.0;
    }

    public static Boolean isPalindrome(String candidate) {
        if (null == candidate || candidate.isEmpty()) {
            return true;
        }

        candidate = candidate.toLowerCase();
        int l = 0, r = candidate.length() - 1;

        while (l <= r) {
            // handle special case characters
            char left = candidate.charAt(l);
            while (l < r && !(left >= 'a' && left <= 'z')) {
                l++;
                left = candidate.charAt(l);
            }

            char right = candidate.charAt(r);
            while (l < r && !(right >= 'a' && right <= 'z')) {
                r--;
                right = candidate.charAt(r);
            }

            // if character do not match, return false
            if (candidate.charAt(l) != candidate.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        for (String candidate : candidates) {
            System.out.println(candidate + ": " + isPalindrome(candidate));
        }
    }
}
