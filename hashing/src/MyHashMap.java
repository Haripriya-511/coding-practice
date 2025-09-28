import java.util.*;
public class MyHashMap
{
    private final int SIZE = 1000;
    private List<int[]>[] buckets;
    private int currSize=0;

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int hashCode= key % SIZE;
        List<int[]>  bucket=buckets[hashCode];
        int sizeOfList= bucket.size();
        for (int i = 0; i < sizeOfList; i++) {
            if (bucket.get(i)[0] == key) {
                bucket.get(i)[1] = value;
                return;
            }
        }
        bucket.add(new int[]{key,value});

    }

    public int get(int key) {
        int hashCode= key % SIZE;
        List<int[]>  bucket=buckets[hashCode];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i)[0] == key) {
                return bucket.get(i)[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashCode= key % SIZE;
        List<int[]>  bucket=buckets[hashCode];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i)[0] == key) {
                bucket.remove(i);
                return;
            }
        }
    }
}
// leetcode 706
