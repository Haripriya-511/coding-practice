package problems;

import java.util.*;

public class GroupAnaGRAMS {
    // with sorting
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
           char[] ch= str.toCharArray();
           Arrays.sort(ch);
            String key=new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    //without sorting
    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
           int count[]=new int[26];
           for(char ch:str.toCharArray()){
               count[ch-'a']++;
           }
           String key= Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {


    }
}
