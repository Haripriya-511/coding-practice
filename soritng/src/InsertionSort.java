public class InsertionSort {
    public void insertionSort(int arr[]) {
        int n=arr.length;

        for(int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        System.out.println("\nAscending Order:");
        for(int i:arr)
            System.out.print(i+" ");

    }//>

    /**
     * here “Can insertion sort be optimized?”, you can say:
     *
     * Binary Insertion Sort – use binary search for position → fewer comparisons (O(n log n)), still O(n²) due to shifts.
     * @param arr
     *
     */
    public void insertionSortOptimizedBinaryInsertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            int position = binarySearch(arr, 0, j, key);
            while (j >= position) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[position] = key;
        }
        System.out.println("\nBinary Insertion Sort");
        for(int i:arr)
            System.out.print(i+" ");
    }

    private int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public void insertionSortDesc(int arr[]) {
        int n=arr.length;

        for(int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && temp>arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;

        }
        System.out.println("\nDescending Order:");
        for(int i:arr)
            System.out.print(i+" ");

    }


    public static void main(String[] args) {
        InsertionSort sort=new InsertionSort();
        sort.insertionSort(new int[]{4,1,3,9,7});
        sort.insertionSortOptimizedBinaryInsertionSort(new int[]{1,2,3,4,5});
        sort.insertionSortDesc(new int[]{1,2,3,4,5});

    }
}
//

