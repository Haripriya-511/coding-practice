package problems.prefix;

public class CarPooling {
    // brute
    public boolean carPooling(int[][] trips, int capacity) {
   int count[]=new int[1001];
   for(int[] trip:trips){
       for(int i=trip[1];i<trip[2];i++){
           count[i]+=trip[0];
           if(count[i]>capacity)
               return true;
       }
   }
   return false;

    }
    public boolean carPoolingII(int[][] trips, int capacity) {
        int[] hash=new int[1002];
        int maxi=0;
        for(int i=0;i<trips.length;i++){
            int passengers=trips[i][0];
            int from=trips[i][1];
            int to=trips[i][2];
            if(passengers>capacity)
                return false;
            hash[from]+=passengers;
            hash[to]-=passengers;
            maxi=Math.max(maxi,to);
        }
        for(int i=1;i<maxi;i++){
            hash[i]+=hash[i-1];
            if(hash[i]>capacity) return false;
        }
        return true;


    }
    public static void main(String[] args) {
        int[][] trips={{9,0,1},{3,3,7}};
        int capacity=4;
        System.out.println(new CarPooling().carPooling(trips,capacity));
      //  System.out.println(new CarPooling().carPooling(trips,5));



    }
}
