package array;

import java.util.*;

public class SparseVectors {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<Integer>(Arrays.asList(new Integer[]{1,0,0,2,0,3,0}));
        Vector<Integer> v2 = new Vector<Integer>(Arrays.asList(new Integer[]{2,0,3,4,0,5,6}));

        System.out.println("getSparseVectorsMultiplication(v1, v2) = " + getSparseVectorsMultiplication(v1, v2));
    }

    public static int getSparseVectorsMultiplication(Vector<Integer> v1, Vector<Integer> v2) {
        if ((null == v1 || v1.isEmpty()) || ((null == v2 || v2.isEmpty()))) {
            return 0;
        }

        Map<Integer, Integer> map1 = getMapFromVector(v1);
        Map<Integer, Integer> map2 = getMapFromVector(v2);

        Map<Integer, Integer> tempMap = null;
        if (map1.size() > map2.size()) {
            tempMap = map2;
            map2 = map1;
            map1 = tempMap;
        }

        int result = 0;
        // map1 will always have fewer or equal elements than map2
        for (int key : map1.keySet()) {
            Integer num = map2.get(key);
            if (num != null) {
                result += (num * map1.get(key));
            }
        }

        return result;
    }

    private static Map<Integer, Integer> getMapFromVector(Vector<Integer> v) {
        if (null == v || v.isEmpty()) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        for (int n : v) {
            if (n != 0) {
                map.put(key, n);
            }
            key++;
        }
        return map;
    }
}
