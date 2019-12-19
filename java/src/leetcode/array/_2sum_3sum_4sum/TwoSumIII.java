package leetcode.array._2sum_3sum_4sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    public static void main(String[] args) {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(1);
        twoSumIII.add(1);
        twoSumIII.add(2);
        twoSumIII.add(3);
        twoSumIII.add(4);
        System.out.println("twoSumIII.find(6) = " + twoSumIII.find(6));
    }

    Map<Integer, Integer> map;

    public TwoSumIII() {
        this.map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        if (null == map || map.isEmpty()) {
            return false;
        }

        for (int key : map.keySet()) {
            int target = value - key;
            if (map.containsKey(target)) {
                if (key == target && map.get(key) < 2) {
                    continue; // ignore same number
                }
                return true;
            }
        }
        return false;
    }
}
