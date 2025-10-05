package problems.prefix;

import java.util.*;
class MyCalendarIIBrute
{
    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendarIIBrute()
    {
        calendar=new ArrayList<>();
        overlaps=new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for(int[] o:overlaps){
            if(Math.max(start,o[0])<Math.min(end,o[1]))
                return false;
        }
        for(int[] c:calendar){
            int s=Math.max(start,c[0]);
            int e=Math.min(end,c[1]);
            if(s<e){
                overlaps.add(new int[]{s,e});
            }
        }

        calendar.add(new int[]{start,end});
        return true;
    }
}

public class MyCalendarII
{
    TreeMap<Integer,Integer> map;
    public MyCalendarII() {
        map=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int ongoing = 0;
        for (int count : map.values()) {
            ongoing += count;
            if (ongoing > 2) {  // Triple booking detected
                // Undo the booking
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                // Clean-up if count becomes 0
                if (map.get(start) == 0) map.remove(start);
                if (map.get(end) == 0) map.remove(end);
                return false;
            }
        }
        return true;
    }
}
