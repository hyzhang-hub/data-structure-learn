package primary.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Code02_LowestLexicography {

    public static String lowestString(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";
        for (String str :
                strs) {
            res += str;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
    }
}
