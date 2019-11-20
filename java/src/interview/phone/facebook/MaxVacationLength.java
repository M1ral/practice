package interview.phone.facebook;

// similar to https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxVacationLength {

    public static void main(String[] args) {
        System.out.println("maxVacationLength({true, false, false, true, true, true, false, false}, 2) = " +
                maxVacationLength(new boolean[]{true, false, false, true, true, true, false, false}, 2));
    }

    /**
     * Given pto and year array, find max vacation length one can take
     * in boolean array year: true is a paid holiday, false where we can take pto
     *
     * @param year boolean array of days
     * @param pto number of pto one can take
     * @return max vacation length
     */
    public static int maxVacationLength(boolean[] year, int pto) {
        if (null == year || year.length == 0) {
            return 0;
        }

        int max = 0, ptoCount = 0, start = 0;

        for (int end = 0; end < year.length; end++) {
            if (!year[end]) {
                ptoCount++;
            }

            // if ptoCount > pto, then drop the earliest pto taken
            if (ptoCount > pto) {
                if (!year[start]) {
                    ptoCount--;
                }
                start++;
            }

            // at this point, we have a valid vacation
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}

