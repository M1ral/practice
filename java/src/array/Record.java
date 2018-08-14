package array;

public class Record implements Comparable<Record> {
    int num;
    int count;

    public Record(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int compareTo(Record other) {
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