package hard;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
              nums1[k--]=nums1[i--];
            }
            else
                nums1[k--]=nums2[j--];
        }
        while(j>=0)
            nums1[k--]=nums2[j--];
    }
    public static void mergeTypeIINaive(int[] nums1, int m, int[] nums2, int n) {
       int i=0,j=0;
       while(i<m && j<n){
           if(nums1[i]>nums2[j]){
               int temp=nums1[i];
               nums1[i]=nums2[j];
               nums2[j]=temp;
               Arrays.sort(nums2);

           }
           else{
               i++;
           }
       }
       for(int ii:nums1) System.out.print(ii+" ");
       for(int jj:nums2) System.out.print(jj+" ");
    }
    public static void mergeTypeIIBetter(int[] nums1, int m, int[] nums2, int n) {
        int i =m-1, j = 0;
        while (i >=0  && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;

            } else {
                break;
            }
        }
        Arrays.sort(nums1); Arrays.sort(nums2);
        for (int ii : nums1) System.out.print(ii + " ");
        for (int jj : nums2) System.out.print(jj + " ");
    }
    public static void swap(int[] arr1, int[] arr2, int i, int j){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2); // ceil(gap/2)
    }
    public static void mergeTypeIIOptimal(int[] nums1, int m, int[] nums2, int n) {
       int gap=nextGap(m+n);
       int total=m+n;
       while(gap>0){
           int left=0;
           int right= gap+left;
           while(right<total){
                if(left<m && right>=m){
                 if(nums1[left]>nums2[right-m])
                     swap(nums1,nums2,left,right-m);
                }
                else if(left>=m){
                    if(nums2[left-m]>nums2[right-m]){
                        int temp = nums2[left - m];
                        nums2[left - m] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }
                else{
                    if(nums1[left]>nums1[right]){
                        int temp=nums1[left];
                        nums1[left]=nums1[right];
                        nums1[right]=temp;
                    }

                }
               left++;
               right++;
           }


           gap=nextGap(gap);
       }



        for (int ii : nums1) System.out.print(ii + " ");
        for (int jj : nums2) System.out.print(jj + " ");
    }

    public static void main(String[] args) {
        int n1[]={1,3,5,0,0,0,0};
        int n2[]={2,4,6,7};
        merge(n1,3,n2,4);


        int arr1[]={-5,-2,4,5};
        int arr2[]={-3,1,8};
        mergeTypeIINaive(arr1,4,arr2,3);
        mergeTypeIIBetter(arr1,4,arr2,3);
        mergeTypeIIOptimal(arr1,4,arr2,3);

    }
}
