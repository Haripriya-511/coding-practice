public class BubbleSort {
    public void bubbleSortAscen(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j+1]<arr[j]) {
                    swap(j, j + 1, arr);
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        System.out.println("Ascending Order:");
        for(int i:arr)
            System.out.print(i+" ");

    }
    public void bubbleSortDesc(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]) {
                    swap(j, j + 1, arr);
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        System.out.println("\nDescending Order:");
        for(int i:arr)
            System.out.print(i+" ");

    }

    private void swap(int j, int i, int[] arr) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.bubbleSortAscen(new int[]{7, 4, 1, 5, 3});
        sort.bubbleSortDesc(new int[]{7, 4, 1, 5, 3});

    }
}
/**
 *
 */
