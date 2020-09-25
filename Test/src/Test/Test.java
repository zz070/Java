package Test;

import java.util.*;


  class Interval {
      int start;
      int end;
  }

public class Test {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */


    public static Interval solve (int n, int k, String str1, String str2) {
        // write code here
        Interval val = new Interval();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        if(n == k){
            int count = 0;
            for(int i = 0;i< n;i++){
                if(c1[i] != c2[i]){
                    count++;
                }
            }
            if(count == 0){
                val.end = n;
                val.start = n;
            }else{
                val.end = n-count;
                val.end = n-count;
            }
            return val;
        }
        if(n>k){
            int count = 0;
            for(int i = 0;i< n;i++){
                if(c1[i] != c2[i]){
                    count++;
                }
            }
            if(count == 0){
                val.end = k;
            }else{
                if(count<=k) {
                    val.start = k - count;
                }else{
                    val.start = count - k;
                }
            }
            return val;
        }
        return val;
    }
}
