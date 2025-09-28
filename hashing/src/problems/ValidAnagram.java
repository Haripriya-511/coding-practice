package problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

public class ValidAnagram {
    public boolean isAnagramI(String s, String t) {
      if(s.length()!=t.length()) return false;
      char ch[]=s.toCharArray();
      char ch1[]=t.toCharArray();
      Arrays.sort(ch);
      Arrays.sort(ch1);
      return Arrays.equals(ch,ch1);
    }
    public boolean isAnagramII(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            hash.put(ch1,hash.getOrDefault(ch1,0)+1);
            hash.put(ch2,hash.getOrDefault(ch2,0)-1);
        }
        for(Map.Entry<Character,Integer> entry:hash.entrySet()){
            if(entry.getValue()>0)
                return false;
        }
        return true;

    }
    public boolean isAnagramIII(String s, String t) {
        if(s.length()!=t.length()) return false;
        int hash[]=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for(int i:hash)
        {
            if(i!=0) return false;
        }
        return true;


    }

    public static void main(String[] args) {

    }
}
