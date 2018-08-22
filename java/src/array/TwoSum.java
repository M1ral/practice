package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    private List<Integer> data;

    public TwoSum() {
        data = new ArrayList<>();
    }

    public void add(int n) {
        data.add(n);
    }

    public boolean find(int target) {
        return isTwoSum(target);
    }

    private boolean isTwoSum(int target) {
        if (null == data || data.size() < 2) {
            return false;
        }

        Map<Integer, Integer> dataMap = new HashMap<>();
        int i = 0;

        for (int n : data) {
            if (dataMap.containsKey(n)) {
                return true;
            } else {
                dataMap.put(target - n, i);
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        // test
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println("twoSum.find(4) = " + twoSum.find(4));
        System.out.println("twoSum.find(7) = " + twoSum.find(7));
    }
}
