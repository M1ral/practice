package leetcode.graph;

// https://leetcode.com/problems/find-the-celebrity/
public class FindCelebrity extends Relation {

    public static void main(String[] args) {
        FindCelebrity fc = new FindCelebrity();
        System.out.println("findCelebrity(3) = " + fc.findCelebrity(3));
    }

    public int findCelebrity(int n) {
        if (n <= 0) {
            return 0;
        }
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i; // swap candidate
            }
        }

        // verify candidate
        for (int i = 0; i < n; i++) {
            if (candidate == i) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}

// Temp implementation to match leetcode problem statement
class Relation {
    public boolean knows(int a, int b) {
        return true;
    }
}
