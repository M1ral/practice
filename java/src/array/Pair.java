package array;

public class Pair implements Comparable<Pair> {
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int compareTo(Pair other) {
        return this.count - other.count;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}