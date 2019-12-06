package interview.phone.linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Product {
    int rating;
    long key; // unique key
    String name;
}

interface DataSource {
    // get product
    Product get (long key);
}

public class ProductCache {
    // priority queue to maintain cache
    private PriorityQueue<Product> pq = null;
    private Map<Long, Product> cache = null;
    private DataSource ds = null;
    private int cacheCapacity = 0;

    public ProductCache(DataSource ds, int capacity) {
        this.cacheCapacity = capacity;
        this.ds = ds;
        this.cache = new HashMap<>();
        this.pq = new PriorityQueue<Product>(capacity, (p1, p2) -> (p1.rating - p2.rating));
    }

    // get Product from cache
    public Product get(long key) {
        Product product = null; // result product
        if (cache.containsKey(key)) {
            product = cache.get(key);
        } else {
            // find the key in data source
            product = ds.get(key);
            if (null != product) {
                cache.put(key, product);
            }
        }

        if (null == product) {
            return null; // or throw exception
        }

        // update the cache
        if (cache.size() == this.cacheCapacity) {
            if (pq.peek().rating < product.rating)  {
                // remove en element with the lowest rating from cache
                Product toRemove = pq.remove();
                cache.remove(toRemove.key);
            }
        }

        // add product to cache
        pq.offer(product);
        return product;
    }
}