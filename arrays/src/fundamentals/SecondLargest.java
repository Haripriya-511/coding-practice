package fundamentals;

import java.util.Arrays;

public class SecondLargest {
    public int secondLargestElementBrute(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int first_largest = arr[n-1];
        int second_largest = -1;
        for (int i = n-2; i >=0 ; i--) {
            if (arr[i] != first_largest) {
                second_largest = arr[i];
                break;
            }


        }

        return second_largest;
    }
    public int getSecondLargestBetter(int[] arr) {
        int n=arr.length;
        int first_largest=arr[0];
        for(int i=1;i<n;i++){
            first_largest=Math.max(first_largest,arr[i]);
        }
        int second_largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]!=first_largest){
                second_largest=Math.max(second_largest,arr[i]);
            }
        }
        return second_largest==Integer.MIN_VALUE? -1: second_largest;

    }
    public int getSecondLargestOptimal(int[] arr) {

        int n = arr.length;
        int first_largest = arr[0];
        int second_largest = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > first_largest) {
                second_largest = first_largest;
                first_largest = arr[i];
            }
            if (arr[i] != first_largest && arr[i] > second_largest)
                second_largest = arr[i];

        }

        return second_largest;
    }

    public static void main(String[] args) {
        int arr[]={-235,-535,-457,-35,-568,-456,-3};
        new SecondLargest().getSecondLargestOptimal(arr);
    }
}
