package fundamentals;

public class ReverseWords {
    public void reverse(char []nums,int start,int end){
        while(start<end){
            char temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void reverseWords(char[] s) {
        int n=s.length;
        reverse(s,0,n-1);
        int i=0;
        int j=0;
        while(i<n){
            while(i<n && s[i]!=' '){
                i++;
            }
            reverse(s,j,i-1);
            j=i+1;
            i++;


        }
    }
}
