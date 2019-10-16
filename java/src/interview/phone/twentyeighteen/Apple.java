package interview.phone.twentyeighteen;

public class Apple {

    public static void main(String[] args) {
        //Iterator<Integer> ints  = Iterator(1,2,3,4,5);

    }

}

class Iterators {


    public static <F, T> Iterator<T> map(Iterator<T> iterator, Function<T, F> mapper) {
        if (null == iterator || null == mapper) {
            return null;
        }

        while(iterator.hasNext()) {
            T value = iterator.next();
            mapper.apply();
        }

        return null;
    }

    // empty leetcoce.iterator
    public static <T> Iterator<T> empty() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    // one value Iterator
    public static <T> Iterator<T> one(T value) {
        //return Arrays.asList(value).leetcoce.iterator();
        return null;
    }
}

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface Function<T, F> {
    F apply();
}