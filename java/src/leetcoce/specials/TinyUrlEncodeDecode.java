package leetcoce.specials;

import java.util.HashMap;
import java.util.Map;

public class TinyUrlEncodeDecode {

    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String BASE = "http://tinyurl.com/";

    private static Map<String, String> keyToURL = new HashMap<>();
    private static Map<String, String> urlToKey = new HashMap<>();

    public static void main(String[] args) {
        String tinyURL = encode("http://thisislongurl.com/abcd/123");
        String tinyURL2 = encode("http://thisislongurl.com/abcd/123");
        String longURL = decode(tinyURL);
        String longURL2 = decode(tinyURL2);

        System.out.println("tinyURL = " + tinyURL);
        System.out.println("tinyURL2 = " + tinyURL2);
        System.out.println("longURL = " + longURL);
        System.out.println("longURL2 = " + longURL2);
    }

    public static String encode(String longUrl) {
        if (longUrl == null || longUrl.isEmpty()) {
            return null;
        }
        if (urlToKey.containsKey(longUrl)) {
            return BASE + urlToKey.get(longUrl);
        }

        StringBuilder key = null;

        // keep generating keys until a unique one is found
        do {
            key = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int)(Math.random() * SEED.length());
                key.append(SEED.charAt(r));
            }
        } while (keyToURL.containsKey(key));

        keyToURL.put(key.toString(), longUrl);
        urlToKey.put(longUrl, key.toString());

        return BASE + key;
    }

    public static String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.isEmpty()) {
            return "";
        }
        String[] shortUrlSplits = shortUrl.split("/");
        return keyToURL.get(shortUrlSplits[shortUrlSplits.length - 1]);
    }
}
