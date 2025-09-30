package problems.prefix;
import java.util.*;
public class ProductOfLastK {

}
//optimal
/*
Idea: Use prefix products to avoid recomputing products every time.

Keep a running product in list such that:

list[i] = product of all numbers up to i.

Then,

product of last k = list[n-1] / list[n-k-1]


Handling Zeroes:

When a zero is added, reset the prefix list to [1].

This way, any query that “crosses” the zero automatically returns 0 (because k >= n after reset).

Time Complexity:

add() → O(1)

getProduct(k) → O(1)

✅ Much faster than brute force.5
 */
class ProductOfNumbers {
    public List<Integer> list;
    int lastZeroIndex=-1;
    public ProductOfNumbers() {
        list=new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if(num==0){
            lastZeroIndex=list.size()-1;
            list = new ArrayList<>();
            list.add(1);
            return;
        }
        int n=list.size();
        list.add(list.get(n-1)*num);
    }

    public int getProduct(int k) {
        int n=list.size();
        if(k >= n) return 0;
        return list.get(n-1) / list.get(n-k-1);


    }
}
//Brute
/*
Data structure: Just stores all numbers in a list.

add(num) → append num to the list.

getProduct(k) → iterate over the last k elements and multiply.

Time Complexity:

add() → O(1)

getProduct(k) → O(k)

❌ Slow if k is large and many queries are made.
 */
class ProductOfNumbersII {
    public List<Integer> list;

    public ProductOfNumbersII() {
        list=new ArrayList<>();

    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int prod=1;
        int n=list.size();
        for(int i=0;i<k;i++){
            prod*=(list.get(n-i-1));
        }
        return prod;
    }
}
